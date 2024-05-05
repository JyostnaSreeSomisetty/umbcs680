package umbcs680.FS;

import java.util.LinkedList;
import java.util.List;
import umbcs680.FS.Directory;
import umbcs680.FS.FSElement;
import java.time.LocalDateTime;

public class FileSystem {
    private static FileSystem instance = null;
    private LinkedList<Directory> rootDirs;

    private FileSystem() {
        this.rootDirs = new LinkedList<>();
    }

    public static FileSystem getFileSystem() {
        if (instance == null) {
            instance = new FileSystem();
        }
        return instance;
    }

    public static FileSystem getinstance() {
        return instance;
    }

    public LinkedList<Directory> getRootDirs() {
        return rootDirs;
    }

    public void appendRootDir(Directory repo){
        this.rootDirs.add(repo);
    }
}

