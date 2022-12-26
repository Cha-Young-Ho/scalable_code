import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Time;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {

        //version1();

        //version2();

        //version3();

        version4();
    }

    // 구체 클래스를 실행하는 버전
    public static void version1(){
        ConcreteClient concreteClient = new ConcreteClient(new ConcreteLogic());
        concreteClient.execute();
    }

    // 구체 클래스 앞에 프록시를 넣는 버전
    public static void version2(){
        // 자바의 다형성은 인터페이스를 구현하든, 클래스를 상속하든 상위 타입만 맞으면 다형성이 적용된다.
        ConcreteClient concreteClient = new ConcreteClient(new TimeProxy(new ConcreteLogic()));
        concreteClient.execute();
    }

    // Reflection
    // 리플랙션은 클래스나 메서드의 메타정보를 사용해서 동적으로 호출하는 메서드를 변경할 수 있다.
    public static void version3(){
       ReflectionA target = new ReflectionA();
       target.callA();
       target.callB();
    }

    public static void version4() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class targetClass = Class.forName("ReflectionA");

        ReflectionA target = new ReflectionA();

        // callA
        Method methodCallA = targetClass.getMethod("callA");
        // target의 인스턴스에 있는 callA를 호출한다.
        Object result1 = methodCallA.invoke(target); // Call - B

        //callB
        Method methodCallB = targetClass.getMethod("callB");

        // target의 인스턴스에 있는 callB를 호출한다.
        Object result2 = methodCallB.invoke(target); // Call - A

        System.out.println("result1 = " + result1); // result1 = A
        System.out.println("result2 = " + result2); // result2 = B

        //이러한 방법으로 하는 경우 동적으로 어떠한 메소드를 호출할 지 판단할 수 있다.

    }

    public static void version5(){

    }


}