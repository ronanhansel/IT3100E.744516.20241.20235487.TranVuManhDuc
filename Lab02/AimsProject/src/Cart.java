public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    // Add a single DVD
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (this.qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full");
        } else if (this.qtyOrdered == (MAX_NUMBERS_ORDERED - 1)) {
            System.out.println("The cart is almost full");
        } else {
            this.itemsOrdered[qtyOrdered] = disc;
            qtyOrdered += 1;
            System.out.println("The disc has been added");
            System.out.println("Current disc: " + qtyOrdered);
        }
    }

    // Add multiple DVDs using array
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (this.qtyOrdered == MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is full");
                break;
            } else if (this.qtyOrdered == (MAX_NUMBERS_ORDERED - 1)) {
                System.out.println("The cart is almost full");
            }
            this.itemsOrdered[qtyOrdered] = disc;
            qtyOrdered += 1;
            System.out.println("The disc has been added");
            System.out.println("Current disc: " + qtyOrdered);
        }
    }

    // Add multiple DVDs using varargs
    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (this.qtyOrdered == MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is full");
                break;
            } else if (this.qtyOrdered == (MAX_NUMBERS_ORDERED - 1)) {
                System.out.println("The cart is almost full");
            }
            this.itemsOrdered[qtyOrdered] = disc;
            qtyOrdered += 1;
            System.out.println("The disc has been added");
            System.out.println("Current disc: " + qtyOrdered);
        }
    }

    // Remove a DVD
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean removed = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].equals(disc)) {
                // Shift elements left to fill gap
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                removed = true;
                System.out.println("The disc has been removed");
                break;
            }
        }
        if (!removed) {
            System.out.println("The disc was not found in the cart");
        }
    }

    // Getters and setters
    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(int qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }

    // Print cart contents
    public void printCart() {
        System.out.println("***********************CART***********************");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
        }
        System.out.println("***********************************************");
    }

    // Calculate total cost
    public float totalCost() {
        float total = 0.0f;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
}