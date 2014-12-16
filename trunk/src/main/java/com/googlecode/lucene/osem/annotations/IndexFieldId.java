package com.googlecode.lucene.osem.annotations;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.apache.lucene.index.FieldInfo.IndexOptions;

/**
 * @author carlos
 * 
 */
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RUNTIME)
public @interface IndexFieldId {

    /**
     * @return
     */
    String name() default "";

    /**
     * @return
     */
    Type type() default Type.NA;

    /**
     * @return
     */
    boolean indexed() default true;

    /**
     * @return
     */
    boolean tokenized() default true;

    /**
     * @return
     */
    boolean omitNorms() default true;

    /**
     * @return
     */
    IndexOptions indexOptions() default IndexOptions.DOCS_ONLY;

    /**
     * @return
     */
    boolean store() default false;

    /**
     * @return
     */
    float boost() default 1.0f;
}
