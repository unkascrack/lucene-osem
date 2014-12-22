package com.googlecode.lucene.osem;

public interface LuceneOsemManager {

    /**
     * @param name
     * @return
     */
    IndexManager getIndexManager(String name);
}
