package threedottwoex;

import java.util.Comparator;

class SortByTitle_ASC implements Comparator<Publication> {
    @Override
    public int compare(Publication p1, Publication p2) {
        if (p1.getTitle().compareTo(p2.getTitle()) > 0)
            return 1;
        return -1;
    }
}