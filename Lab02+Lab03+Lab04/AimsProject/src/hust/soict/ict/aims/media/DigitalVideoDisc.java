package hust.soict.ict.aims.media;

import hust.soict.ict.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{


    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public void play() throws PlayerException{
        if (this.getLength()<=0){
            System.err.println("This media cannnot be played");
            throw new PlayerException("ERROR: DVD Length is non-positive");
        }
        else {
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        }

    }




    @Override
    public String toString() {
        return this.getTitle() + " - "+ this.getCategory() + " - "+ this.director + " - "+ this.length + " : "+ this.getCost()+"$";
    }
    public boolean isMatch(String title){
        return this.getTitle().toLowerCase().contains(title.toLowerCase());
    }

    private String director="n\\a";
    private int length=0;

}
