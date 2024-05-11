package umbcs680.hw14.util;

import java.util.LinkedList;
import umbcs680.hw14.FS.Directory;
import umbcs680.hw14.FS.File;
import umbcs680.hw14.FS.Link;
import umbcs680.hw14.FS.FSVisitor;

public class FileCrawlingVisitor implements FSVisitor {
    private LinkedList<File> f = new LinkedList<File>();

    public LinkedList<File> getF() {
        return f;
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
        f.add(file);
    }
}