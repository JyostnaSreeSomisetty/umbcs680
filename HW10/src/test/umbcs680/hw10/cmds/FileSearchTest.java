package umbcs680.hw10.cmds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import umbcs680.hw10.FS.Directory;
import umbcs680.hw10.FS.File;
import umbcs680.hw10.FS.Link;
import umbcs680.hw10.util.FileSearchVisitor;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class FileSearchTest {
    @Test
    public void testFileSearchVisitor() {
        // Create a sample file system structure
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

        // Use the FileSearchVisitor
        FileSearchVisitor visitor = new FileSearchVisitor("file1.txt");
        root.accept(visitor);

        // Verify the found files
        LinkedList<File> files = visitor.getFoundFiles();
        assertEquals(1, files.size());
        assertTrue(files.contains(file1));
    }

    @Test
    public void testSingleMatch() {
        Directory root = new Directory(null, "root", 0, LocalDateTime.now());
        File file1 = new File(root, "file1.txt", 100, LocalDateTime.now());
        root.appendChild(file1);

        FileSearchVisitor visitor = new FileSearchVisitor("file1.txt");
        root.accept(visitor);

        LinkedList<File> files = visitor.getFoundFiles();
        assertEquals(1, files.size());
        assertTrue(files.contains(file1));
    }
}
