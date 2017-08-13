package com.softuni.modelParser;

import org.modelmapper.ModelMapper;

/**
 * Created on 31.7.2017 г..
 */
public class ModelParser {
    private static ModelMapper modelMapper;

    public static ModelMapper getInstance() {
        if(modelMapper == null) {
            modelMapper = new ModelMapper();
        }
        return modelMapper;
    }
}