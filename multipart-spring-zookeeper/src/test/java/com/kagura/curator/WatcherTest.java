package com.kagura.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/22 9:45
 * @since 1.0.0
 */
public class WatcherTest {

    /** zookeeper地址 */
    static final String CONNECT_ADDR = "127.0.0.1:2181";
    /** session超时时间 */
    static final int SESSION_OUTTIME = 5000;//ms

    public static CountDownLatch latch = new CountDownLatch(1);


    public static final String NODE_CACHE_TEST_PATH = "/node_cache_test";
    public static final String NODE_CACHE_TEST_CHILD_PATH = "/node_cache_test/01";


    @Test
    public void test01() throws Exception {
        //1 重试策略：初试时间为1s 重试10次
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 10);
        //2 通过工厂创建连接
        CuratorFramework cf = CuratorFrameworkFactory.builder()
                .connectString(CONNECT_ADDR)
                .sessionTimeoutMs(SESSION_OUTTIME)
                .retryPolicy(retryPolicy)
                .build();

        //3 建立连接
        cf.start();

        // 有时候为 true 会报错
        NodeCache cache = new NodeCache(cf, NODE_CACHE_TEST_PATH, false);
        // 是否初始化
        cache.start(true);
        cache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.err.println(String.format("path : %s", cache.getCurrentData().getPath()));
                System.err.println(String.format("data : %s", new String(cache.getCurrentData().getData())));
                //latch.countDown();
            }
        });
        //latch.await();
        Thread.sleep(2000);
        cf.create().creatingParentsIfNeeded().forPath(NODE_CACHE_TEST_PATH);
        Thread.sleep(2000);
        cf.setData().forPath(NODE_CACHE_TEST_PATH, "xxx".getBytes());
        Thread.sleep(2000);
        cf.delete().forPath(NODE_CACHE_TEST_PATH);
        Thread.sleep(5000);

    }
}
