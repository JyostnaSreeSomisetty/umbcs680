package umbcs680.hw14.FS;

import java.time.LocalDateTime;
import umbcs680.hw14.FS.FSElement;
import umbcs680.hw14.FS.File;
import umbcs680.hw14.FS.FSVisitor;
import umbcs680.hw14.FS.Directory;


public class Link extends FSElement {
    private FSElement target;

    public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
        super(parent, name, size, creationTime);
        this.target = target;
    }

    public FSElement getTarget() {
        return target;
    }

    @Override
    protected boolean isDirectory() {
        return false;
    }

    @Override
    protected boolean isFile() {
        return false;
    }

    @Override
    protected boolean isLink() {
        return true;
    }

    @Override
    public void accept(FSVisitor v) {
        v.visit(this);

    }
}