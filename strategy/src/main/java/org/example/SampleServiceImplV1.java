package org.example;

public class SampleServiceImplV1 implements SampleService{

    @Override
    public Object runV1(Act act) {
        Object result = act.active();
        System.out.println(result);
        return result;
    }

    @Override
    public Object runV2(ActV2 actV2, Object o1, Object o2) {

        System.out.println(actV2.active(o1, o2));
        return actV2.active(o1, o2);
    }


}
