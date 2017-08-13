package com.softuni.exam.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.softuni.exam.exceptions.DeserializeException;
import com.softuni.exam.exceptions.SerializeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by gery on 12.8.2017 г..
 */
@Component
public class JsonSerializer implements Serializer {
    private Gson gson;
    private FileIO fileIO;

    @Autowired
    public JsonSerializer(FileIO fileIO) {
        this.fileIO = fileIO;
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .setDateFormat("yyyy-MM-dd'T'hh:mm:ss")
                .create();
    }

    @Override
    public <T> T deserialize(Class<T> tClass, String path) {
        try {
            String json = this.fileIO.readFile(path);
            return this.gson.fromJson(json, tClass);
        } catch (IOException e) {
            throw new DeserializeException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public <T> void serialize(List<T> list, Class<T> obj, String path, String name) {
        String contentAsJson = this.gson.toJson(list);
        try {
            this.fileIO.writeOnFile(path, contentAsJson);
        } catch (IOException e) {
            throw new SerializeException(e.getMessage(), e.getCause());
        }
    }
}
