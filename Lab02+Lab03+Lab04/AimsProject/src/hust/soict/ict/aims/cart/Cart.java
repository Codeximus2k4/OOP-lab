package hust.soict.ict.aims.cart;

import hust.soict.ict.aims.media.Media;
import hust.soict.ict.aims.media.Track;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.naming.LimitExceededException;
import java.util.ArrayList;
import java.util.Iterator;

public class Cart {
    public int MAX_NUMBERS_ORDERED =5;
   private ObservableList<Media> itemsOrdered =  FXCollections.observableArrayList();
    public void addMedia(Media media) throws LimitExceededException {
        boolean mediaExist = itemsOrdered.contains(media);
        if (mediaExist) System.out.println("This media object already exists");
        else {
            if (itemsOrdered.size()<MAX_NUMBERS_ORDERED){
                itemsOrdered.add(media);
                System.out.println("The new media is added successfully");

            }
            else{
                throw new LimitExceededException("ERROR: The number of media has reaced its limit");
            }

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
    public void placeOrder(){
        itemsOrdered.clear();
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
}
