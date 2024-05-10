package umbcs680.hw10.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import umbcs680.hw10.FS.Directory;
import java.util.LinkedList;
import umbcs680.hw10.FS.File;
import umbcs680.hw10.FS.FileSystem;
import umbcs680.hw10.util.TestFixture;
import umbcs680.hw10.util.FileCrawlingVisitor;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class FileCrawlingVisitorTest {
    private static FileSystem fs;
    private static Directory repo;
    private static Directory src;
    private static Directory main;
    private static Directory test;

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    @BeforeAll
    static void createFS() {
        fs = TestFixture.createFS();
        repo = (Directory) fs.getRootDirs().get(0);
        src = repo.getSubDirectories().get(0);
        main = src.getSubDirectories().get(0);
        test = src.getSubDirectories().get(1);
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testVisitRootDirectory() {
        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        repo.accept(visitor);
        String output = outContent.toString();
        outContent.reset();
        assertFalse(output.contains("Visiting directory: Root"));
    }

    @Test
    public void testVisitSingleFileAddsToList() {
        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        File aJava = main.getFiles().get(0);
        aJava.accept(visitor);
        LinkedList<File> files = visitor.getF();
        assertEquals(1, files.size());
        assertEquals(aJava, files.getFirst());
    }


    @Test
    public void testVisitMultipleFilesInOrder() {
        FileCrawlingVisitor visitor = new FileCrawlingVisitor();
        src.accept(visitor);
        LinkedList<File> files = visitor.getF();
        assertEquals(5, files.size());
        assertEquals(main.getFiles().get(0), files.getFirst());
    }
}