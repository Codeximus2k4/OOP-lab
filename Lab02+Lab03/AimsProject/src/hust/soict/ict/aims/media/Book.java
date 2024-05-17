package hust.soict.ict.aims.media;

import java.util.ArrayList;

public class Book extends Media {

    private ArrayList<String> authors =  new ArrayList<String>();
    public Book() {
        super();
    }
    public static void main(String[] args){

    }
    public void addAuthor(String authorName){
        boolean authorExist =  authors.contains(authorName);
        if (authorExist) System.out.println("The author already exists");
        else {
            authors.add(authorName);
            System.out.println("The new author is added successfully");
        }
    }
    public void removeAuthor(String authorName){
        boolean authorExist =  authors.contains(authorName);
        if (!authorExist) System.out.println("The author is not present in the list");
        else {
            authors.remove(authorName);
            System.out.println("The author is removed successfully");
        }
    }

}
