package umbcs680.hw08.FS;

import java.time.LocalDateTime;
import umbcs680.hw08.FS.Directory;
import umbcs680.hw08.FS.FSElement;
import umbcs680.hw08.FS.FSVisitor;


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