package jakarta.tutorial.billpayment.payment;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.inject.Qualifier;

/**
 * Qualifier for Debit payment events.
 */
@Qualifier @Retention(RUNTIME) @Target({METHOD, FIELD, PARAMETER, TYPE}) public @interface Debit {}
