package analyze;

import java.util.HashMap;
import java.util.Map;

public enum FileType {
    UNKNOWN("application/octet-stream"),
    CSV("text/csv");

    private final String _mime_type;
    private static final Map<String, FileType> _mime_to_type;
    static {
        _mime_to_type = new HashMap<String, FileType>();
        _mime_to_type.put(null, UNKNOWN);
        for (FileType ft : FileType.values()) {
            _mime_to_type.put(ft.getMimeType(), ft);
        }
    }

    public static FileType mimeToType(String mime) { return _mime_to_type.get(mime); }


    private FileType(String mime_type) {
        _mime_type = mime_type;
    }

    public String toString() {
        return getMimeType();
    }

    public String getMimeType() { return _mime_type; }

    public boolean isUnknown() {return this == UNKNOWN; }
}
