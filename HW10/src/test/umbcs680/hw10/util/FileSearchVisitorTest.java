package umbcs680.hw10.FS;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import umbcs680.hw10.FS.Directory;
import umbcs680.hw10.FS.File;
import umbcs680.hw10.FS.FileSystem;
import umbcs680.hw10.util.TestFixture;
import umbcs680.hw10.util.FileSearchVisitor;

import java.time.LocalDateTime;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileSearchVisitorTest {
    private FileSystem fs;
    private Directory repo;
    private Directory src;
    private Directory main;
    private Directory test;

    @BeforeEach
    void setUp() {
        fs = TestFixture.createFS();
        repo = (Directory) fs.getRootDirs().get(0);
        src = repo.getSubDirectories().get(0);
        main = src.getSubDirectories().get(0);
        test = src.getSubDirectories().get(1);
    }

    @Test
    public void testSearchFileInRootDirectory() {
        FileSearchVisitor visitor = new FileSearchVisitor("readme.md");
        repo.accept(visitor);
        LinkedList<File> foundFiles = visitor.getFoundFiles();
        assertEquals(1, foundFiles.size());
        assertTrue(foundFiles.contains(repo.getFiles().get(0)));
    }

    @Test
    public void testSearchFileInMainDirectory() {
        FileSearchVisitor visitor = new FileSearchVisitor("B.java");
        main.accept(visitor);
        LinkedList<File> foundFiles = visitor.getFoundFiles();
        assertEquals(1, foundFiles.size());
        assertTrue(foundFiles.contains(main.getFiles().get(1)));
    }

    @Test
    public void testSearchFileInTestDirectory() {
        FileSearchVisitor visitor = new FileSearchVisitor("BTest.java");
        test.accept(visitor);
        LinkedList<File> foundFiles = visitor.getFoundFiles();
        assertEquals(1, foundFiles.size());
        assertTrue(foundFiles.contains(test.getFiles().get(1)));
    }

    @Test
    public void testSearchForNonExistentFile() {
        FileSearchVisitor visitor = new FileSearchVisitor("nonexistent.txt");
        repo.accept(visitor);
        LinkedList<File> foundFiles = visitor.getFoundFiles();
        assertTrue(foundFiles.isEmpty());
    }
}