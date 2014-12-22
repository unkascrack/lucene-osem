package com.googlecode.lucene.osem.config;

import java.io.PrintStream;
import java.util.Collection;
import java.util.HashSet;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.util.InfoStream;
import org.apache.lucene.util.PrintStreamInfoStream;
import org.apache.lucene.util.Version;

import com.googlecode.lucene.osem.LuceneOsemManager;

/**
 * @author carlos
 * 
 */
public final class LuceneOsemSettings {

    private final Version version;
    private final Analyzer analyzer;
    private InfoStream infoStream;
    private final Collection<IndexSettings> indexSettingsCollection;

    public LuceneOsemSettings(final Version version, final Analyzer analyzer) {
        indexSettingsCollection = new HashSet<IndexSettings>();
        this.version = version;
        this.analyzer = analyzer;
    }

    public Analyzer getAnalyzer() {
        return analyzer;
    }

    public Version getVersion() {
        return version;
    }

    /**
     * Information about merges, deletes and a
     * message when maxFieldLength is reached will be printed
     * to this. Must not be null, but {@link InfoStream#NO_OUTPUT} may be used to supress output.
     */
    public LuceneOsemSettings setInfoStream(final InfoStream infoStream) {
        this.infoStream = infoStream;
        return this;
    }

    /**
     * Convenience method that uses {@link PrintStreamInfoStream}. Must not be null.
     */
    public LuceneOsemSettings setInfoStream(final PrintStream printStream) {
        infoStream = new PrintStreamInfoStream(printStream);
        return this;
    }

    public InfoStream getInfoStream() {
        return infoStream;
    }

    public LuceneOsemSettings addIndexSettings(final IndexSettings indexSettings) {
        if (indexSettings == null) {
            throw new IllegalArgumentException("IndexSettings must not be null");
        }
        if (indexSettingsCollection.contains(indexSettings)) {
            throw new IllegalArgumentException("Duplicate IndexSettings name configuration");
        }
        indexSettingsCollection.add(indexSettings);
        return this;
    }

    public LuceneOsemManager build() {
        return null;
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
