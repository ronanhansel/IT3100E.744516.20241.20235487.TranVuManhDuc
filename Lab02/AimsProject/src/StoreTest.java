
public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store(10);
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Movie 1");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Movie 2");

        store.addDVD(dvd1);
        store.addDVD(dvd2);

        store.removeDVD(dvd1);
    }
}