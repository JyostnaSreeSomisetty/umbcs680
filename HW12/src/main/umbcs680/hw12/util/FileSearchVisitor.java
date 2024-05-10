package umbcs680.hw12.util;

import java.util.LinkedList;

import umbcs680.hw12.FS.Directory;
import umbcs680.hw12.FS.File;
import umbcs680.hw12.FS.Link;
import umbcs680.hw12.FS.FSVisitor;

public class FileSearchVisitor implements FSVisitor {
    private String fileName;
    private LinkedList<File> foundFiles;

    public FileSearchVisitor(String fileName) {
        this.fileName = fileName;
        foundFiles = new LinkedList<>();
    }

    @Override
    public void visit(Link link) {
        return;
    }

    @Override
    public void visit(Directory dir) {
        return;
    }

    @Override
    public void visit(File file) {
        if (file.getName().equals(fileName)) {
            foundFiles.add(file);
        }
    }

    public LinkedList<File> getFoundFiles() {
        return foundFiles;
    }
}