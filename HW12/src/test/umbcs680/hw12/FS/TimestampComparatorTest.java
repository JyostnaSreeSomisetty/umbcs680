package umbcs680.hw12.FS;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Comparator;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import umbcs680.hw12.FS.Directory;
import umbcs680.hw12.FS.File;
import umbcs680.hw12.FS.FSElement;
import umbcs680.hw12.FS.FileSystem;
import umbcs680.hw12.FS.TimestampComparator;

public class TimestampComparatorTest {
    @Test
    public void testTimestampComparator() {
        LocalDateTime time1 = LocalDateTime.now().minusHours(2);
        LocalDateTime time2 = LocalDateTime.now().minusHours(1);
        LocalDateTime time3 = LocalDateTime.now();
        LocalDateTime time4 = LocalDateTime.now().plusHours(1);

        List<FSElement> elements = new ArrayList<>();
        elements.add(new File(null, "file3.txt", 100, time3));
        elements.add(new Directory(null, "dir2", 0, time2));
        elements.add(new File(null, "file1.txt", 50, time1));
        elements.add(new Directory(null, "dir1", 0, time4));

        Collections.sort(elements, new TimestampComparator());

        assertEquals("file3.txt", elements.get(0).getName());
        assertEquals("dir2", elements.get(1).getName());
        assertEquals("file1.txt", elements.get(2).getName());
        assertEquals("dir1", elements.get(3).getName());
    }

}
