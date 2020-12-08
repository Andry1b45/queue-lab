package model.entity;

public class ListedSubject {
    private String name;
    private String href;
    private String image;
    private String alt;


    public ListedSubject(String name, String href, String image, String alt) {
        this.name = name;
        this.href = href;
        this.image = image;
        this.alt = alt;
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
}
