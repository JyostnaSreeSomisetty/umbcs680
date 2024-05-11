package umbcs680.hw14.FS;

import java.util.LinkedList;
import umbcs680.hw14.FS.Directory;
import umbcs680.hw14.FS.FileSystem;


public class FileSystem {
    private static FileSystem instance = null;
    private LinkedList<Directory> rootDirs;

    public FileSystem() {
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

