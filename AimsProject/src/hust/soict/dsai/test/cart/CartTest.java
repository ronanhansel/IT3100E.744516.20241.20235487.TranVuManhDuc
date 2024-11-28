
public class CartTest {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // Create new DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
            "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
            "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
            "Animation", 18.99f);

        // Add DVDs to cart
        cart.addDigitalVideoDisc(dvd1, dvd2, dvd3);

        // Test print cart
        System.out.println("Testing cart printing:");
        cart.printCart();

        // Test search by ID
        System.out.println("\nTesting search by ID:");
        DigitalVideoDisc found = cart.searchByID(2);
        System.out.println(found != null ? found.toString() : "No match found");

        // Test search by title
        System.out.println("\nTesting search by title:");
        System.out.println("Search for 'king':");
        cart.searchByTitle("king");
        System.out.println("Search for 'war':");
        cart.searchByTitle("war");
        System.out.println("Search for 'nonexistent':");
        cart.searchByTitle("nonexistent");
    }
}