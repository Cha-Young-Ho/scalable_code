public class TimeProxy extends ConcreteLogic{

    private ConcreteLogic concreteLogic;

    public TimeProxy(ConcreteLogic concreteLogic){
        this.concreteLogic = concreteLogic;
    }

    @Override
    public String operation(){
        System.out.println("Time Proxy 실행");

        long startTime = System.currentTimeMillis();

        String result = concreteLogic.operation();

        long endTime = System.currentTimeMillis();

        long resultTime = endTime - startTime;

        System.out.println("결과 시간 = " + resultTime);

        return result;
    }
}
