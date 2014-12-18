package com.googlecode.lucene.osem.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.lucene.analysis.Analyzer;

/**
 * 
 * 
 * @author carlos
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Indexable {

    /**
     * TODO: revisar este tipo ¿como se debería definir el DIRECTORY
     */
    String directory() default "";

    /**
     * Index name, default to class name format
     */
    String name() default "";

    /**
     * Version index
     */
    VersionEnum version() default VersionEnum.NA;

    /**
     * 
     */
    IndexEnum indexed() default IndexEnum.ANALYZED;

    /**
     * "index_analyzer" fields in mapping
     */
    TypeAnalyzerEnum indexAnalyzer() default TypeAnalyzerEnum.NA;

    /**
     * "custom_analyzer"
     */
    Class<? extends Analyzer> customIndexAnalyzer() default TypeAnalyzerEnum.None.class;

    /**
     * "tokenized"
     */
    TokenizedEnum tokenized() default TokenizedEnum.YES;

    /**
     * 
     */
    StoreEnum store() default StoreEnum.NO;

    /**
     * "search_analyzer" field in mapping
     */
    TypeAnalyzerEnum searchAnalyzer() default TypeAnalyzerEnum.NA;

    /**
     * 
     */
    Class<? extends Analyzer> customSearchAnalyzer() default TypeAnalyzerEnum.None.class;

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
     * "date_formats" fields in mapping
     */
    String[] dateFormats() default {};

    //
    // boolean omitNorms() default true;
    //
    // IndexOptions indexOptions() default IndexOptions.DOCS_ONLY;
    //
    // boolean compress default false;
}
