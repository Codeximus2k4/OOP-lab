package hust.soict.ict.aims.screen.manager;

import hust.soict.ict.aims.media.DigitalVideoDisc;
import hust.soict.ict.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen{

    private Store store;
    private String item_title = "N\\A";
    private int item_cost = 0;
    private String item_category="N\\A";
    public AddDigitalVideoDiscToStoreScreen(Store store){
        super(store);
    }
    @Override
    public void add_new_media(){
        DigitalVideoDisc disc = new DigitalVideoDisc();
        disc.setTitle(item_title);
        disc.setCategory(item_category);
        disc.setCost(item_cost);
        this.store.addMedia(disc);
        System.out.println(store.getItemsInStore().size());
    }

}
