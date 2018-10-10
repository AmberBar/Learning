package com.amber.dao;

public class ProduceDaoImpl implements ProductDao {

    @Override
    public void create() {
        System.out.println("=========this is create method ==============");
    }

    @Override
    public void delete() {
        System.out.println("=========this is delete method ==============");
    }

    @Override
    public String update() {
        System.out.println("=========this is update method ==============");
        return "amber";
    }

    @Override
    public void addBatch() {
        System.out.println("=========this is addBatch method ==============");
    }

    @Override
    public void delBatch() {
        System.out.println("=========this is delBatch method ==============");
        int i = 1/0;
    }
}
