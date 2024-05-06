package umbcs680.hw08.util;

import java.time.LocalDateTime;

import umbcs680.hw08.FS.Directory;
import umbcs680.hw08.FS.FileSystem;
import umbcs680.hw08.FS.File;
public class TestFixture {

    public static FileSystem createFS() {
        FileSystem fs = FileSystem.getFileSystem();

        // Creating directories and files
        Directory repo = new Directory(null, "Root", 0, LocalDateTime.now());
        Directory src = new Directory(repo, "src", 0, LocalDateTime.now());
        Directory main = new Directory(src, "main", 0, LocalDateTime.now());
        Directory test = new Directory(src, "test", 0, LocalDateTime.now());
        File readme = new File(repo, "readme.md", 0, LocalDateTime.now());
        File aJava = new File(main, "A.java", 0, LocalDateTime.now());
        File bJava = new File(main, "B.java", 0, LocalDateTime.now());
        File aTestJava = new File(test, "ATest.java", 0, LocalDateTime.now());
        File bTestJava = new File(test, "BTest.java", 0, LocalDateTime.now());
        File rmLink = new File(test, "rm.md: Link.java", 0, LocalDateTime.now());

        // Adding files and directories to their parents
        repo.appendChild(src);
        repo.appendChild(readme);
        src.appendChild(main);
        src.appendChild(test);
        main.appendChild(aJava);
        main.appendChild(bJava);
        test.appendChild(aTestJava);
        test.appendChild(bTestJava);
        test.appendChild(rmLink);

        // Appending root directory to the file system
        fs.appendRootDir(repo);

        return fs;
    }
}
