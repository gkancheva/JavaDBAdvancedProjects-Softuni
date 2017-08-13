package com.softuni.validators;

import com.softuni.models.bindingModels.user.RegisterUser;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created on 31.7.2017 г..
 */
@Component
public class PasswordMatchingValidator implements ConstraintValidator<PasswordMatching, Object> {
   public void initialize(PasswordMatching constraint) {
   }

   public boolean isValid(Object obj, ConstraintValidatorContext context) {
      if(obj instanceof RegisterUser) {
         RegisterUser regUser = (RegisterUser)obj;
         return regUser.getPassword().equals(regUser.getConfirmPassword());
      }
      return false;
   }
}
