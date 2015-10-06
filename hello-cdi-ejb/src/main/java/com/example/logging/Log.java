package com.example.logging;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;

@Target({ METHOD, FIELD, PARAMETER, TYPE })
@Retention(RUNTIME)
@Qualifier
public @interface Log {
    /**
     * @return logger名.
     */
    @Nonbinding
    String value() default "";
}
