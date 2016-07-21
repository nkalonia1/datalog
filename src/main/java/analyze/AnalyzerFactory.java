package analyze;

import java.nio.file.Path;

/**
 * Created by nkalonia1 on 7/20/16.
 */
public class AnalyzerFactory {
    public static Analyzer create(DataFile data) {
        return new CSVAnalyzer(data.getPath());

    }
}
