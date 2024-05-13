package umbcs680.hw17.cmds;

import java.util.LinkedList;
import umbcs680.hw17.FS.File;
import umbcs680.hw17.FS.FileSystem;
import umbcs680.hw17.FS.Directory;
import umbcs680.hw17.util.FileSearchVisitor;
import umbcs680.hw17.FS.FSCommand;

public class FileSearch implements FSCommand {
    private String fileName;

    public FileSearch(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void execute() {
        FileSystem fs = FileSystem.getinstance();
        LinkedList<File> foundFiles = new LinkedList<>();

        for (Directory rootDir : fs.getRootDirs()) {
            FileSearchVisitor visitor = new FileSearchVisitor(fileName);
            rootDir.accept(visitor);
            foundFiles.addAll(visitor.getFoundFiles());
        }

        for (File file : foundFiles) {
            System.out.println(file.getName());
        }
    }
}