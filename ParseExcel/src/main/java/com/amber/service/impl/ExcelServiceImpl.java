package com.amber.service.impl;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSON;
import com.amber.data.convert.UserVOConvertToUser;
import com.amber.data.User;
import com.amber.data.vo.UserVO;
import com.amber.service.ExcelService;
import com.amber.utils.JsonFormatTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    UserVOConvertToUser userVOConvertToUser;

    @Override
    public void importUsers(String userFilePath) {
        try {
            ImportParams params = new ImportParams();
            List<UserVO> userVOS = ExcelImportUtil.importExcel(new File(userFilePath), UserVO.class, params);
            List<User> users = userVOConvertToUser.userVOConvertToUser(userVOS);
            File file = new File(userFilePath.replace(".xls", ".json"));
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
