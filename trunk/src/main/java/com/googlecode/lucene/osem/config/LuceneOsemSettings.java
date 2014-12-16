package com.googlecode.lucene.osem.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LuceneOsemSettings {

    private final Map<String, Object> settings;

    public LuceneOsemSettings() {
        settings = new ConcurrentHashMap<String, Object>();
    }
}
