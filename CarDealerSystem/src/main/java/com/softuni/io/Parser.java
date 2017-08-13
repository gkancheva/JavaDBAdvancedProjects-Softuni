package com.softuni.io;

/**
 * Created on 8.8.2017 г..
 */
public interface Parser {
    <T> T getObject(Class<T> tClass, String path);
    <T> void writeObject(T tClass, String path);
}
