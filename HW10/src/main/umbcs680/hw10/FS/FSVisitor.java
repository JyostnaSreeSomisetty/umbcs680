package umbcs680.hw10.FS;

import umbcs680.hw10.FS.File;
import umbcs680.hw10.FS.Directory;
import umbcs680.hw10.FS.Link;

public interface FSVisitor {
    public void visit(Link link);
    public void visit(Directory dir);
    public void visit(File file);
}
