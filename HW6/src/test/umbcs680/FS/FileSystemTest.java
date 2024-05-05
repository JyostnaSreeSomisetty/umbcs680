package umbcs680.FS;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;
import umbcs680.FS.FileSystem;
import umbcs680.FS.Directory;
import umbcs680.FS.File;
import umbcs680.FS.FSElement;
import umbcs680.FS.TestFixture;

public class FileSystemTest {
    private static FileSystem fs;

    @BeforeAll
    static void createFS() {
        fs = TestFixture.createFS();
    }

    @Test
    public void singletonClassCheck() {
        FileSystem instance1 = fs.getinstance();
        FileSystem instance2 = fs.getinstance();
        assertSame(instance1, instance2);
    }

    @Test
    public void getRootDirs() {
        LinkedList<Directory> rootDirs = fs.getRootDirs();
        assertTrue(rootDirs.getFirst() instanceof Directory);
    }

    @Test
    public void appendRootDir() {
        int initialRootDirsSize = fs.getRootDirs().size();
        Directory newRootDir = new Directory(null, "newRootDir", 0, LocalDateTime.now());
        fs.appendRootDir(newRootDir);
        assertEquals(initialRootDirsSize + 1, fs.getRootDirs().size());
    }

    @Test
    public void repoNameCheck() {
        String expected = "repo";
        assertEquals(expected, fs.getRootDirs().getFirst().getName());
    }
}