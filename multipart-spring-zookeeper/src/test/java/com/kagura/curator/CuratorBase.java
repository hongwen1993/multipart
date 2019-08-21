package com.kagura.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/21 16:49
 * @since 1.0.0
 */
public class CuratorBase {


    /** zookeeper地址 */
    static final String CONNECT_ADDR = "127.0.0.1:2181";
    /** session超时时间 */
    static final int SESSION_OUTTIME = 5000;//ms

    public static CountDownLatch latch = new CountDownLatch(1);

    @Test
    public void test01() throws Exception {

        //1 重试策略：初试时间为1s 重试10次
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 10);
        //2 通过工厂创建连接
        CuratorFramework cf = CuratorFrameworkFactory.builder()
                .connectString(CONNECT_ADDR)
                .sessionTimeoutMs(SESSION_OUTTIME)
                .retryPolicy(retryPolicy)
//					.namespace("super")
                .build();
        //3 开启连接
        cf.start();
		System.out.println(ZooKeeper.States.CONNECTED);
		System.out.println(cf.getState());

		// 默认创建节点为持久化节点
        //cf.create().forPath("/test01", "aaaaaa".getBytes());
        // 递归创建 - 重要
		//cf.create().creatingParentsIfNeeded().forPath("/test02/01", "aaaaaa".getBytes());
        // 只有叶子节点为非持久化节点，zookeeper规定了非叶子节点必须为持久化节点
        //cf.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath("/test02");
        // 如果不存在则为null
        //System.err.println(cf.checkExists().forPath("/test03"));
        // 创建临时节点
        //cf.create().withMode(CreateMode.EPHEMERAL).forPath("/test03");

        // 删除/test01节点 - 只能删除叶子节点 - 节点不存在则报错
        //cf.delete().forPath("/test01");
        // 递归删除
        //cf.delete().deletingChildrenIfNeeded().forPath("/test02");
        // 强制删除
        //cf.delete().guaranteed().forPath("/test02");

        // 获取某个节点的值
        //byte[] bytes = cf.getData().forPath("/test01");
        //System.err.println(new String(bytes));
        // 设置某个节点的值
        //cf.setData().forPath("/test01", "bbbbbbbb".getBytes());

        // czxid表示节点创建时的zxid
        // mzxid表示节点最后一次修改时的zxid
        //Stat stat = new Stat();

        // 回调函数
        //cf.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT)
        //        .inBackground((client, event) -> {
        //            System.err.println("异步方法执行中");
        //            System.err.println(event.getType());
        //            System.err.println(event.getResultCode());
        //            latch.countDown();
        //        }, Executors.newFixedThreadPool(2))
        //        .forPath("/test/01", "cccccc".getBytes());
        //latch.await();





    }

}
