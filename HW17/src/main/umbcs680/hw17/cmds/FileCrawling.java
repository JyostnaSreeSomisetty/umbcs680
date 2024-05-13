package umbcs680.hw17.cmds;

import java.util.LinkedList;
import umbcs680.hw17.FS.File;
import umbcs680.hw17.FS.Directory;
import umbcs680.hw17.FS.FSCommand;
import umbcs680.hw17.FS.FileSystem;
import umbcs680.hw17.util.FileCrawlingVisitor;

public class FileCrawling implements FSCommand {
    @Override
    public void execute() {
        FileSystem fs = FileSystem.getinstance();
        LinkedList<File> files = new LinkedList<>();

        for (Directory rootDir : fs.getRootDirs()) {
            FileCrawlingVisitor visitor = new FileCrawlingVisitor();
            rootDir.accept(visitor);
            files.addAll(visitor.getF());
        }

        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}



