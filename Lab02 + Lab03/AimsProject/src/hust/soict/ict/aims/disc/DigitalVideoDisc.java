package hust.soict.ict.aims.disc;

public class DigitalVideoDisc {
    private String title = "n\\a";
    private String category= "n\\a";

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }


    public DigitalVideoDisc(String title) {
        this.title = title;
    }

    public float getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return this.title + " - "+ this.category + " - "+ this.director + " - "+ this.length + " : "+ this.cost+"$";
    }
    public boolean isMatch(String title){
        return this.title.toLowerCase().contains(title.toLowerCase());
    }

    private String director="n\\a";
    private int length=0;
    private float cost=0;
}
