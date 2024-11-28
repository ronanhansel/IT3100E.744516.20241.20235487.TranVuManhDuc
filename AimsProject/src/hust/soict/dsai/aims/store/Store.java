package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[100]; // Giới hạn 100 DVD trong cửa hàng
    private int currentItemCount = 0; // Số DVD hiện có trong cửa hàng

    // Phương thức thêm DVD vào cửa hàng

    public void addDVD(DigitalVideoDisc dvd) {
        if (currentItemCount < itemsInStore.length) {
            itemsInStore[currentItemCount] = dvd;
            currentItemCount++;
            System.out.println("DVD \"" + dvd.getTitle() + "\" has been added to the store.");
        } else {
            System.out.println("Store is full. Cannot add more DVDs.");
        }
    }

    // Phương thức xóa DVD khỏi cửa hàng
    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < currentItemCount; i++) {
            if (itemsInStore[i].equals(dvd)) {
                found = true;
                // Di chuyển các DVD phía sau lên một vị trí
                for (int j = i; j < currentItemCount - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[currentItemCount - 1] = null;
                currentItemCount--;
                System.out.println("DVD \"" + dvd.getTitle() + "\" has been removed from the store.");
                break;
            }
        }

        if (!found) {
            System.out.println("DVD \"" + dvd.getTitle() + "\" not found in the store.");
        }
    }

    // Phương thức in danh sách DVD có trong cửa hàng
    public void printStore() {
        System.out.println("***********************STORE***********************");
        System.out.println("Available DVDs:");
        if (currentItemCount == 0) {
            System.out.println("No DVDs available in the store.");
        } else {
            for (int i = 0; i < currentItemCount; i++) {
                System.out.println((i + 1) + ". " + itemsInStore[i]);
            }
        }
        System.out.println("***************************************************");
    }
}
