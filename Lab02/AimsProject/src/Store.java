public class Store {
    private DigitalVideoDisc[] itemsInStore;
    private int count;

    public Store(int capacity) {
        itemsInStore = new DigitalVideoDisc[capacity];
        count = 0;
    }

    public void addDVD(DigitalVideoDisc dvd) {
        if (count < itemsInStore.length) {
            itemsInStore[count] = dvd;
            count++;
        } else {
            System.out.println("Store is full, cannot add more DVDs.");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < count; i++) {
            if (itemsInStore[i].equals(dvd)) {
                itemsInStore[i] = itemsInStore[count - 1];
                itemsInStore[count - 1] = null;
                count--;
                break;
            }
        }
    }
}
