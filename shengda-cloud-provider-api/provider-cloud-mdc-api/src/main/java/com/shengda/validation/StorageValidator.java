package com.shengda.validation;

import com.shengda.annotation.Storage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author takesi
 * @date 2020-03-20
 */
public class StorageValidator implements ConstraintValidator<Storage, String> {

    @Override
    public void initialize(Storage constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return true;
    }

}
