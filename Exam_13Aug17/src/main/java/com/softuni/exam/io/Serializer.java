package com.softuni.exam.io;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by gery on 12.8.2017 г..
 */
@Component
public interface Serializer {
    <T> T deserialize(Class<T> tClass, String path);
    <T> void serialize(List<T> list, Class<T> obj, String path, String name);
}
