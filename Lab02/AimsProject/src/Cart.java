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

}