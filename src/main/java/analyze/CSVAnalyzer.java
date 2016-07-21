package analyze;

import analyze.metrics.ColumnMetrics;
import analyze.metrics.FileMetrics;
import analyze.metrics.RowMetrics;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by nkalonia1 on 7/20/16.
 */
public class CSVAnalyzer extends Analyzer {
    public CSVAnalyzer(Path file) {
        super(file, FileType.CSV);
    }

    @Override
    public FileMetrics analyze() throws IOException {
        CSVReader reader = new CSVReader(Files.newBufferedReader(file, Charset.defaultCharset()));
        BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
        ColumnMetrics cm = new ColumnMetrics();
        RowMetrics rm = new RowMetrics();
        String[] next_line;
        while ((next_line = reader.readNext()) != null) {
            cm.addColumns(next_line.length);
            rm.addRow();
        }
        rm.lock();
        cm.lock();
        return new FileMetrics(file, type, attr, cm, rm);
    }
}
