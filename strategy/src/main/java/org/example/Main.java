package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        v1();

        v2();
    }

    public static void v1(){
        SampleService sampleService;
        sampleService = new SampleServiceImplV1();

        sampleService.runV1(new Act() {
            @Override
            public Object active() {
                return "Version 1 Active";
            }
        });

        sampleService.runV1(new Act() {
            @Override
            public Object active() {
                return "Version 2 Active";
            }
        });

        sampleService.runV1(() -> "Version 3 Active with lambda");
    }

    public static void v2(){
        SampleService sampleService;
        sampleService = new SampleServiceImplV1();

        sampleService.runV2(new ActV2() {
            @Override
            public String active(Object o1, Object o2) {
                String result = o1.toString() + o2.toString();

                return result;
            }
        }, "Hi !", " World!");

    }

}