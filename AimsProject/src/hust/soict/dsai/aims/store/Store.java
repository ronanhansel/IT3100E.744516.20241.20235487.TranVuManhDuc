package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Store {
    private ObservableList<Media> itemsInStore = FXCollections.observableArrayList();

    // Thêm một Media vào Store
    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Added successfully: " + media.getTitle());
        } else {
            System.out.println("This item already exists in the store: " + media.getTitle());
        }
    }

    // Xóa một Media từ Store
    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Removed successfully: " + media.getTitle());
        } else {
            System.out.println("This item does not exist in the store: " + media.getTitle());
        }
    }

    // Hiển thị tất cả các mục trong Store
    public void displayItemsInStore() {
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty!");
            return;
        }
        System.out.println("******************** STORE ********************");
        for (Media media : itemsInStore) {
            System.out.println(media.toString());
        }
        System.out.println("**********************************************");
    }

    // Tìm kiếm Media theo tiêu đề
    public Media searchMedia(String title) {
        System.out.println("------ Searching for Media by Title ------");
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found: " + media);
                return media;
            }
        }
        System.out.println("No media found with title: " + title);
        return null;
    }

    // Lấy danh sách các mục trong Store
    public ObservableList<Media> getItemsInStore() {
        return itemsInStore;
    }
}
