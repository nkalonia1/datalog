package analyze.metrics;

import analyze.FileType;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by nkalonia1 on 7/20/16.
 */
public class FileMetrics extends Metrics {
    private Path _path;
    private FileType _type;
    private BasicFileAttributes _attr;
    private ColumnMetrics _columns;
    private RowMetrics _rows;

    public FileMetrics(Path path, FileType type, BasicFileAttributes attr, ColumnMetrics columns, RowMetrics rows) {
        _path = path;
        _type = type;
        _attr = attr;
        _columns = columns;
        _rows = rows;
        lock();
    }

    public Path getPath() { return _path; }

    public FileType getType() { return _type; }

    public BasicFileAttributes getAttributes() { return _attr; }

    public ColumnMetrics getColumnMetrics() { return _columns; }

    public RowMetrics getRowMetrics() { return _rows; }

}
