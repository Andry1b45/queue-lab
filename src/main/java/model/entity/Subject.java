package model.entity;

public class Subject {
    private int id;
    private String name;
    private String href;
    private String image;
    private String alt;


    public Subject(String name, String href, String image, String alt) {
        this.name = name;
        this.href = href;
        this.image = image;
        this.alt = alt;
    }

    public Subject(int id, String name, String href, String image, String alt) {
        this.id = id;
        this.name = name;
        this.href = href;
        this.image = image;
        this.alt = alt;
    }



    public Subject(String name){
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHref() {
        return href;
    }

    public String getImage() {
        return image;
    }

    public String getAlt() {
        return alt;
    }

    @Override
    public String toString() {
        return name+ " " + href+" "+image+" "+ alt;
    }
}
