package com.googlecode.lucene.osem.annotations;

/**
 * "index_options" field in mapping
 * 
 * @author carlos
 */
public enum IndexOptionsEnum {
    /**
     * Use default value
     */
    NA,

    /**
     * Set "index_options" to "docs"
     */
    DOCS,

    /**
     * Set "index_options" to "freqs"
     */
    FREQS,

    /**
     * Set "index_options" to "positions"
     */
    POSITIONS,

    /**
     * Set "index_options" to "offsets"
     */
    OFFSETS
}
