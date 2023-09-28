package jakarta.tutorial.traffic.rar.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* Annotation to decorate methods in the MDB */
@Target({ElementType.METHOD}) @Retention(RetentionPolicy.RUNTIME) public @interface TrafficCommand {
    String name() default "";

    String info() default "";
}
