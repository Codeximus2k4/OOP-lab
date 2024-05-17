package hust.soict.ict.aims.screen.manager;

import hust.soict.ict.aims.media.Book;
import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen{

    private String item_title = "N\\A";
    private int item_cost = 0;
    private String item_category="N\\A";
    public AddBookToStoreScreen(Store store){
        super(store);
    }
    @Override
    public void add_new_media(){
        Book disc = new Book();
        disc.setTitle(item_title);
        disc.setCategory(item_category);
        disc.setCost(item_cost);
        this.getStore().addMedia(disc);
    }

}
