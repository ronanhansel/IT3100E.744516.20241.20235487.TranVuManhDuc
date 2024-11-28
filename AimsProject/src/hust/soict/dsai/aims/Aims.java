//package hust.soict.dsai.aims;
//
//
//import hust.soict.dsai.aims.cart.Cart;
//import hust.soict.dsai.aims.disc.DigitalVideoDisc;
//
//public class Aims {
//
//	public static void main(String[] args) {
//		Cart anOrder = new Cart();
//
//		DigitalVideoDisc dvd1= new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
//		anOrder.addDigitalVideoDisc(dvd1);
//
//		DigitalVideoDisc dvd2= new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
//		anOrder.addDigitalVideoDisc(dvd2);
//
//		DigitalVideoDisc dvd3= new DigitalVideoDisc("Aladin","Ainmation",18.99f);
//		anOrder.addDigitalVideoDisc(dvd3);
//
//		System.out.println("The Cost is: ");
//		System.out.println(anOrder.totalCost());
//
//		anOrder.removeDigitalVideoDisc(dvd3);
//
//		System.out.println("The remain cost is: ");
//		System.out.println(anOrder.totalCost());
//	}
//
//}
//
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
	private static int stageScreen=0;
	private static boolean outProgram=false;
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		Store system = new Store();
		Cart anOrder = new Cart();

		while (!outProgram){
			if (stageScreen==0){//main Menu
				showMenu();
				choice = inp.nextInt();
				switch (choice){
					case 1://Option View Store
						stageScreen=1;
						break;
					case 2:// Update store
						System.out.println("Do you want to add an media or remove?");
						System.out.println("1. Add");
						System.out.println("2.Remove");
						choice=inp.nextInt();
						stageScreen=3;
						break;
					case 3:// See current cart
						//next stage
						stageScreen=5;
						break;
					case 0://Exit
						System.out.println("Thank you and See you later!");
						outProgram=true;
						break;
				}
			}
			else if (stageScreen==1){//Stage after View Store: View Store 1
				system.displayItemsInStore();
				storeMenu();
				choice = inp.nextInt();
				switch (choice){
					case 1://See cart detail
						System.out.println("Please give me the title!");
						title = inp.nextLine();
						title=inp.nextLine();
						media= system.searchMedia(title);
						if (media.title.equals("Wrong!")){
							System.out.println("Wrong title!");
						}
						else {
							mediaDetailsMenu();
							choice = inp.nextInt();//next stage
							stageScreen=2;
						}
						break;
					case 2://Add media to cart
						System.out.println("Please give me a media title");
						title=inp.nextLine();
						title=inp.nextLine();
						media = system.searchMedia(title);
						if (media.title.equals("Wrong!")){
							System.out.println("Doesn't exist!");
						}
						else {
							anOrder.addMedia(media);
						}
						break;
					case 3://Play a media
						System.out.println("Please give me a media title");
						title=inp.nextLine();
						title=inp.nextLine();
						media = system.searchMedia(title);
						if (media.title.equals("Wrong!")){
							System.out.println("Doesn't exist!");
						}
						else {
							if (media instanceof Playable){
								((Playable) media).play();
							}
							else{
								System.out.println("This is limited for CD and DVD");
							}
						}
						break;
					case 4: //See a current cart
						anOrder.displayInformation();
						cartMenu();
						choice=inp.nextInt();//next stage
						stageScreen=5;
						break;
					case 0:
						stageScreen=0;
				}
			}
			else if (stageScreen==2){// After see cart detail
				switch (choice){
					case 1://Add to cart
						anOrder.addMedia(media);
						break;
					case 2://Play
						if (media instanceof Playable){
							((Playable) media).play();
						}
						else{
							System.out.println("This is limited for CD and DVD");
						}
						break;
					case 0://Back
						System.out.println("Back to Menu!");
						stageScreen=1;
						break;
				}
			}
			else if (stageScreen==3){//After Update Store
				switch (choice){
					case 1:
						System.out.println("please give me information about media!");
						System.out.println("What type of Media: ");
						System.out.println("1. DVD");
						System.out.println("2. CD");
						System.out.println("3.Book");
						System.out.println("Please choose 1,2,3");
						choice=inp.nextInt();//next stage
						stageScreen=4;
						break;
					case 2:
						System.out.println("Please tell me the title media to delete!");
						title=inp.nextLine();
						title=inp.nextLine();
						media=system.searchMedia(title);
						system.removeMedia(media);
						stageScreen=0;
						break;
				}
			}
			else if (stageScreen==4){// Update/Add
				switch (choice){
					case 1:
						System.out.println("Media title: ");
						title = inp.nextLine();
						title=inp.nextLine();
						System.out.println("category: ");
						category= inp.nextLine();
						System.out.println("Cost: ");
						cost = inp.nextFloat();
						System.out.println("Length: ");
						length = inp.nextInt();
						media = new DigitalVideoDisc(title,category,cost,length);
						system.addMedia(media);
						break;
					case 2:
						System.out.println("Media title: ");
						title = inp.nextLine();
						title= inp.nextLine();
						System.out.println("Artist: ");
						artist= inp.nextLine();
						System.out.println("Length: ");
						length=inp.nextInt();
						media= new CompactDisc(title,length,artist);
						system.addMedia(media);
						break;
					case 3:
						System.out.println("Media title: ");
						title = inp.nextLine();
						title= inp.nextLine();
						media=new Book();
						media.title=title;
						break;
				}
				stageScreen=0;
			}
			else if(stageScreen==5){//After see current cart
				anOrder.displayInformation();
				cartMenu();
				choice=inp.nextInt();
				switch (choice){
					case 1://Filter medias in cart
						System.out.println("Do you want to filter by id or by title?");
						System.out.println("1.id");
						System.out.println("2.title");
						choice=inp.nextInt();
						switch (choice){
							case 1:// id
								anOrder.Items().sort(((o1, o2) -> Integer.compare(o1.id, o2.id)));
							case 2:// title
								anOrder.Items().sort(Media.COMPARE_BY_TITLE_COST);
						}
						break;
					case 2://Sort medias in cart
						System.out.println("Do you want to sort by cost or by title?");
						System.out.println("1.id");
						System.out.println("2.title");
						choice=inp.nextInt();
						switch (choice){
							case 1:// cost
								anOrder.Items().sort(Media.COMPARE_BY_COST_TITLE);
							case 2:// title
								anOrder.Items().sort(Media.COMPARE_BY_TITLE_COST);
						}
						break;
					case 3://remove a media from cart
						System.out.println("Please tell me the title media to delete!");
						title=inp.nextLine();
						title=inp.nextLine();
						media=system.searchMedia(title);
						system.removeMedia(media);
						break;
					case 4://Play a media
						System.out.println("Please give me a media title");
						title=inp.nextLine();
						title=inp.nextLine();
						media = system.searchMedia(title);
						if (media.title.equals("Wrong!")){
							System.out.println("Doesn't exist!");
						}
						else {
							if (media instanceof Playable){
								((Playable) media).play();
							}
							else{
								System.out.println("This is limited for CD and DVD");
							}
						}
						break;
					case 5://Place order
						System.out.println("You have paid all medias in cart");
						anOrder.clearCart();
						break;
					case 0://Back
						stageScreen=0;
						break;
				}
			}
		}
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
}
