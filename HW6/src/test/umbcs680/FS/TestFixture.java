package umbcs680.FS;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import umbcs680.FS.FileSystem;
import umbcs680.FS.Directory;
import umbcs680.FS.File;
import umbcs680.FS.FSElement;

public class TestFixture {

    public static FileSystem createFS() {
        FileSystem fs = FileSystem.getFileSystem();

        // Creating directories and files
        Directory repo = new Directory(null, "repo", 0, LocalDateTime.now());
        Directory src = new Directory(repo, "src", 0, LocalDateTime.now());
        Directory main = new Directory(src, "main", 0, LocalDateTime.now());
        Directory test = new Directory(src, "test", 0, LocalDateTime.now());
        File readme = new File(repo, "readme.md", 100, LocalDateTime.now());
        File aJava = new File(src, "A.java", 120, LocalDateTime.now());
        File bJava = new File(src, "B.java", 150, LocalDateTime.now());
        File aTestJava = new File(test, "ATest.java", 120, LocalDateTime.now());
        File bTestJava = new File(test, "BTest.java", 150, LocalDateTime.now());

        // Adding files and directories to their parents
        repo.appendChild(src);
        repo.appendChild(test);
        repo.appendChild(readme);
        src.appendChild(main);
        src.appendChild(test);
        main.appendChild(aJava);
        main.appendChild(bJava);
        test.appendChild(aTestJava);
        test.appendChild(bTestJava);

        // Appending root directory to the file system
        fs.appendRootDir(repo);

        return fs;
    }
}
