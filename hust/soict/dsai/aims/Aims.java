
package hust.soict.dsai.aims;

import hust.soict.dsai.aims.media.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Aims {
    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();
        // Add some media to the store for demonstration
        store.addMedia(new Book(1, "Book Title 1", "Category 1", 10.0f));
        store.addMedia(new DigitalVideoDisc(2, "DVD Title 1", "Category 2", 20.0f, 120, "Director 1"));
        store.addMedia(new CompactDisc(3, "CD Title 1", "Category 3", 15.0f, 60, "Director 2", "Artist 1"));

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    viewStore(store, cart, scanner);
                    break;
                case 2:
                    updateStore(store, scanner);
                    break;
                case 3:
                    seeCurrentCart(cart, scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        scanner.close();
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void viewStore(Store store, Cart cart, Scanner scanner) {
        store.print();
        int choice;
        do {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    seeMediaDetails(store, cart, scanner);
                    break;
                case 2:
                    addMediaToCart(store, cart, scanner);
                    break;
                case 3:
                    playMedia(store, scanner);
                    break;
                case 4:
                    seeCurrentCart(cart, scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void seeMediaDetails(Store store, Cart cart, Scanner scanner) {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            System.out.println(media.toString());
            int choice;
            do {
                mediaDetailsMenu();
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                switch (choice) {
                    case 1:
                        cart.addMedia(media);
                        System.out.println("Media added to cart.");
                        break;
                    case 2:
                        if (media instanceof Playable) {
                            ((Playable) media).play();
                        } else {
                            System.out.println("This media cannot be played.");
                        }
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 0);
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void addMediaToCart(Store store, Cart cart, Scanner scanner) {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Media added to cart.");
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMedia(Store store, Scanner scanner) {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played or not found.");
        }
    }

    public static void updateStore(Store store, Scanner scanner) {
        System.out.println("Options: ");
        System.out.println("1. Add a media");
        System.out.println("2. Remove a media");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        switch (choice) {
            case 1:
                System.out.println("Enter media details (id, title, category, cost, length, director, artist):");
                int id = scanner.nextInt();
                scanner.nextLine(); // consume newline
                String title = scanner.nextLine();
                String category = scanner.nextLine();
                float cost = scanner.nextFloat();
                int length = scanner.nextInt();
                scanner.nextLine(); // consume newline
                String director = scanner.nextLine();
                String artist = scanner.nextLine();
                store.addMedia(new CompactDisc(id, title, category, cost, length, director, artist));
                System.out.println("Media added to store.");
                break;
            case 2:
                System.out.println("Enter the title of the media to remove:");
                title = scanner.nextLine();
                Media media = store.searchByTitle(title);
                if (media != null) {
                    store.removeMedia(media);
                    System.out.println("Media removed from store.");
                } else {
                    System.out.println("Media not found.");
                }
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void seeCurrentCart(Cart cart, Scanner scanner) {
        cart.print();
        int choice;
        do {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    filterMediasInCart(cart, scanner);
                    break;
                case 2:
                    sortMediasInCart(cart, scanner);
                    break;
                case 3:
                    removeMediaFromCart(cart, scanner);
                    break;
                case 4:
                    playMediaInCart(cart, scanner);
                    break;
                case 5:
                    placeOrder(cart);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    public static void filterMediasInCart(Cart cart, Scanner scanner) {
        System.out.println("Filter by: ");
        System.out.println("1. ID");
        System.out.println("2. Title");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        switch (choice) {
            case 1:
                System.out.println("Enter the ID:");
                int id = scanner.nextInt();
                scanner.nextLine(); // consume newline
                cart.filterById(id);
                break;
            case 2:
                System.out.println("Enter the title:");
                String title = scanner.nextLine();
                cart.filterByTitle(title);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void sortMediasInCart(Cart cart, Scanner scanner) {
        System.out.println("Sort by: ");
        System.out.println("1. Title");
        System.out.println("2. Cost");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        switch (choice) {
            case 1:
                Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
                break;
            case 2:
                Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void removeMediaFromCart(Cart cart, Scanner scanner) {
        System.out.println("Enter the title of the media to remove:");
        String title = scanner.nextLine();
        Media media = cart.searchByTitle(title);
        if (media != null) {
            cart.removeMedia(media);
            System.out.println("Media removed from cart.");
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMediaInCart(Cart cart, Scanner scanner) {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();
        Media media = cart.searchByTitle(title);
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played or not found.");
        }
    }

    public static void placeOrder(Cart cart) {
        System.out.println("Order placed.");
        cart.clear();
    }
}