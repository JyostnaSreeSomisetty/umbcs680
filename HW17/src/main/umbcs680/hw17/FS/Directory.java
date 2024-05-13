package umbcs680.hw17.FS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

import umbcs680.hw17.FS.FSElement;
import umbcs680.hw17.FS.File;
import umbcs680.hw17.FS.FSVisitor;
import umbcs680.hw17.FS.Directory;

public class Directory extends FSElement {
    protected List<FSElement> children = new LinkedList<>();

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, 0, creationTime);
        this.children = new ArrayList<>();
    }

    public List<FSElement> getChildren() {
        return this.children;
    }

    public void appendChild(FSElement child) {
        this.children.add(child);
    }

    public int countChildren() {
        return this.children.size();
    }

    public LinkedList<Directory> getSubDirectories(Comparator<FSElement> comparator) {
        LinkedList<Directory> subDirectories = new LinkedList<>();
        children.forEach(child -> {
            if (child instanceof Directory) {
                subDirectories.add((Directory) child);
            }
        });
        subDirectories.sort(comparator);
        return subDirectories;
    }

    public LinkedList<File> getFiles(Comparator<FSElement> comparator) {
        LinkedList<File> files = new LinkedList<>();
        children.forEach(child -> {
            if (child instanceof File) {
                files.add((File) child);
            }
        });
        files.sort(comparator);
        return files;
    }

    public int getTotalSize() {
        int[] totalSize = {0};
        children.forEach(child -> {
            if (child.isDirectory()) {
                totalSize[0] += ((Directory) child).getTotalSize();
            } else {
                totalSize[0] += child.getSize();
            }
        });
        return totalSize[0];
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

    @Override
    public void accept(FSVisitor v) {
        v.visit(this);
        children.forEach(e -> e.accept(v));
    }

    public static void main(String[] args) {
        Directory root = new Directory(null, "root", 0, LocalDateTime.now());

        // Example usage with lambda expressions
        LinkedList<Directory> subDirsByName = root.getSubDirectories((dir1, dir2) -> dir1.getName().compareTo(dir2.getName()));
        LinkedList<File> filesBySize = root.getFiles((file1, file2) -> Integer.compare(file1.getSize(), file2.getSize()));
        LinkedList<Directory> subDirsByCreationTime = root.getSubDirectories((dir1, dir2) -> dir1.getCreationTime().compareTo(dir2.getCreationTime()));

        // Example of appending a child and reordering children alphabetically
        File newFile = new File(root, "newFile.txt", 100, LocalDateTime.now());
        root.appendChild(newFile);
    }

}
