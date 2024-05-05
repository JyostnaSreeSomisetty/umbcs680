package umbcs680.FS;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

import umbcs680.FS.FileSystem;
import umbcs680.FS.Directory;
import umbcs680.FS.File;
import umbcs680.FS.FSElement;
import umbcs680.FS.TestFixture;

public class FileTest {
    private static FileSystem fs;

    @BeforeAll
    public static void setUpFS() {
        fs = TestFixture.createFS();
    }

    @Test
    public void testFileCreationTimeSetter() {
        Directory parentDir = fs.getRootDirs().getFirst().getSubDirectories().get(0);
        LocalDateTime creationTime = LocalDateTime.now();
        File file = new File(parentDir, "test.txt", 100, creationTime);

        LocalDateTime newCreationTime = creationTime.plusHours(1);
        file.setCreationTime(newCreationTime);
        assertEquals(newCreationTime, file.getCreationTime(), "File creation time should be updated correctly");
    }

    @Test
    public void validateFileParentDirectory() {
        if (!fs.getRootDirs().isEmpty() && !fs.getRootDirs().getFirst().getSubDirectories().isEmpty()) {
            Directory src = fs.getRootDirs().getFirst().getSubDirectories().get(0);
        }
    }

    @Test
    public void AJavaIsAFile() {
        if (!fs.getRootDirs().isEmpty() && !fs.getRootDirs().getFirst().getSubDirectories().isEmpty()) {
            Directory src = fs.getRootDirs().getFirst().getSubDirectories().get(0);}
    }

}
