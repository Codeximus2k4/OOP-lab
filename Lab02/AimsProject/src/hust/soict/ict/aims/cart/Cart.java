package hust.soict.ict.aims.cart;

import hust.soict.ict.aims.media.Media;
import hust.soict.ict.aims.media.Track;

import java.util.ArrayList;
import java.util.Iterator;

public class Cart {
   private ArrayList<Media> itemsOrdered =  new ArrayList<Media>();
    public void addMedia(Media media) {
        boolean mediaExist = itemsOrdered.contains(media);
        if (mediaExist) System.out.println("This media object already exists");
        else {
            itemsOrdered.add(media);
            System.out.println("The new media is added successfully");
        }
    }
    public void removeMedia(Media media){
        boolean mediaExist =  itemsOrdered.contains(media);
        if (!mediaExist) System.out.println("The  media object is not present in the list");
        else {
            itemsOrdered.remove(media);
            System.out.println("The media is removed successfully");
        }
    }

    public float totalCost(){
        float total_cost=0;
        Iterator<Media> iterator =  itemsOrdered.iterator();
        while (iterator.hasNext()){
            Media i = iterator.next();
            total_cost += i.getCost();
        }
        return total_cost;
    }




}
