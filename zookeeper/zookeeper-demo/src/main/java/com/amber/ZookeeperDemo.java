package com.amber;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;


public class ZookeeperDemo {
    private ZooKeeper zookeeper;
    public ZooKeeper zkConnect( ) throws IOException {
        String path = "127.0.0.1:2181";
        zookeeper = new ZooKeeper(path, 20 * 1000, null);
        return zookeeper;
    }

    public void createZnode(String path, byte[] value, Watcher watcher, CreateMode node ) throws KeeperException, InterruptedException {
        zookeeper.create(path, value, ZooDefs.Ids.OPEN_ACL_UNSAFE, node);
    }

    public String getZnodeValue(String path ) throws KeeperException, InterruptedException {
        byte[] data = zookeeper.getData(path, false, new Stat());
        return new String(data);
    }

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        //创建
        ZookeeperDemo zookeeperDemo = new ZookeeperDemo();
        ZooKeeper zooKeeper = zookeeperDemo.zkConnect();
//        zookeeperDemo.createZnode("/amber", "hahaha".getBytes(), null, CreateMode.EPHEMERAL_SEQUENTIAL);
        String znodeValue = zookeeperDemo.getZnodeValue("/amber");
        System.out.println(znodeValue);

        Thread.sleep(1000 * 60 * 50);
    }
}
