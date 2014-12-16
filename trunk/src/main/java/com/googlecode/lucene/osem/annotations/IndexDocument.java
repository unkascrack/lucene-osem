package com.googlecode.lucene.osem.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 
 * @author carlos
 * 
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface IndexDocument {

    // /**
    // * @return
    // */
    // boolean indexed() default true;
    //
    // /**
    // * @return
    // */
    // boolean tokenized() default true;
    //
    // /**
    // * @return
    // */
    // boolean omitNorms() default true;
    //
    // /**
    // * @return
    // */
    // IndexOptions indexOptions() default IndexOptions.DOCS_ONLY;
    //
    // /**
    // * @return
    // */
    // boolean store() default false;
    //
    // /**
    // * @return
    // */
    // float boost() default 1.0f;
}
