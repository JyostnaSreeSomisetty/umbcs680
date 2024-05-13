package umbcs680.hw17.FS;

import java.time.LocalDateTime;
import umbcs680.hw17.FS.FSElement;
import umbcs680.hw17.FS.File;
import umbcs680.hw17.FS.FSVisitor;
import umbcs680.hw17.FS.Directory;


public class File extends FSElement {
    public File(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
    }

    @Override
    protected boolean isDirectory() {
        return false;
    }

    @Override
    protected boolean isFile() {
        return true;
    }

    @Override
    protected boolean isLink() {
        return false;
    }

    @Override
    public void accept(FSVisitor v) {
        v.visit(this);

    }

}