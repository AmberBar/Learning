package com.amber.service;

import org.springframework.stereotype.Service;

@Service
public class SayHelloHessianImpl implements SayHelloHessian {
    @Override
    public String sayHello(String name) {
        int s = 1/0;
        return name;
    }
}
