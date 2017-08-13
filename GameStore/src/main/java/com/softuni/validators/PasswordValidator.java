package com.softuni.validators;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created on 31.7.2017 г..
 */
@Component
public class PasswordValidator implements ConstraintValidator<Password, String> {
   public void initialize(Password constraint) {
   }

   public boolean isValid(String password, ConstraintValidatorContext context) {
      Pattern pattern = Pattern.compile("[a-z]");
      Matcher matcher = pattern.matcher(password);
      if(!matcher.find()) {
         return false;
      }
      pattern = Pattern.compile("[A-Z]");
      matcher = pattern.matcher(password);
      if(!matcher.find()) {
         return false;
      }
      pattern = Pattern.compile("[0-9]");
      matcher = pattern.matcher(password);
      if(!matcher.find()) {
         return false;
      }
      return true;
   }
}
