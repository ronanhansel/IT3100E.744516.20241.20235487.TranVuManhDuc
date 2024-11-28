package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class Media {

    public static final Comparator<Media> COMPARE_BY_TITLE_COST= new MediaComparatorByTitleCost();
    public static final Comparator<Media>  COMPARE_BY_COST_TITLE= new MediaComparatorByCostTitle();
    public int id;
    public String title;
    public String category;
    public float cost;

    protected String getTitle() {
        return title;
    }
    public boolean equals(Media media){
        return media.getTitle().equals(title);
    }
}