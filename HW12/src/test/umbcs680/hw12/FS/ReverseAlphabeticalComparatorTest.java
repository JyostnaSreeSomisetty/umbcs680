package umbcs680.hw12.FS;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import umbcs680.hw12.FS.Directory;
import umbcs680.hw12.FS.File;
import umbcs680.hw12.FS.FSElement;
import umbcs680.hw12.FS.FileSystem;
import umbcs680.hw12.FS.ReverseAlphabeticalComparator;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class ReverseAlphabeticalComparatorTest {
    @Test
    public void testReverseAlphabeticalComparator() {
        List<FSElement> elements = new ArrayList<>();
        elements.add(new File(null, "file3.txt", 100, LocalDateTime.now()));
        elements.add(new Directory(null, "dir2", 0, LocalDateTime.now()));
        elements.add(new File(null, "file1.txt", 50, LocalDateTime.now()));
        elements.add(new Directory(null, "dir1", 0, LocalDateTime.now()));

        Collections.sort(elements, new ReverseAlphabeticalComparator());

        assertEquals("file3.txt", elements.get(0).getName());
        assertEquals("file1.txt", elements.get(1).getName());
        assertEquals("dir2", elements.get(2).getName());
        assertEquals("dir1", elements.get(3).getName());
    }

}
