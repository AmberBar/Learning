package com.amber.service;

public interface ExcelService {

    void importUsers(String userFilePath);

    void exportUsers() throws Exception;
}
