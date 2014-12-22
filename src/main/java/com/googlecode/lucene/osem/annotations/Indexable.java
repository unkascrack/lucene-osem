package com.googlecode.lucene.osem.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 
 * @author carlos
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Indexable {

    /**
     * 
     */
    IndexEnum indexed() default IndexEnum.ANALYZED;

    /**
     * 
     */
    TokenizedEnum tokenized() default TokenizedEnum.YES;

    /**
     * 
     */
    StoreEnum store() default StoreEnum.NO;

    /**
     * 
     */
    boolean allowSearchAll() default true;

    /**
     * 
     */
    boolean allowSearchEmpty() default true;

    /**
     * 
     */
    boolean allowSearchNotEmpty() default true;

    /**
     * 
     */
    String[] dateFormats() default {};

    //
    // boolean omitNorms() default true;
    //
    // IndexOptions indexOptions() default IndexOptions.DOCS_ONLY;
    //
    // boolean compress default false;
}
