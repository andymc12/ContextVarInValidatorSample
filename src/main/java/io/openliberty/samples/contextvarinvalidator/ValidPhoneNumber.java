package io.openliberty.samples.contextvarinvalidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.FIELD })
@Constraint(validatedBy = { PhoneNumberValidator.class })
public @interface ValidPhoneNumber {
    String message() default "Phone number is not valid!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}