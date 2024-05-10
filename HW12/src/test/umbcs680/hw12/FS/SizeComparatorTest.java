package test.umbcs680.hw12.FS;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import umbcs680.hw12.FS.Directory;
import umbcs680.hw12.FS.File;
import umbcs680.hw12.FS.FSElement;
import umbcs680.hw12.FS.SizeComparator;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class SizeComparatorTest {
    @Test
    public void testSizeComparator() {
        List<FSElement> elements = new ArrayList<>();
        elements.add(new File(null, "file3.txt", 100, LocalDateTime.now()));
        elements.add(new Directory(null, "dir2", 0, LocalDateTime.now()));
        elements.add(new File(null, "file1.txt", 50, LocalDateTime.now()));
        elements.add(new Directory(null, "dir1", 0, LocalDateTime.now()));

        Collections.sort(elements, new SizeComparator());

        assertEquals("dir2", elements.get(0).getName());
        assertEquals("dir1", elements.get(1).getName());
        assertEquals("file1.txt", elements.get(2).getName());
        assertEquals("file3.txt", elements.get(3).getName());
    }
}
