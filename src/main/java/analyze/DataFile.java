package analyze;

import java.nio.file.Path;

/**
 * Created by nkalonia1 on 7/21/16.
 */
public class DataFile {
    private Path _path;
    private FileType _type;

    public DataFile (Path path, FileType type) {
        _path = path;
        _type = (type == null ? FileType.UNKNOWN : type);
    }

    void setType(FileType type) {
        _type = type;
    }

    public FileType getType() { return _type; }

    public Path getPath() { return _path; }

    public boolean isValid() {
        return _type != FileType.UNKNOWN;
    }
}
