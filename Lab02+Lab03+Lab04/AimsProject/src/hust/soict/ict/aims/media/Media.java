package hust.soict.ict.aims.media;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import hust.soict.ict.aims.exception.PlayerException;

public class Media implements Playable{
    public void play() throws PlayerException{

    }

    public Media() {
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    private String title;
    private String category;
    private float cost;

    @Override
    public boolean equals(Object obj)  {
        try {
            Media new_obj = (Media) obj;
            return (new_obj.getTitle().equals(getTitle()) && (obj instanceof Media));
        }
        catch( ClassCastException e){
            throw e;
        }
    }

    public static void main(String[] args) {
        ArrayList<Media> media= new ArrayList<Media>();
        Collections.sort(media, Media.COMPARE_BY_COST_TITLE);
    }

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = (Comparator<Media>) new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = (Comparator<Media>) new MediaComparatorByCostTitle();


}
