package com.amber.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSON;
import com.amber.data.Roles;
import com.amber.data.User;
import com.amber.utils.JsonFormatTool;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.relation.Role;
import java.io.*;
import java.util.List;

@RestController
@RequestMapping("/excel")
public class ExcelController {

    @GetMapping("/roles")
    public void roles() {
        try {
            ImportParams params = new ImportParams();
            List<Roles> roles = ExcelImportUtil.importExcel(new File("D:\\workspace\\src\\main\\java\\com\\amber\\utils\\roles.xls"), Roles.class, params);
            File file = new File("./roles_parse.json");
            if (!file.exists()) {
                file.createNewFile();
            }
            // 格式化json字符串
            String jsonString = JsonFormatTool.formatJson(JSON.toJSONString(roles));

            // 将格式化后的字符串写入文件
            Writer write = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            write.write(jsonString);
            write.flush();
            write.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/user")
    public void user() {
        try {
            ImportParams params = new ImportParams();
            List<User> users = ExcelImportUtil.importExcel(new File("D:\\workspace\\src\\main\\java\\com\\amber\\utils\\users.xls"), User.class, params);
            File file = new File("./user_parse.json");
            if(!file.exists()){
                file.createNewFile();
            }
            // 格式化json字符串
            String jsonString = JsonFormatTool.formatJson(JSON.toJSONString(users));

            // 将格式化后的字符串写入文件
            Writer write = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            write.write(jsonString);
            write.flush();
            write.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
