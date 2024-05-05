package umbcs680.FS;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import umbcs680.FS.Directory;
import umbcs680.FS.File;

public abstract class FSElement {
    protected String name;
    protected Directory parent;

    protected int size;
    protected LocalDateTime creationTime;

    public FSElement(Directory parent, String name, int size,  LocalDateTime creationTime) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = LocalDateTime.now();
    }

    public Directory getParent() {
        return this.parent;
    }

    public String getName() {
        return this.name;
    }

    public int getSize() {
        return this.size;
    }

    public LocalDateTime getCreationTime() {
        return this.creationTime;
    }

    public void setParent(Directory parent){
        this.parent = parent;
    }

    public void setName(){
        this.name = name;
    }

    public void setSize(){
        this.size = size;
    }

    public void setCreationTime(LocalDateTime creationTime){
        this.creationTime = creationTime;
    }

    protected abstract boolean isDirectory();

    protected abstract boolean isFile();

}