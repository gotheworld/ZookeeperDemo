package com.laowang;

import org.I0Itec.zkclient.ZkClient;

/**
 * Description:删除节点
 * Author: wangfeng
 * Date: 16/12/5
 * Time: 下午5:54
 */
public class DeleteZkNode {

    public static void main(String[] args) {
        ZkClient zkClient = new ZkClient(Constant.ZK_NODE_IP);
        String node = Constant.ZK_NODE;
        if (zkClient.exists(node)) {
            zkClient.delete(node);
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }
}
