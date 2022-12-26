package com.example.demo.proxyfactory;

import com.example.demo.cglib.ConcreteService;
import com.example.demo.cglib.ServiceImpl;
import com.example.demo.cglib.ServiceInterface;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;

import java.lang.reflect.Proxy;

public class ProxyFactoryMain {

    public static void main(String[] args) {
        //interfaceProxy();
        concreteProxy();
    }

    public static void interfaceProxy(){
        ServiceInterface target = new ServiceImpl();

        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();
        proxy.save();
        proxy.find();
        System.out.println(AopUtils.isAopProxy(proxy));
        System.out.println(AopUtils.isJdkDynamicProxy(proxy));
        System.out.println(AopUtils.isCglibProxy(proxy));
    }

    public static void concreteProxy(){
        ConcreteService target = new ConcreteService();

        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());
        ConcreteService proxy = (ConcreteService) proxyFactory.getProxy();
        proxy.call();
        System.out.println(AopUtils.isAopProxy(proxy)); // true
        System.out.println(AopUtils.isJdkDynamicProxy(proxy)); // false
        System.out.println(AopUtils.isCglibProxy(proxy)); // true
    }


    // Pointcut : 어디에 부가 기능을 적용할지, 어디에 부가 기능을 적용하지 않을지 판단하는 필터링 로직이다.
    //              주로 클래스와 메서드 이름으로 필터링 한다. 이름 그대로 어떤 포인트에 기능을 적용할지 하지 않을지 잘라서 구분하는 것이다.

    // Advice : 프록시가 호출하는 부가 기능이다. 단순히 프록시 로직이다.

    // Advisor : 단순하게 하나의 포인트컷과 하나의 어드바이스를 가지고 있는 것이다.

}
