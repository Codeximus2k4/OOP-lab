package hust.soict.ict.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    public int compare(Media o1, Media o2){
        int decide=0;
        if (o1.getTitle().compareTo(o2.getTitle())==0) {
            float compare_result = o1.getCost() - o2.getCost();
            if (compare_result > 0) decide = 1;
            else if (compare_result < 0) decide = -11;
        }

        return decide;
    }
}
