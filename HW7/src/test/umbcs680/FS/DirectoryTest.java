package umbcs680.FS;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.LinkedList;
import umbcs680.FS.FileSystem;
import umbcs680.FS.Directory;
import umbcs680.FS.File;
import umbcs680.FS.FSElement;
import umbcs680.FS.TestFixture;

public class DirectoryTest {

    private static FileSystem fs;
    private static Directory repo;
    private static Directory src;
    private static Directory main;
    private static Directory test;

    @BeforeAll
    static void createFS() {
        fs = TestFixture.createFS();
        repo = (Directory) fs.getRootDirs().get(0);
        src = repo.getSubDirectories().get(0);
        main = src.getSubDirectories().get(0);
        test = src.getSubDirectories().get(1);
    }

    @Test
    void testDirectoryNameEquality() {
        assertEquals("Root", repo.getName());
        assertEquals("src", src.getName());
        assertEquals("main", main.getName());
        assertEquals("test", test.getName());
    }

    @Test
    void testDirectorySizeEquality() {
        assertEquals(0, repo.getSize());
        assertEquals(0, src.getSize());
        assertEquals(0, main.getSize());
        assertEquals(0, test.getSize());
    }

    @Test
    void testDirectorySubDirectories() {
        List<Directory> repoSubDirs = repo.getSubDirectories();
        assertEquals(1, repoSubDirs.size());
        assertTrue(repoSubDirs.contains(src));
        assertFalse(repoSubDirs.contains(test));

        List<Directory> srcSubDirs = src.getSubDirectories();
        assertEquals(2, srcSubDirs.size());
        assertTrue(srcSubDirs.contains(main));
        assertTrue(srcSubDirs.contains(test));
    }

    @Test
    void testDirectoryFiles() {
        List<File> repoFiles = repo.getFiles();
        assertEquals(1, repoFiles.size());
        assertTrue(repoFiles.contains(repo.getFiles().get(0)));

        List<File> mainFiles = main.getFiles();
        assertEquals(2, mainFiles.size());
        assertTrue(mainFiles.contains(main.getFiles().get(0)));
        assertTrue(mainFiles.contains(main.getFiles().get(1)));

        List<File> testFiles = test.getFiles();
        assertEquals(3, testFiles.size());
        assertTrue(testFiles.contains(test.getFiles().get(0)));
        assertTrue(testFiles.contains(test.getFiles().get(1)));
    }

    @Test
    void testParentDirectory() {
        assertNull(repo.getParent());
        assertEquals(repo, src.getParent());
        assertEquals(src, main.getParent());
        assertEquals(src, test.getParent());
    }

}