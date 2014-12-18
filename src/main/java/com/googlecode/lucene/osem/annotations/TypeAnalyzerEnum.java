package com.googlecode.lucene.osem.annotations;

import org.apache.lucene.analysis.Analyzer;

public enum TypeAnalyzerEnum {

    /**
     * Use default value
     */
    NA,
    /**
     * "standard" analyzer
     */
    STANDARD,
    /**
     * "whitespaces" analyzer
     */
    WHITESPACES,
    /**
     * custom analyzer, necesary set property "customAnalyzer"
     */
    CUSTOM;

    public abstract static class None extends Analyzer {
        /**
         * Not to be instantiated
         */
        private None() {
        }
    }
}
