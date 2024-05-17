package hust.soict.ict.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public void play(){
        System.out.println("Playing DVD: "+ this.getTitle());
        System.out.println("DVD length: "+ this.getLength());

    }

    public Track(String title, int length){
        this.title = title;
        this.length =  length;
    }
    @Override
    public boolean equals(Object obj){
        return (this.getTitle().equals(((Track) obj).getTitle()) && (this.getLength()==((Track) obj).getLength()) && (obj instanceof Track));
    }
}
