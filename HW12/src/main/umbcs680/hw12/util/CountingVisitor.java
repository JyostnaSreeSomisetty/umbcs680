package umbcs680.hw12.util;

import umbcs680.hw12.FS.Directory;
import umbcs680.hw12.FS.File;
import umbcs680.hw12.FS.Link;
import umbcs680.hw12.FS.FSVisitor;

public class CountingVisitor implements FSVisitor {
    private int directoryCount;
    private int fileCount;
    private int linkCount;

    public CountingVisitor() {
        directoryCount = 0;
        fileCount = 0;
        linkCount = 0;
    }

    @Override
    public void visit(Link link) {
        linkCount++;
    }

    @Override
    public void visit(Directory dir) {
        directoryCount++;
    }

    @Override
    public void visit(File file) {
        fileCount++;
    }

    public int getDirectoryCount() {
        return directoryCount;
    }

    public int getFileCount() {
        return fileCount;
    }

    public int getLinkCount() {
        return linkCount;
    }
}