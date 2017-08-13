package com.softuni.exam.utils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by gery on 12.8.2017 г..
 */
public class DataValidator {
    public static <T> boolean  validate(T target){
        ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<T>> validate = factory.getValidator().validate(target);
        return validate.isEmpty();
    }
}
