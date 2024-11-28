
package hust.soict.dsai.aims.test;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Alters", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f,87,"Kiet Le");
        cart.addMedia(dvd3);

        System.out.println("The Cost is: ");
        System.out.println(cart.totalCost());
        cart.removeMedia(dvd3);

        System.out.println("The remain cost is: ");
        System.out.println(cart.totalCost());
        cart.displayInformation();
        cart.searchDisc(2);
        cart.searchDisc("Aladdin");

    }
}