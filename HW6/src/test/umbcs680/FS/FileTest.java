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

    public void AJavaIsAFile(){
        assertTrue (fs.getRootDirs().getFirst().getSubDirectories().get(1).getFiles().getFirst().isFile());
    }


    @Test
    public void validateFileParentDirectory() {
        File file = fs.getRootDirs().getFirst().getSubDirectories().get(1).getFiles().getFirst();
        assertNotNull(file.getParent(), "File parent directory should not be null");
        assertTrue(file.getParent() instanceof Directory, "File parent should be an instance of Directory");
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
}