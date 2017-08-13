package com.softuni.utils;

import com.softuni.models.bindingModels.user.RegisterUser;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created on 1.8.2017 г..
 */
public class DataValidator {

    public static <T> String getInvalidParameterMessage(T target){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<T>> constraints = factory
                .getValidator().validate(target);
        if(!constraints.isEmpty()) {
            for (ConstraintViolation<T> c : constraints) {
                return c.getMessage();
            }
        }
        return null;
    }

    public static <T> boolean checkIsValid(T target){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<T>> constraints = factory
                .getValidator().validate(target);
        if(!constraints.isEmpty()) {
            for (ConstraintViolation<T> c : constraints) {
                return false;
            }
        }
        return true;
    }

}
