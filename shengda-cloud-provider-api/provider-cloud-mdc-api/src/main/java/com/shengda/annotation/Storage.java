package com.shengda.annotation;

import com.shengda.validation.StorageValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author takesi
 * @date 2020-03-20
 */
@Documented
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StorageValidator.class)
public @interface Storage {

    String message() default "地址不存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
