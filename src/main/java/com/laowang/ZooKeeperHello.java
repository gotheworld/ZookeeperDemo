package com.laowang;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * Description:通过ZooKeeper创建节点
 * Author: wangfeng
 * Date: 16/12/5
 * Time: 下午5:06
 */
public class ZooKeeperHello {
    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeper zk = new ZooKeeper(Constant.ZK_NODE_IP, Constant.SESSION_TIMEOUT, new DemoWatcher());//连接zk server
        String node = Constant.ZK_NODE;
        Stat stat = zk.exists(node, false);//检测节点是否存在
        if (stat == null) {
            //创建节点
            String createResult = zk.create(node, "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(createResult);
        }
        //获取节点的值
        byte[] b = zk.getData(node, false, stat);
        System.out.println(new String(b));
        zk.close();
    }

    static class DemoWatcher implements Watcher {

        public void process(WatchedEvent event) {
            System.out.println("----------->");
            System.out.println("path:" + event.getPath());
            System.out.println("type:" + event.getType());
            System.out.println("stat:" + event.getState());
            System.out.println("<-----------");
        }
    }
}
