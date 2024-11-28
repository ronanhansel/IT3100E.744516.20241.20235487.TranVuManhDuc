package hust.soict.dsai.aims.test;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

import java.util.ArrayList;
import java.util.Collections;

public class StoreTest {
    public static void main(String[] args ){
        Store mystore = new Store();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Alters", 87, 24.95f);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("War Wars", "Science Fiction", "George Lucas", 87, 24.95f);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f,87,"Kiet Le");

        mystore.addMedia(dvd1);
        mystore.addMedia(dvd2);
        mystore.addMedia(dvd3);
        ArrayList<Media> test = mystore.Items();
        System.out.println(test);
        test.sort(Media.COMPARE_BY_COST_TITLE);
        mystore.displayItemsInStore();


    }
}