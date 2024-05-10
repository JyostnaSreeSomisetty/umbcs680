package umbcs680.hw10.FS;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import umbcs680.hw10.FS.Directory;
import umbcs680.hw10.FS.FileSystem;
import umbcs680.hw10.util.TestFixture;

import umbcs680.hw10.util.CountingVisitor;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountingVisitorTest {
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
    public void testCountDirectoriesInRoot() {
        CountingVisitor visitor = new CountingVisitor();
        repo.accept(visitor);
        int expectedDirCount = 4;
        assertEquals(expectedDirCount, visitor.getDirectoryCount());
    }

    @Test
    public void testCountFilesInMainDirectory() {
        CountingVisitor visitor = new CountingVisitor();
        main.accept(visitor);
        int expectedFileCount = 2;
        assertEquals(expectedFileCount, visitor.getFileCount());
    }

    @Test
    public void testCountLinksInTestDirectory() {
        CountingVisitor visitor = new CountingVisitor();
        test.accept(visitor);
        int expectedLinkCount = 0;
        assertEquals(expectedLinkCount, visitor.getLinkCount());
    }

    @Test
    public void testCountAllElementsInFileSystem() {
        CountingVisitor visitor = new CountingVisitor();
        repo.accept(visitor);
        int expectedDirCount = 4;
        int expectedFileCount = 6;
        int expectedLinkCount = 0;
        assertEquals(expectedDirCount, visitor.getDirectoryCount());
        assertEquals(expectedFileCount, visitor.getFileCount());
        assertEquals(expectedLinkCount, visitor.getLinkCount());
    }
}