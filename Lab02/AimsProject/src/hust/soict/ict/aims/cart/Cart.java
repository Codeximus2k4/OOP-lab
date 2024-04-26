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


    public void print_cart(){
        System.out.println("*********************CART*******************");
        System.out.println("Ordered Items:");
        for (int i=0; i<itemsOrdered.size();i++){
            System.out.println(Integer.toString(i+1)+ ". DVD- "+ itemsOrdered.get(i).getTitle()+ " - "+ itemsOrdered.get(i).getCategory()+ " - "
            + itemsOrdered[i].getDirector()+ " - "+ Integer.toString(itemsOrdered[i].getLength())+ ": "+ Float.toString(itemsOrdered[i].getCost())+"$");
        }
        System.out.println("Total_cost: "+ Float.toString(this.totalCost()));
        System.out.println("********************************************");
    }

}
