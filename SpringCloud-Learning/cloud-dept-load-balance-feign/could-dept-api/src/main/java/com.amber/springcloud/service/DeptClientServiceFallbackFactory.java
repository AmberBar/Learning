package com.amber.springcloud.service;

import com.amber.springcloud.bean.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            public Dept get(Integer id) {
                Dept dept = new Dept();
                dept.setId(id);
                dept.setDbSource("error");
                dept.setDeptName("没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭");
                return dept;
            }

            public List<Dept> list() {
                return null;
            }

            public Dept add(Dept dept) {
                return null;
            }
        };
    }
}
