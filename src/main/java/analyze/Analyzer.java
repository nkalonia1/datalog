package analyze;

import analyze.metrics.FileMetrics;
import org.omg.CORBA.UNKNOWN;

import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by nkalonia1 on 7/20/16.
 */
public abstract class Analyzer {

    protected FileType type;
    protected Path file;

    public Analyzer(Path file, FileType type) {
        this.file = file;
        this.type = type;
    }

    public Analyzer(Path file) {
        this(file, FileType.UNKNOWN);
    }

    public abstract FileMetrics analyze() throws IOException;
}
