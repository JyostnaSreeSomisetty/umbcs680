package umbcs680.hw08.FS;

import umbcs680.hw08.FS.Directory;
import umbcs680.hw08.FS.FSVisitor;
import umbcs680.hw08.FS.File;
import umbcs680.hw08.FS.Link;


public interface FSVisitor {
    public void visit(Link link);
    public void visit(Directory dir);
    public void visit(File file);
}
