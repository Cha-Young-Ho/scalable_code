package com.example.demo.proxyfactory;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class TimeAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Advice 실행");

        // 이미 스프링에서 처음부터 target을 생성해놓기 때문에 별도이 생성자로 target을 초기화할 필요가 없다.
        // 아래의 proceed를 호출하면 target 클래스를 호출하고 그 결과를 받는다.
        Object result = invocation.proceed();
        return result;
    }
}
