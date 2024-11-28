package hust.soict.dsai.aims.test;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        // Tạo đối tượng cửa hàng
        Store store = new Store();

        // Tạo các DVD và thêm vào cửa hàng
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);

        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        // In danh sách DVD có trong cửa hàng
        store.printStore();

        // Xóa một DVD khỏi cửa hàng
        store.removeDVD(dvd2);

        // In lại danh sách DVD sau khi xóa
        store.printStore();

        // Thử xóa DVD không tồn tại trong cửa hàng
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Frozen", "Animation", 20.99f);
        store.removeDVD(dvd4);
    }
}
