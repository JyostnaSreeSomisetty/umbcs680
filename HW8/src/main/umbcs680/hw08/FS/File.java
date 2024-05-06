package umbcs680.hw08.FS;

import java.time.LocalDateTime;
import umbcs680.hw08.FS.Directory;
import umbcs680.hw08.FS.FSElement;
import umbcs680.hw08.FS.FSVisitor;

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