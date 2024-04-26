package hust.soict.ict.aims.store;
import java.util.*;
import hust.soict.ict.aims.media.Media;

public class Store {

    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    public void addMedia(Media media){
        itemsInStore.add(media);
    }

    public void removeMedia(Media media){
        itemsInStore.remove(media);
    }
    public void showMediaInStore() {
        System.out.println("Media list: " + this.itemsInStore);
    }
}

