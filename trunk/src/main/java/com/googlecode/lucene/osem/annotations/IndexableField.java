package com.googlecode.lucene.osem.annotations;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @author carlos
 * 
 */
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RUNTIME)
public @interface IndexableField {

    /**
     * name of the field, default to field name
     */
    String name() default "";

    /**
     * 
     */
    TypeEnum type() default TypeEnum.AUTO;

    /**
     * "index" field in mapping
     */
    IndexEnum indexed() default IndexEnum.NA;

    /**
     * "tokenized" field in mapping
     */
    TokenizedEnum tokenized() default TokenizedEnum.NA;

    /**
     * 
     */
    NormsEnabledEnum normsEnabled() default NormsEnabledEnum.NA;

    /**
     * 
     */
    IndexOptionsEnum indexOptions() default IndexOptionsEnum.NA;

    /**
     * "store" field in mapping
     */
    StoreEnum store() default StoreEnum.NA;

    /**
     * "boost" field in mapping
     */
    double boost() default Double.MIN_VALUE;

    /**
     * pattern format number and date
     */
    String format() default "";

    /**
     * 
     */
    boolean includeSearchAll() default true;

    /**
     * 
     */
    boolean includeSearchEmpty() default true;

    /**
     * 
     */
    boolean includeSearchNotEmpty() default true;

    /**
     * "null_value" field in mapping
     */
    String nullValue() default "";

}
