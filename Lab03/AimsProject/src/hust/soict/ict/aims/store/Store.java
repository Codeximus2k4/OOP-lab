package hust.soict.ict.aims.store;
import java.nio.file.Paths;
import java.util.*;
import hust.soict.ict.aims.media.*;

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
    public Media findSpecificMedia(String title){
        Iterator<Media> iterator = itemsInStore.iterator();
        Media chosen_one=null;
        while (iterator.hasNext()){
            Media i = iterator.next();
            if (i.getTitle().equals(title)){
             chosen_one=i;
             break;
            }
        }
        return chosen_one;
    }
    public static void main(String[] args){
        ArrayList<Media> mediae = new ArrayList<Media>();
        CompactDisc cd = new CompactDisc();
        DigitalVideoDisc dvd = new DigitalVideoDisc();
        Book book = new Book();
        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);
        for (Media m: mediae){
            System.out.println(m.toString());
        }
    }
}

