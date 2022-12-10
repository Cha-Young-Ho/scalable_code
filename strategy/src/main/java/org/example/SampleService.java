package org.example;

public interface SampleService<T, O> {

    T runV1(Act<T> act);
    <U> U runV2(ActV2 actV2, T o1, O o2);
}
