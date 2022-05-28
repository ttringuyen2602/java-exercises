package threedottwoex;

import java.util.Comparator;

public class SortByPYear_DES implements Comparator<Publication> {
    @Override
    public int compare(Publication p1, Publication p2) {
        if (p1.getPublicationYear() > p2.getPublicationYear())
            return 1;
        return -1;
    }
}
