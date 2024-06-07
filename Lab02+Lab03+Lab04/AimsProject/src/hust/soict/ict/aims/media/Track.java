package hust.soict.ict.aims.media;

import hust.soict.ict.aims.exception.PlayerException;

import java.util.ArrayList;

public class Track implements Playable {
    private String title;
    private int length;

    public ArrayList<Media> tracks = new ArrayList<Media>();

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public void play() throws PlayerException {
        if (this.getLength()>0){
            java.util.Iterator iter = tracks.iterator();
            Track nextTrack;
            while (iter.hasNext()){
                nextTrack = (Track) iter.next();
                try {
                    nextTrack.play();
                } catch (PlayerException e){
                    throw e;
                }
            }
        }
        else {
            System.out.println("Playing DVD: " + this.getTitle());

            System.out.println("DVD length: " + this.getLength());
            throw new PlayerException("ERROR: CD length is non-positive");
        }

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
