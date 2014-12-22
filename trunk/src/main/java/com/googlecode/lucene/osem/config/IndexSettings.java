package com.googlecode.lucene.osem.config;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.util.InfoStream;
import org.apache.lucene.util.PrintStreamInfoStream;
import org.apache.lucene.util.Version;

/**
 * @author carlos
 * 
 */
public class IndexSettings {

    private final String name;
    private Version version;
    private Analyzer analyzer;
    private OpenMode openMode = OpenMode.CREATE_OR_APPEND;
    private InfoStream infoStream;
    private final Set<Class<?>> mappings = new HashSet<Class<?>>();

    public IndexSettings(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public IndexSettings setVersion(final Version version) {
        this.version = version;
        return this;
    }

    public Version getVersion() {
        return version;
    }

    public IndexSettings setAnalyzer(final Analyzer analyzer) {
        this.analyzer = analyzer;
        return this;
    }

    public Analyzer getAnalyzer() {
        return analyzer;
    }

    public IndexSettings setOpenMode(final OpenMode openMode) {
        if (openMode == null) {
            throw new IllegalArgumentException("openMode must not be null");
        }
        this.openMode = openMode;
        return this;
    }

    public OpenMode getOpenMode() {
        return openMode;
    }

    public IndexSettings setInfoStream(final InfoStream infoStream) {
        this.infoStream = infoStream;
        return this;
    }

    public IndexSettings setInfoStream(final PrintStream printStream) {
        infoStream = new PrintStreamInfoStream(printStream);
        return this;
    }

    public InfoStream getInfoStream() {
        return infoStream;
    }

    public IndexSettings addClass(final Class<?> indexableClass) {
        mappings.add(indexableClass);
        return this;
    }

    // TODO: include??
    // config.getMergeScheduler();
    // config.getCodec();
    // config.getReaderPooling();
    // config.getWriteLockTimeout()
    // config.getIndexCommit()
    // config.getFlushPolicy()
    // config.getIndexDeletionPolicy()
    // config.getTermIndexInterval()
    // config.getCheckIntegrityAtMerge()
    // config.getMergePolicy()
    // config.getMergedSegmentWarmer()
}
