public class Aims {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Create a new cart
		Cart anOrderCart = new Cart();
		
		//create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Aller",87,24.95f);
		anOrderCart.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,19.95f);
		anOrderCart.addDigitalVideoDisc(dvd2);
		
		// only title , category and cost
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
		anOrderCart.addDigitalVideoDisc(dvd3);
		anOrderCart.show_cart();
		
		//print total cost of the items in the cart
		System.out.println("Total cost is: ");
		System.out.println(anOrderCart.totalCost());
		
		//delete one DVDS in the cart 
        anOrderCart.removeDigitalViDeoDisc(dvd2);
        anOrderCart.show_cart();
	}

}