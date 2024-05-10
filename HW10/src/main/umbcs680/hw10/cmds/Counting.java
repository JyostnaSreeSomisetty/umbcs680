package umbcs680.hw10.cmds;

import umbcs680.hw10.FS.FSCommand;
import umbcs680.hw10.FS.FileSystem;
import umbcs680.hw10.FS.Directory;
import umbcs680.hw10.util.CountingVisitor;

public class Counting implements FSCommand {
    @Override
    public void execute() {
        FileSystem fs = FileSystem.getinstance();
        CountingVisitor visitor = new CountingVisitor();

        for (Directory rootDir : fs.getRootDirs()) {
            rootDir.accept(visitor);
        }

        System.out.println("Number of directories: " + visitor.getDirectoryCount());
        System.out.println("Number of files: " + visitor.getFileCount());
        System.out.println("Number of links: " + visitor.getLinkCount());
    }
}