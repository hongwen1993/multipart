package com.kagura;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;
import org.apache.zookeeper.*;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author <a href="mailto:hongwen0928@outlook.com">Karas</a>
 * @date 2019/8/21 11:48
 * @since 1.0.0
 */
public class Test02 {

    /** zookeeper地址 */
    public static final String CONNECT_ADDR = "127.0.0.1:2181";
    /** session超时时间 */
    public static final int SESSION_OUTTIME = 2000;//ms
    public static final CountDownLatch connectedSemaphore = new CountDownLatch(1);


    @Test
    public void test01() throws InterruptedException, IOException, KeeperException {
        ZooKeeper zk = new ZooKeeper(CONNECT_ADDR, SESSION_OUTTIME, new Watcher(){
            @Override
            public void process(WatchedEvent event) {
                // 获取事件的状态
                Event.KeeperState keeperState = event.getState();
                Event.EventType eventType = event.getType();
                // 如果是建立连接
                if(Event.KeeperState.SyncConnected == keeperState){
                    if(Event.EventType.None == eventType){
                        // 如果建立连接成功，则发送信号量，让后续阻塞程序向下执行
                        connectedSemaphore.countDown();
                        System.out.println("zk 建立连接");
                    }
                }
            }
        });

        // 进行阻塞 - CountDownLatch为0时释放，可以使用标记加上自旋锁进行替代
        connectedSemaphore.await();
        System.err.println("\n阻塞结束");
        // 创建父节点
		//zk.create("/testRoot", "testRoot".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        //创建子节点
		//zk.create("/testRoot/children", "children data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

        //获取节点洗信息
		//byte[] data = zk.getData("/testRoot", false, null);
		//System.out.println(new String(data));
		//System.out.println(zk.getChildren("/testRoot", false));

        //修改节点的值
//		zk.setData("/testRoot", "modify data root".getBytes(), -1);
//		byte[] data = zk.getData("/testRoot", false, null);
//		System.out.println(new String(data));

        //判断节点是否存在
		//System.out.println(zk.exists("/testRoot/children", false));
        //删除节点
		zk.delete("/testRoot/children", -1);
//		System.out.println(zk.exists("/testRoot/children", false));


        zk.close();
    }
}
