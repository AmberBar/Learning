package com.amber.xml.dao;

public interface AccountDao {

    public void recive(String name, double money);

    public void send(String name, double money);
}
