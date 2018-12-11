package com.amber.controller;

import com.amber.bean.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 消费者里面不应该有service层
 */
@RestController
@RequestMapping("/consumer/dept")
public class DeptController {

//    private  static final  String REST_URL_PREFIX="http://localhost:8001";
    //换成微服务前面的名字
    private static final String REST_URL_PREFIX = "http://COULD-DEPT-PROVIDE-DEPT";
    @Autowired
    RestTemplate restTemplate;

    @PostMapping("")
    public void add(Dept dept){
        restTemplate.postForObject(REST_URL_PREFIX + "/dept", dept, Dept.class);
    }


    @RequestMapping(value = "/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/" + id, Dept.class);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "")
    public List<Dept> list()
    {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept", List.class);
    }

}
