package hust.soict.ict.aims.media;

import java.util.ArrayList;
import java.util.Iterator;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<Track>();

    public String getArtist() {
        return artist;
    }
    public CompactDisc(){
        super();
    }
    public void addTrack(Track track){
        boolean trackExist =  tracks.contains(track);
        if (trackExist) System.out.println("The track already exists");
        else {
            tracks.add(track);
            System.out.println("The new track is added successfully");
        }
    }
    public void removeTrack(Track track){
        boolean trackExist =  tracks.contains(track);
        if (!trackExist) System.out.println("The track is not present in the list");
        else {
            tracks.remove(track);
            System.out.println("The track is removed successfully");
        }
    }
    public int getLength(){
        int sumLength=0;
        Iterator<Track> iterator =  tracks.iterator();
        while (iterator.hasNext()){
            Track i = iterator.next();
            sumLength += i.getLength();
        }
        return sumLength;
    }
    public void play(){
        Iterator<Track> iterator =  tracks.iterator();
        while (iterator.hasNext()){
            Track i = iterator.next();
            i.play();
        }
    }
}
