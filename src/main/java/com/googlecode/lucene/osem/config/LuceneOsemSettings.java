package com.googlecode.lucene.osem.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.lucene.index.IndexWriter;

public class LuceneOsemSettings {

    private final Map<String, Object> settings;

    public LuceneOsemSettings() {
        settings = new ConcurrentHashMap<String, Object>();
    }

    // default lucene version

    // default analyzer

    // default open mode

    // public IndexWriterConfig setInfoStream(PrintStream printStream)

    /**
     * Specifies the open mode for {@link IndexWriter}.
     */
    public static enum OpenMode {
        /**
         * Creates a new index or overwrites an existing one.
         */
        CREATE,

        /**
         * Opens an existing index.
         */
        APPEND,

        /**
         * Creates a new index if one does not exist,
         * otherwise it opens the index and documents will be appended.
         */
        CREATE_OR_APPEND
    }

    // IndexWriterConfig cfg = new IndexWriterConfig(matchVersion, analyzer)
    // IndexWriter i = new IndexWriter(Directory, IndexWriterConfig)
}
