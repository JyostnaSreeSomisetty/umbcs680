package umbcs680.hw17.FS;

import java.util.Comparator;
import java.util.Comparator;
import umbcs680.hw17.FS.FSElement;

public class ReverseAlphabeticalComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement elem1, FSElement elem2) {
        return -elem1.getName().compareTo(elem2.getName());
    }
}