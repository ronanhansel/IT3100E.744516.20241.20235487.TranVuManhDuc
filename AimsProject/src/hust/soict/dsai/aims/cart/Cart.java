package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.stream.Collectors;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

	// Thêm một Media vào giỏ hàng
	public void addMedia(Media media) {
		if (itemsOrdered.size() < MAX_NUMBER_ORDERED) {
			if (!itemsOrdered.contains(media)) {
				itemsOrdered.add(media);
				System.out.println("Added successfully: " + media.getTitle());
			} else {
				System.out.println("This item already exists in the cart: " + media.getTitle());
			}
		} else {
			System.out.println("The cart is full! Cannot add more items.");
		}
	}

	// Xóa một Media từ giỏ hàng
	public void removeMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println("Removed successfully: " + media.getTitle());
		} else {
			System.out.println("This item does not exist in the cart: " + media.getTitle());
		}
	}

	// Xóa tất cả các mục trong giỏ hàng
	public void removeMediaAll() {
		itemsOrdered.clear();
		System.out.println("Cart has been cleared!");
	}

	// Tìm kiếm Media theo tiêu đề
	public List<Media> search(String keyword) {
		System.out.println("------ Searching by Keyword ------");
		List<Media> result = itemsOrdered.stream()
				.filter(media -> media.getTitle().toLowerCase().contains(keyword.toLowerCase()))
				.collect(Collectors.toList());
		if (result.isEmpty()) {
			System.out.println("No items found with the keyword: " + keyword);
		} else {
			System.out.println("Found items:");
			result.forEach(media -> System.out.println(media.getTitle()));
		}
		return result;
	}

	// Tính tổng chi phí
	public float totalCost() {
		return itemsOrdered.stream()
				.map(Media::getCost)
				.reduce(0f, Float::sum);
	}

	// Hiển thị thông tin giỏ hàng
	public void displayInformation() {
		if (itemsOrdered.isEmpty()) {
			System.out.println("The cart is empty!");
			return;
		}

		System.out.println("******************** CART ********************");
		int count = 1;
		for (Media media : itemsOrdered) {
			System.out.println(count++ + ". " + media);
		}
		System.out.printf("Total cost: %.2f $\n", totalCost());
		System.out.println("*********************************************");
	}

	// Xóa toàn bộ giỏ hàng và hiển thị thông báo
	public void clearCart() {
		itemsOrdered.clear();
		System.out.println("The cart has been cleared. All items removed!");
	}

	// Lấy danh sách các mục trong giỏ hàng
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	// Tìm kiếm Media theo tiêu đề
	public void searchByTitle(String title) {
		System.out.println("------ Searching by Title ------");
		boolean found = false;
		for (Media media : itemsOrdered) {
			if (media.getTitle().equalsIgnoreCase(title)) {
				System.out.println("Found: " + media);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No item with title \"" + title + "\" found.");
		}
	}

	// Tìm kiếm Media theo ID
	public void searchById(int id) {
		System.out.println("------ Searching by ID ------");
		boolean found = false;
		for (Media media : itemsOrdered) {
			if (media.getId() == id) {
				System.out.println("Found: " + media);
				found = true;
			}
		}
		if (!found) {
			System.out.println("No item with ID " + id + " found.");
		}
	}
}
