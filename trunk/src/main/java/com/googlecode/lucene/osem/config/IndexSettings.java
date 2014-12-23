package com.googlecode.lucene.osem.config;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.util.InfoStream;
import org.apache.lucene.util.PrintStreamInfoStream;
import org.apache.lucene.util.Version;

/**
 * @author carlos
 * 
 */
public class IndexSettings {

    private final String name;
    private final Directory directory;
    private Version version;
    private Analyzer analyzer;
    private OpenMode openMode = OpenMode.CREATE_OR_APPEND;
    private InfoStream infoStream;
    private final Set<Class<?>> mappings = new HashSet<Class<?>>();

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

    public IndexSettings(final String name, final Directory directory) {
        this.name = name;
        this.directory = directory;
    }

    public String getName() {
        return name;
    }

    public Directory getDirectory() {
        return directory;
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

    public IndexSettings addMappingClass(final Class<?> indexableClass) {
        mappings.add(indexableClass);
        return this;
    }

    public IndexSettings clearMappingClass() {
        mappings.clear();
        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (name == null ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IndexSettings other = (IndexSettings) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }
}
