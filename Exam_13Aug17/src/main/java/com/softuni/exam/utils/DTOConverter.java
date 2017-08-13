package com.softuni.exam.utils;

import org.modelmapper.ModelMapper;

/**
 * Created by gery on 12.8.2017 г..
 */
public class DTOConverter {
    private static ModelMapper modelMapper;

    private static ModelMapper getInstance() {
        if(modelMapper == null) {
            modelMapper = new ModelMapper();
        }
        return modelMapper;
    }

    public static <T, O> O convert(T objIn, Class<O> outClass) {
        return getInstance().map(objIn, outClass);
    }

}
