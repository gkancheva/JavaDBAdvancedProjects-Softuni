package com.softuni.io;

import org.springframework.stereotype.Component;

/**
 * Created on 5.8.2017 г..
 */
@Component
public interface Parser {
    <T> T getObject(Class<T> tClass, String path);
    <T> void writeObject(T tClass, String path);
}
