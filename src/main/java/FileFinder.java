import analyze.DataFile;
import analyze.FileType;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collection;
import java.util.HashSet;

import static java.nio.file.FileVisitResult.*;

/**
 * Created by nkalonia1 on 7/20/16.
 */


public class FileFinder {

    public static Collection<DataFile> findMatches(String pattern, Path root_dir) throws IOException {
        final PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
        final Collection<DataFile> results = new HashSet<DataFile>();
        final FileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
            private DataFile toDataFile(Path p) throws IOException {
                return new DataFile(p, FileType.mimeToType(Files.probeContentType(p)));
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
                if (matcher.matches(file)) {
                    try {
                        results.add(toDataFile(file));
                    } catch (IOException ioe) {
                        System.err.println(ioe);
                    }
                }
                return CONTINUE;
            }
        };
        Files.walkFileTree(root_dir, visitor);
        return results;
    }
}
