public class DigitalVideoDisc {
    private static int nbDigitalVideoDiscs = 0;
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private int id;
 	@Override
    public String toString() {
        return String.format("DVD - %s - %s - %s - %d: %.2f $",
            title, category, director, length, cost);
    }

    public boolean isMatch(String title) {
        return this.title.toLowerCase().contains(title.toLowerCase());
    }
	public int getId() {
        return id;
    }

    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		if(length < 0) {
			this.length = 0;
		}
		else {
			this.length = length;
		}
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		if(cost < 0) {
			this.cost = 0.0f;
		}
		else {
			this.cost = cost;
		}		
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	public void show() {
		System.out.println(("Title: "+title));
		System.out.println("Category: "+category);
		System.out.println("Director: "+director);
		System.out.println("Length: "+length);
		System.out.println("Cost "+ cost);
	}
	

}