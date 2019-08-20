package com.kagura.jdbc;

import io.shardingsphere.api.config.rule.ShardingRuleConfiguration;
import io.shardingsphere.api.config.rule.TableRuleConfiguration;
import io.shardingsphere.api.config.strategy.InlineShardingStrategyConfiguration;
import io.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/20 10:25
 * @since 1.0.0
 */
public class TestDataSource {

    public static DataSource createDataSource() throws SQLException {
        // 配置真实数据源
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        // 配置第一个数据源
        BasicDataSource dataSource1 = new BasicDataSource();
        dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource1.setUrl("jdbc:mysql://localhost:3306/ds0");
        dataSource1.setUsername("root");
        dataSource1.setPassword("123456");
        dataSourceMap.put("ds0", dataSource1);
        // 配置第二个数据源
        BasicDataSource dataSource2 = new BasicDataSource();
        dataSource2.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource2.setUrl("jdbc:mysql://localhost:3306/ds1");
        dataSource2.setUsername("root");
        dataSource2.setPassword("123456");
        dataSourceMap.put("ds1", dataSource2);

        // 配置Order表规则START
        // order根据user_id取模来分配库
        // order根据order_id取模来分配表
        TableRuleConfiguration orderTableRuleConfig = new TableRuleConfiguration();
        orderTableRuleConfig.setLogicTable("t_order");
        orderTableRuleConfig.setActualDataNodes("ds${0..1}.t_order${0..1}");
        // 配置分库 + 分表策略
        orderTableRuleConfig.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration(
                "user_id", "ds${user_id % 2}"));
        orderTableRuleConfig.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration(
                "order_id", "t_order${order_id % 2}"));
        // 配置分片规则
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        shardingRuleConfig.getTableRuleConfigs().add(orderTableRuleConfig);
        // END

        // 配置order_item表规则START
        TableRuleConfiguration itemTableRuleConfig = new TableRuleConfiguration();
        itemTableRuleConfig.setLogicTable("t_order_item");
        itemTableRuleConfig.setActualDataNodes("ds${0..1}.t_order_item${0..1}");
        shardingRuleConfig.getTableRuleConfigs().add(itemTableRuleConfig);

        // 获取数据源对象
        return ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig,
                new ConcurrentHashMap(), new Properties());
    }

    public static javax.sql.DataSource dataSource;

    public static void execute(final String sql) throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        statement.execute(sql);
    }
    public static void createTable() throws SQLException {
        execute("CREATE TABLE IF NOT EXISTS t_order " +
                "(order_id BIGINT NOT NULL AUTO_INCREMENT, user_id INT NOT NULL, " +
                "status VARCHAR(50), PRIMARY KEY (order_id))");
        execute("CREATE TABLE IF NOT EXISTS t_order_item " +
                "(order_item_id BIGINT NOT NULL AUTO_INCREMENT," +
                "order_id BIGINT NOT NULL, user_id INT NOT NULL, " +
                "PRIMARY KEY (order_item_id))");
    }

    public static void insert() throws SQLException {
        for (int i = 1; i < 10; i++) {
            long orderId = insertAndGetGeneratedKey("INSERT INTO t_order (user_id, status) VALUES (10, '" + i +"')");
            execute(String.format("INSERT INTO t_order_item (order_id, user_id) VALUES (%d, 10)", orderId));
            orderId = insertAndGetGeneratedKey("INSERT INTO t_order (user_id, status) VALUES (11, '" + i + "')");
            execute(String.format("INSERT INTO t_order_item (order_id, user_id) VALUES (%d, 11)", orderId));
        }
    }

    public static long insertAndGetGeneratedKey(final String sql) throws SQLException {
        long result = -1;
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            resultSet.getLong(1);
        }
        return result;
    }

    public static void main(String[] args) throws SQLException {
        TestDataSource.dataSource = createDataSource();
        createTable();
        insert();


    }
}
