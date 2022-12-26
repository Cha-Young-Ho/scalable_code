package com.example.demo.cglib;

import org.springframework.cglib.proxy.Enhancer;

public class CglibMain {
    public static void main(String[] args) {
        ConcreteService concreteService = new ConcreteService();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConcreteService.class);
        enhancer.setCallback(new TimeMethodInterceptor(concreteService));
        ConcreteService proxy = (ConcreteService) enhancer.create();

        proxy.call();
    }
}
