package com.laowang;

import org.I0Itec.zkclient.ZkClient;

/**
 * Description:获取节点值
 * Author: wangfeng
 * Date: 16/12/5
 * Time: 下午5:51
 */
public class GetZkNode {
    public static void main(String[] args) {
        ZkClient zkClient = new ZkClient(Constant.ZK_NODE_IP);
        String node = Constant.ZK_NODE;
        if (zkClient.exists(node)) {
            System.out.println("节点路径:" + node + "  值:" + zkClient.readData(node));
        }else {
            System.out.println("节点不存在");
        }
    }
}
