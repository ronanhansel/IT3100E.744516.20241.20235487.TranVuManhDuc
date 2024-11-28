package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private DigitalVideoDisc items_order[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	private int currentorder = 0; // this is qrtOrdered

	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < currentorder; i++) {
			System.out.println((i + 1) + ". " + items_order[i]);
		}
		System.out.println("Total cost: " + totalCost() + " $");
		System.out.println("***************************************************");
	}

	public void searchById(int id) {
		boolean found = false;
		for (int i = 0; i < currentorder; i++) {
			if (items_order[i].getId() == id) {
				System.out.println("Found: " + items_order[i]);
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("No DVD with ID " + id + " found.");
		}
	}

	public void searchByTitle(String title) {
		boolean found = false;
		for (int i = 0; i < currentorder; i++) {
			if (items_order[i].isMatch(title)) {
				System.out.println("Found: " + items_order[i]);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No DVD with title \"" + title + "\" found.");
		}
	}


	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (currentorder == MAX_NUMBER_ORDERED) {
			System.out.println("Cart has been fulled");
		} else {
			items_order[currentorder] = disc;
			currentorder++;
			System.out.println("Dics have been added!");
			if (currentorder >= 18) {
				System.out.println("Warning: Cart is almost full");
			}
		}
	}

	public void removeDigitalVideoDisc(DigitalVideoDisc dics) {
		boolean found = false;
		if (currentorder == 0) {
			System.out.println("Cart is Empty");
		} else {
			for (int i = 0; i < currentorder; i++) {
				if (items_order[i].equals(dics)) {
					found = true;

					for (int j = i; j < currentorder - 1; j++) {
						items_order[j] = items_order[j + 1];
					}
					items_order[currentorder - 1] = null; // Xóa phần tử cuối
					currentorder--;
					break;
				}
			}
			if (!found) {
				System.out.println("That Disc is not exist");
			} else {
				System.out.println("You have just remove dics");
			}
		}
	}

	public float totalCost() {
		float result = 0;
		for (int i = 0; i < currentorder; i++) {
			result += items_order[i].getCost();
		}
		return result;
	}

}