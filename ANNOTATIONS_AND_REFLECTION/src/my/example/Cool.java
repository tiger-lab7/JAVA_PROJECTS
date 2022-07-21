package my.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

enum DescriptionEnum {
    TYPE1, TYPE2
}


@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface Cool {
    int level();

    String[] tags();

    DescriptionEnum description();

    String other() default "";
}