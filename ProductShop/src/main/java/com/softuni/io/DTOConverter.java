package com.softuni.io;

import com.softuni.dto.viewModel.product.XMLWrapper;
import org.modelmapper.ModelMapper;

import java.util.List;

/**
 * Created on 3.8.2017 г..
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

    public <T> XMLWrapper wrapObjects(List<T> items) {
        XMLWrapper wrapper = new XMLWrapper();
        wrapper.setItems(items);
        return wrapper;
    }
}
