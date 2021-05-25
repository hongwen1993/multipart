package com.kagura.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2021/5/26 0:22
 * @since 1.0.0
 */
@EnableTransactionManagement
@Configuration
public class Transaction222 {

    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    @PostConstruct
    public void init() {
        dataSourceTransactionManager.setNestedTransactionAllowed(true);
    }

}
