package hust.soict.ict.aims;
import java.util.Scanner;
import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.exception.PlayerException;
import hust.soict.ict.aims.store.Store;
import hust.soict.ict.aims.media.*;

import javax.naming.LimitExceededException;


public class Aims {
    Scanner myObj = new Scanner(System.in);
    public static void showMenu(){
        System.out.println("AIMSL ");
        System.out.println("-----------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------");
        System.out.println("Please choose a number : 0-1-2-3");
    }
    public static void storeMenu(){
        System.out.println("Options");
        System.out.println("------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------");
        System.out.println("Please choose a number : 0-1-2-3-4");
    }
    public static void mediaDetailsMenu(){
        System.out.println("Options");
        System.out.println("------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------");
        System.out.println("Please choose a number : 0-1-2");
    }
    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }



    public void main(String[] args) throws PlayerException {
        Cart anOrder = new Cart();
        Store store = new Store();
        showMenu();
        int choice =  myObj.nextInt();
        if (choice==1) {
            store.showMediaInStore();
            storeMenu();
            choice = myObj.nextInt();
            if (choice==1) {
                System.out.println("Please input the title");
                String title =  myObj.nextLine();
                Media result = store.findSpecificMedia(title);
                if (result != null) {
                    System.out.println(result.toString());
                    mediaDetailsMenu();
                    choice =  myObj.nextInt();
                    if (choice ==2){
                        if ((result instanceof DigitalVideoDisc || result instanceof CompactDisc)) result.play();
                        else System.out.println("Must be a DVD or a CD to play");
                }
            }
            if (choice ==2) {
                System.out.println("Please input the title");
                title = myObj.nextLine();
                result = store.findSpecificMedia(title);
                if (result != null) {
                    try {
                        anOrder.addMedia(result);
                    } catch (LimitExceededException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (choice ==3) {
                System.out.println("Please input the title");
                title = myObj.nextLine();
                result = store.findSpecificMedia(title);
                if ((result instanceof DigitalVideoDisc || result instanceof CompactDisc)) result.play();
                else System.out.println("Must be a DVD or a CD to play");
            }
            }
        }
        else if (choice ==2){
            Media new_media = new Media();
            store.addMedia(new_media);
            store.removeMedia(new_media);
        }
        else if(choice ==3){
            cartMenu();
            choice =  myObj.nextInt();
            if (choice ==5) {
                anOrder.placeOrder();
                System.out.println("An order has been placed");
            }
        }

    }
}
