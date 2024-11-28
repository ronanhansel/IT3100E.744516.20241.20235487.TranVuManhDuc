package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<>();
    private static int nbBooks=0;
    public Book(){
        nbBooks++;
        id=nbBooks;
    }
    public void addAuthor(String authorName){
        if (!authors.contains(authorName)){
            authors.add(authorName);
        }
    }
    public void removeAuthor(String authorName){
        authors.remove(authorName);
    }
    public String toString(){
        return "DVD - "+this.title+" - "+this.category+" - "+this.cost+ "$";
    }
}