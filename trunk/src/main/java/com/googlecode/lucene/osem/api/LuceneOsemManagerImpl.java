package com.googlecode.lucene.osem.api;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.googlecode.lucene.osem.IndexManager;
import com.googlecode.lucene.osem.LuceneOsemManager;

public class LuceneOsemManagerImpl implements LuceneOsemManager {

    private final ConcurrentMap<String, IndexManager> indexManagerMap = new ConcurrentHashMap<String, IndexManager>();

    @Override
    public IndexManager getIndexManager(final String name) {
        if (!indexManagerMap.containsKey(name)) {
            throw new IllegalArgumentException("IndexManager name not found!");
        }
        return indexManagerMap.get(name);
    }

}
