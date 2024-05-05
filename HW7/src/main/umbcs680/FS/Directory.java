package umbcs680.FS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.time.LocalDateTime;
import umbcs680.FS.FSElement;
import umbcs680.FS.File;


public class Directory extends FSElement {
    protected List<FSElement> children = new LinkedList<FSElement>();
    public LinkedList<Directory> SubDirectories;

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, 0, creationTime);
        this.children = new ArrayList<>();
    }

    public List<FSElement> getChildren() { //getter
        return this.children;
    }

    public void appendChild(FSElement child) {
        this.children.add(child);
    }

    public int countChildren(){
        return this.children.size();
    }
    public LinkedList<Directory> getSubDirectories() { //getter
        LinkedList<Directory> subDirectories = new LinkedList<>(); // Initialize the list
        for (FSElement fs : children) {
            if (fs instanceof Directory) { // Check if it's a directory
                subDirectories.add((Directory) fs);
            }
        }
        return subDirectories;
    }

    public LinkedList<File> getFiles () {

        LinkedList<File> Files = new LinkedList<> ();
        for (FSElement element : children) {
            if (element instanceof File ) {
                Files.add((File) element);
            }
        }
        return Files;
    }

    public int getTotalSize(){
        int totalSize=0;
        for (FSElement fs : children) {
            if (fs.isDirectory()) {
                totalSize = totalSize + ((Directory) fs).getTotalSize();
            } else {
                totalSize = totalSize + fs.getSize();
            }
        }
        return totalSize;
    }

    @Override
    public boolean isDirectory() {
        return true;
    }
    @Override
    protected boolean isFile() {
        return false;
    }

    @Override
    protected boolean isLink() {
        return false;
    }

}
