package com.softuni.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * Created on 3.8.2017 г..
 */
@Component
public class JsonParser implements Parser {
    private Gson gson;
    private FileIO fileIO;

    @Autowired
    public JsonParser(FileIO fileIO) {
        this.fileIO = fileIO;
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    public <T> T getObject(Class<T> tClass, String path) {
        T obj = null;
        String json = this.fileIO.readFile(path);
        obj = this.gson.fromJson(json, tClass);
        return obj;
    }

    public <T> void writeObject(T tClass, String path) {
        String contentAsJson = this.gson.toJson(tClass);
        try {
            File file = new File(System.getProperty("user.dir") + "/" + path);
            if(!file.exists()){
                file.getParentFile().mkdir();
                file.createNewFile();
            }
            this.fileIO.writeOnFile(path, contentAsJson);
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
