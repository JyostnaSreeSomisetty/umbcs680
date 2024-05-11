package umbcs680.hw14.FS;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;

import java.time.LocalDateTime;
import java.util.LinkedList;
import umbcs680.hw14.FS.Directory;
import umbcs680.hw14.FS.File;
import umbcs680.hw14.FS.FileSystem;
import umbcs680.hw14.FS.TestFixture;
import umbcs680.hw14.FS.AlphabeticalComparator;
import umbcs680.hw14.FS.SizeComparator;

class DirectoryTest {

    @Test
    void testAppendChild() {
        Directory dir = new Directory(null, "root", 0, LocalDateTime.now());
        File file = new File(dir, "file.txt", 100, LocalDateTime.now());
        dir.appendChild(file);
        assertEquals(1, dir.countChildren());
        assertTrue(dir.getChildren().contains(file));
    }

    @Test
    void testGetSubDirectories() {
        Directory root = new Directory(null, "root", 0, LocalDateTime.now());
        Directory subDir1 = new Directory(root, "subDir1", 0, LocalDateTime.now());
        Directory subDir2 = new Directory(root, "subDir2", 0, LocalDateTime.now());
        File file = new File(root, "file.txt", 100, LocalDateTime.now());
        root.appendChild(subDir1);
        root.appendChild(subDir2);
        root.appendChild(file);

        LinkedList<Directory> subDirs = root.getSubDirectories(new AlphabeticalComparator());
        assertEquals(2, subDirs.size());
        assertEquals("subDir1", subDirs.get(0).getName());
        assertEquals("subDir2", subDirs.get(1).getName());
    }

    @Test
    void testGetFiles() {
        Directory root = new Directory(null, "root", 0, LocalDateTime.now());
        File file1 = new File(root, "file1.txt", 100, LocalDateTime.now());
        File file2 = new File(root, "file2.txt", 200, LocalDateTime.now());
        root.appendChild(file1);
        root.appendChild(file2);

        LinkedList<File> files = root.getFiles(new SizeComparator());
        assertEquals(2, files.size());
        assertEquals("file1.txt", files.get(0).getName());
        assertEquals("file2.txt", files.get(1).getName());
    }

    @Test
    void testGetTotalSize() {
        Directory root = new Directory(null, "root", 0, LocalDateTime.now());
        Directory subDir = new Directory(root, "subDir", 0, LocalDateTime.now());
        File file1 = new File(root, "file1.txt", 100, LocalDateTime.now());
        File file2 = new File(subDir, "file2.txt", 200, LocalDateTime.now());
        root.appendChild(subDir);
        root.appendChild(file1);
        subDir.appendChild(file2);

        assertEquals(300, root.getTotalSize());
    }
}