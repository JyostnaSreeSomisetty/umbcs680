package umbcs680.FS;

import java.util.List;

import umbcs680.FS.FSElement;
import java.time.LocalDateTime;
import umbcs680.FS.Directory;

class File extends FSElement {
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

}