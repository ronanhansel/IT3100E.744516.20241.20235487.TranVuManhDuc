package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    private static int nbDigitalVideoDiscs = 0;
    private int id;

    public DigitalVideoDisc(String title,int length, String director) {
        super(director,length);
        this.title = title;
        nbDigitalVideoDiscs++;
        id=nbDigitalVideoDiscs;
    }
    public DigitalVideoDisc(String title, String category, float cost,int length,String director) {
        super(director,length);
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        id=nbDigitalVideoDiscs;
    }
    public DigitalVideoDisc(String title, String category, String director, float cost, int length) {
        super(director,length);
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        id=nbDigitalVideoDiscs;
    }
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(director,length);
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        id=nbDigitalVideoDiscs;
    }
    public DigitalVideoDisc(String title, String category, float cost, int length){
        super();
        this.title = title;
        this.category = category;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++;
        id=nbDigitalVideoDiscs;
    }
    public String toString(){
        return "DVD - "+this.title+" - "+this.category+" - "+this.director+" - "+this.length+" - "+this.cost+ "$";
    }
    public boolean isMatch(String name){
        return name.equals(this.title);
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
