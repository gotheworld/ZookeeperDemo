package com.laowang;

import org.I0Itec.zkclient.ZkClient;

/**
 * Description:通过ZkClient创建节点
 * Author: wangfeng
 * Date: 16/12/5
 * Time: 下午5:37
 */
public class CreateZkNode {

    public static void main(String[] args) {
        ZkClient zkClient = new ZkClient(Constant.ZK_NODE_IP);
        String node = Constant.ZK_NODE;
        if (!zkClient.exists(node)) {
            zkClient.createPersistent(node, "hello zk");
        }
        System.out.println(zkClient.readData(node));
    }
}
