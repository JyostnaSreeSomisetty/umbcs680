package umbcs680.FS;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import umbcs680.FS.Directory;
import umbcs680.FS.File;
import umbcs680.FS.Link;

import java.time.LocalDateTime;

public class LinkTest {
    private Directory rootDir;
    private File file;
    private Link link;

    @BeforeEach
    void setUp() {
        rootDir = new Directory(null, "root", 0, LocalDateTime.now());
        file = new File(rootDir, "file.txt", 100, LocalDateTime.now());
        link = new Link(rootDir, "link", 0, LocalDateTime.now(), file);
    }

    @Test
    void testLinkTarget() {
        assertEquals(file, link.getTarget());
    }

    @Test
    void testLinkSize() {
        assertEquals(0, link.getSize());
    }

    @Test
    void testLinkParent() {
        assertEquals(rootDir, link.getParent());
    }

    @Test
    void testLinkName() {
        assertEquals("link", link.getName());
    }

    @Test
    void testLinkCreationTime() {
        assertNotNull(link.getCreationTime());
    }

    @Test
    void testLinkIsDirectory() {
        assertFalse(link.isDirectory());
    }

    @Test
    void testLinkIsFile() {
        assertFalse(link.isFile());
    }

    @Test
    void testLinkIsLink() {
        assertTrue(link.isLink());
    }
}