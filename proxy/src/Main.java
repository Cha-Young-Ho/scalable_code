import jdkdynamic.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {

        //dynamicProxyCall();

        jdkDynamicProxy();
    }

    // 동적 프록시 호출
    public static void dynamicProxy(Method method, Object target) throws InvocationTargetException, IllegalAccessException {
        Object result = method.invoke(target);

        System.out.println("result = " + result);
    }

    public static void dynamicProxyCall() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class targetClass = Class.forName("ReflectionA");
        ReflectionA target = new ReflectionA();
        // Call - A
        Method methodCallA = targetClass.getMethod("callA");
        dynamicProxy(methodCallA, target);

        // Call - B
        Method methodCallB = targetClass.getMethod("callB");
        dynamicProxy(methodCallB, target);

    }


    // JDK Dynamic Proxy
    // 프록시 객체를 동적으로 런타임에 개발자 대신 만들어주는 기술
    // 인터페이스를 기반으로 동적 프록시를 생성해준다.
    public static void jdkDynamicProxy(){
        AInterface targetA = new AImpl();

        TimeInvocationHandler timeInvocationHandlerA = new TimeInvocationHandler(targetA);

        AInterface proxyA = (AInterface) Proxy.newProxyInstance(AInterface.class.getClassLoader(), new Class[]{AInterface.class}, timeInvocationHandlerA);
        // 1. 가장 먼저 proxy의 call이 호출된다.
        // 2. proxy의 call은 handler의 invoke를 수행한다.
        // 3. 호출할 때 "call"을 호출했으니 handler의 method 또한 call을 수행한다.
        proxyA.call();

        BInterface targetB = new BImpl();
        TimeInvocationHandler timeInvocationHandlerB = new TimeInvocationHandler(targetB);

        BInterface proxyB = (BInterface) Proxy.newProxyInstance(BInterface.class.getClassLoader(), new Class[]{BInterface.class}, timeInvocationHandlerB);

        proxyB.call();

    }
}