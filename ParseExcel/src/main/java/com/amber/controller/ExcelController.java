package com.amber.controller;

import com.amber.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/excel")
public class ExcelController {
    @Autowired
    ExcelService excelService;

    @PostMapping("/users")
    public void user(@RequestParam("file") String filePath) {
        excelService.importUsers(filePath);
    }

}
