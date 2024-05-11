package umbcs680.hw14.FS;

import java.util.Comparator;
import umbcs680.hw14.FS.FSElement;
import java.util.Comparator;

public class SizeComparator implements Comparator<FSElement> {
    @Override
    public int compare(FSElement elem1, FSElement elem2) {
        return Integer.compare(elem1.getSize(), elem2.getSize());
    }
}