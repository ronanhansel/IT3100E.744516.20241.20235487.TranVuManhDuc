package hust.soict.dsai.aims.test;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StoreTest {
    public static void main(String[] args) {
        // Tạo một cửa hàng mới
        Store mystore = new Store();

        // Tạo các DVD và thêm chúng vào cửa hàng
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Alters", 87, 24.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 19.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "Kiet Le", 87, 18.99f);

        mystore.addMedia(dvd1);
        mystore.addMedia(dvd2);
        mystore.addMedia(dvd3);

        // Lấy danh sách các mục trong cửa hàng (ObservableList)
        ObservableList<Media> itemsInStore = mystore.getItemsInStore();

        // Hiển thị danh sách ban đầu
        System.out.println("Items in store (unsorted):");
        itemsInStore.forEach(System.out::println);

        // Sắp xếp danh sách theo giá và tiêu đề
        FXCollections.sort(itemsInStore, Media.COMPARE_BY_COST_TITLE);

        // Hiển thị danh sách đã sắp xếp
        System.out.println("\nItems in store (sorted by cost and title):");
        itemsInStore.forEach(System.out::println);

        // Hiển thị danh sách sử dụng phương thức của cửa hàng
        System.out.println("\nItems displayed using displayItemsInStore():");
        mystore.displayItemsInStore();
    }
}
