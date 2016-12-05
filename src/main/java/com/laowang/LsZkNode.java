package com.laowang;

import org.I0Itec.zkclient.ZkClient;

import java.util.List;

/**
 * Description:获取所有节点
 * Author: wangfeng
 * Date: 16/12/5
 * Time: 下午5:56
 */
public class LsZkNode {

    public static void main(String[] args) {
        ZkClient zkClient = new ZkClient(Constant.ZK_NODE_IP);

        System.out.println("获取所有的节点");
        List<String> allNodeList = zkClient.getChildren("/");
        if(allNodeList != null && allNodeList.size() > 0) {
            for (String node : allNodeList) {
                System.out.println(node);
            }
        }
    }
}
