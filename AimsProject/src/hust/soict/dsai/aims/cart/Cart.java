public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED]; 
			//Add a field as an array to store a list of DigitalVideoDisc.
	private int qtyOrdered = 0 ;
	
	//method add
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(this.qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full");
		}
		else if (this.qtyOrdered == (MAX_NUMBERS_ORDERED -1)) {
			System.out.println("The cart is almost full");			
		}
		else {
			this.itemsOrdered[qtyOrdered ] = disc;
			qtyOrdered += 1;
			System.out.println(("The disc have been added"));
			System.out.println("Current disc: "+ qtyOrdered);
		}
	}
	
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}
	public void removeDigitalViDeoDisc(DigitalVideoDisc disc) {
	    boolean removed = false;
	    
	    if (qtyOrdered == 0) {
	        System.out.println("There is no disc inside cart");
	    } else {
	        for (int i = 0; i < qtyOrdered; i++) {
	            if (this.itemsOrdered[i] == disc) {
	                for (int j = i; j < qtyOrdered - 1; j++) {
	                    itemsOrdered[j] = itemsOrdered[j + 1];
	                }
	                removed = true;
	                break;
	            }
	        }
	        
	        if (removed) {
	            qtyOrdered--;
	            System.out.println("The disc has been removed");
	            System.out.println("Total disc: " + this.qtyOrdered);
	        } else {
	            System.out.println("No disc found");
	        }
	    }
	}


	public float totalCost() {
		float total = 0.0f;
		for(int i = 0; i < qtyOrdered; i++) {
			total += itemsOrdered[i].getCost();
		}
		return total;
	}
	public void show_cart() {
		for(int i = 0; i < qtyOrdered; i++) {
			itemsOrdered[i].show();
		}
	}
 public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.printf("%d. %s\n", (i + 1), itemsOrdered[i].toString());
        }
        System.out.printf("Total cost: %.2f $\n", totalCost());
        System.out.println("***************************************************");
    }

    public DigitalVideoDisc searchByID(int id) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                return itemsOrdered[i];
            }
        }
        return null;
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println(itemsOrdered[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No match found");
        }
    }
}


public class DVDWrapper {
    public DigitalVideoDisc dvd;
    
    public DVDWrapper(DigitalVideoDisc dvd) {
        this.dvd = dvd;
    }
}

public static void swap(DVDWrapper dvd1, DVDWrapper dvd2) {
    DigitalVideoDisc tmp = dvd1.dvd;
    dvd1.dvd = dvd2.dvd;
    dvd2.dvd = tmp;
}