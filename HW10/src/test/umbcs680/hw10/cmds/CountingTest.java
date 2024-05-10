package umbcs680.hw10.cmds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import umbcs680.hw10.FS.Directory;
import umbcs680.hw10.FS.File;
import umbcs680.hw10.FS.FileSystem;
import umbcs680.hw10.FS.Link;
import umbcs680.hw10.util.CountingVisitor;
import java.time.LocalDateTime;

public class CountingTest {
    @Test
    public void testCountingVisitor() {
        Directory root = new Directory(null, "root", 0, LocalDateTime.now());
        Directory dir1 = new Directory(root, "dir1", 0, LocalDateTime.now());
        Directory dir2 = new Directory(root, "dir2", 0, LocalDateTime.now());
        File file1 = new File(root, "file1.txt", 100, LocalDateTime.now());
        File file2 = new File(dir1, "file2.txt", 200, LocalDateTime.now());
        Link link1 = new Link(dir2, "link1", 0, LocalDateTime.now(), file1);

        root.appendChild(dir1);
        root.appendChild(dir2);
        root.appendChild(file1);
        dir1.appendChild(file2);
        dir2.appendChild(link1);

        // Use the CountingVisitor
        CountingVisitor visitor = new CountingVisitor();
        root.accept(visitor);
        assertEquals(3, visitor.getDirectoryCount());
        assertEquals(2, visitor.getFileCount());
        assertEquals(1, visitor.getLinkCount());
    }

    @Test
    public void testWithSingleFile() {
        Directory root = new Directory(null, "root", 0, LocalDateTime.now());
        File file1 = new File(root, "file1.txt", 100, LocalDateTime.now());
        root.appendChild(file1);

        CountingVisitor visitor = new CountingVisitor();
        root.accept(visitor);

        assertEquals(1, visitor.getDirectoryCount());
        assertEquals(1, visitor.getFileCount());
        assertEquals(0, visitor.getLinkCount());
    }

    @Test
    public void testWithMixedElements() {
        Directory root = new Directory(null, "root", 0, LocalDateTime.now());
        Directory dir1 = new Directory(root, "dir1", 0, LocalDateTime.now());
        File file1 = new File(root, "file1.txt", 100, LocalDateTime.now());
        File file2 = new File(dir1, "file2.txt", 200, LocalDateTime.now());
        Link link1 = new Link(root, "link1", 0, LocalDateTime.now(), file1);

        root.appendChild(dir1);
        root.appendChild(file1);
        dir1.appendChild(file2);
        root.appendChild(link1);

        CountingVisitor visitor = new CountingVisitor();
        root.accept(visitor);

        assertEquals(2, visitor.getDirectoryCount());
        assertEquals(2, visitor.getFileCount());
        assertEquals(1, visitor.getLinkCount());
    }

}
