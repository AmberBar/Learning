package com.amber.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSON;
import com.amber.data.User;
import com.amber.service.ExcelService;
import com.amber.utils.JsonFormatTool;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.*;


@Service
public class ExcelServiceImpl implements ExcelService {

    @Override
    public void exportUsers() throws Exception{
        List<User> users = new ArrayList<User>();
        users.add(new User("amber", "lei", "amberlei@123.com"));
        users.add(new User("amber", "lei", "amberlei@123.com"));
        users.add(new User("amber", "lei", "amberlei@123.com"));

        Workbook workbook  = ExcelExportUtil.exportExcel(new ExportParams("user information","users"),User.class, users);
        workbook.write(new FileOutputStream("C:\\Users\\amber.lei\\Documents\\Learning\\ParseExcel\\src\\main\\resources\\export_user.xls"));
    }

    @Override
    public void importUsers(String userFilePath) {
        try {
            ImportParams params = new ImportParams();
            List<User> users = ExcelImportUtil.importExcel(new File(userFilePath), User.class, params);
            File file = new File(userFilePath.replace(".xls", ".json"));
            if(!file.exists()){
                file.createNewFile();
            }
            String jsonString = JsonFormatTool.formatJson(JSON.toJSONString(users));
            Writer write = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            write.write(jsonString);
            write.flush();
            write.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
