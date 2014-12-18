package com.googlecode.lucene.osem.annotations;

import org.apache.lucene.util.Version;

public enum VersionEnum {

    /**
     * Use default value
     */
    NA,
    /**
     * 
     */
    LATEST,
    /**
     * 
     */
    LUCENE_4_10_2;

    public Version getVersion() {
        switch (this) {
            case LUCENE_4_10_2:
                return Version.LUCENE_4_10_2;
            case LATEST:
                return Version.LATEST;
            default:
                return null;
        }
    }

}
