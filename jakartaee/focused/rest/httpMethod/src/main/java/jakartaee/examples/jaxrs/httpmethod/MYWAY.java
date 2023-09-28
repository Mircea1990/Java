package jakartaee.examples.jaxrs.httpmethod;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.ws.rs.HttpMethod;

/**
 * The MYWAY annotation.
 */
@Target({ElementType.METHOD}) @Retention(RetentionPolicy.RUNTIME) @HttpMethod("MYWAY") @Documented
public @interface MYWAY {}
