package annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MyFirstAnnotaion {
    String name() default "lisi";
    int age() default 18;
    String data();
    String describe();
}
