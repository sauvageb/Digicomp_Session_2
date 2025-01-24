package com.training.demo.csv;

public interface CSVMapper<T, K> {
    T mapTo(K k);

    K unmapFrom(T t);
}