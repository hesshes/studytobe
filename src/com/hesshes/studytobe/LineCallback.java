package com.hesshes.studytobe;

//list 3-41
public interface LineCallback<T> {
    T doSomethingWithLine(String line, T value);
}
