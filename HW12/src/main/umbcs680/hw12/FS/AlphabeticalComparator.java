package umbcs680.hw12.FS;

import java.util.Comparator;
import umbcs680.hw12.FS.FSElement;

public class AlphabeticalComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement elem1, FSElement elem2) {
        return elem1.getName().compareTo(elem2.getName());
    }
}