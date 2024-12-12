package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {
	private static String title;
	private static String category;
	private static float cost;
	private static String artist;
	private static int choice;
	private static int length;
	private static Media media;
	private static int stageScreen = 0;
	private static boolean outProgram = false;

	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		Store store = new Store();
		Cart cart = new Cart();

		while (!outProgram) {
			switch (stageScreen) {
				case 0: // Main Menu
					showMenu();
					choice = getIntInput(inp);
					handleMainMenuChoice(choice);
					break;
				case 1: // View Store Menu
					store.displayItemsInStore();
					storeMenu();
					choice = getIntInput(inp);
					handleStoreMenuChoice(choice, inp, store, cart);
					break;
				case 2: // Media Details Menu
					mediaDetailsMenu();
					choice = getIntInput(inp);
					handleMediaDetailsMenuChoice(choice, cart);
					break;
				case 3: // Update Store Menu
					updateStoreMenu(inp, store);
					stageScreen = 0;
					break;
				case 5: // Cart Menu
					cart.displayInformation();
					cartMenu();
					choice = getIntInput(inp);
					handleCartMenuChoice(choice, inp, cart);
					break;
				default:
					System.out.println("Invalid stage. Returning to main menu.");
					stageScreen = 0;
			}
		}
	}

	private static void handleMainMenuChoice(int choice) {
		switch (choice) {
			case 1:
				stageScreen = 1;
				break;
			case 2:
				stageScreen = 3;
				break;
			case 3:
				stageScreen = 5;
				break;
			case 0:
				System.out.println("Thank you and see you later!");
				outProgram = true;
				break;
			default:
				System.out.println("Invalid choice! Please try again.");
		}
	}

	private static void handleStoreMenuChoice(int choice, Scanner inp, Store store, Cart cart) {
		inp.nextLine(); // Consume newline
		switch (choice) {
			case 1: // See Media Details
				System.out.println("Please enter the title:");
				title = inp.nextLine();
				media = store.searchMedia(title);
				if (media == null) {
					System.out.println("Media not found.");
				} else {
					stageScreen = 2;
				}
				break;
			case 2: // Add Media to Cart
				System.out.println("Please enter the title:");
				title = inp.nextLine();
				media = store.searchMedia(title);
				if (media != null) {
					cart.addMedia(media);
				} else {
					System.out.println("Media not found.");
				}
				break;
			case 3: // Play a Media
				System.out.println("Please enter the title:");
				title = inp.nextLine();
				media = store.searchMedia(title);
				if (media instanceof Playable) {
					((Playable) media).play();
				} else {
					System.out.println("This media cannot be played.");
				}
				break;
			case 4: // See Current Cart
				cart.displayInformation();
				break;
			case 0: // Back
				stageScreen = 0;
				break;
			default:
				System.out.println("Invalid choice! Please try again.");
		}
	}

	private static void handleMediaDetailsMenuChoice(int choice, Cart cart) {
		switch (choice) {
			case 1: // Add to Cart
				cart.addMedia(media);
				break;
			case 2: // Play
				if (media instanceof Playable) {
					((Playable) media).play();
				} else {
					System.out.println("This media cannot be played.");
				}
				break;
			case 0: // Back
				stageScreen = 1;
				break;
			default:
				System.out.println("Invalid choice! Please try again.");
		}
	}

	private static void updateStoreMenu(Scanner inp, Store store) {
		System.out.println("What type of media do you want to add?");
		System.out.println("1. DVD\n2. CD\n3. Book");
		choice = getIntInput(inp);
		inp.nextLine(); // Consume newline

		switch (choice) {
			case 1:
				System.out.println("Title:");
				title = inp.nextLine();
				System.out.println("Category:");
				category = inp.nextLine();
				System.out.println("Cost:");
				cost = inp.nextFloat();
				System.out.println("Length:");
				length = inp.nextInt();
				store.addMedia(new DigitalVideoDisc(title, category, cost, length));
				break;
			case 2:
				System.out.println("Title:");
				title = inp.nextLine();
				System.out.println("Artist:");
				artist = inp.nextLine();
				System.out.println("Length:");
				length = inp.nextInt();
				store.addMedia(new CompactDisc(title, length, artist));
				break;
			case 3:
				System.out.println("Title:");
				title = inp.nextLine();
				store.addMedia(new Book(title));
				break;
			default:
				System.out.println("Invalid choice! Please try again.");
		}
	}

	private static void handleCartMenuChoice(int choice, Scanner inp, Cart cart) {
		inp.nextLine(); // Consume newline
		switch (choice) {
			case 1: // Filter Media in Cart
				System.out.println("Enter title to filter:");
				title = inp.nextLine();
				cart.searchByTitle(title);
				break;
			case 2: // Sort Media in Cart
				System.out.println("Sorting by cost and title...");
				cart.getItemsOrdered().sort(Media.COMPARE_BY_COST_TITLE);
				break;
			case 3: // Remove Media from Cart
				System.out.println("Enter title to remove:");
				title = inp.nextLine();
				Media toRemove = cart.getItemsOrdered().stream()
						.filter(m -> m.getTitle().equalsIgnoreCase(title))
						.findFirst().orElse(null);
				if (toRemove != null) {
					cart.removeMedia(toRemove);
				} else {
					System.out.println("Media not found in cart.");
				}
				break;
			case 4: // Play Media
				System.out.println("Enter title to play:");
				title = inp.nextLine();
				Media toPlay = cart.getItemsOrdered().stream()
						.filter(m -> m.getTitle().equalsIgnoreCase(title))
						.findFirst().orElse(null);
				if (toPlay instanceof Playable) {
					((Playable) toPlay).play();
				} else {
					System.out.println("This media cannot be played.");
				}
				break;
			case 5: // Place Order
				System.out.println("Placing order for all items in the cart...");
				cart.clearCart();
				break;
			case 0: // Back
				stageScreen = 0;
				break;
			default:
				System.out.println("Invalid choice! Please try again.");
		}
	}

	private static int getIntInput(Scanner inp) {
		while (!inp.hasNextInt()) {
			System.out.println("Invalid input! Please enter a number.");
			inp.next();
		}
		return inp.nextInt();
	}

	public static void showMenu() {
		System.out.println("AIMS:");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	public static void storeMenu() {
		System.out.println("Options:");
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
		System.out.println("Options:");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}

	public static void cartMenu() {
		System.out.println("Options:");
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
}
