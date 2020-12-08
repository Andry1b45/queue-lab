package model.entity;

public class Info {
    private String name;
    private String href;
    private String svg;


    public Info(String name, String href, String svg) {
        this.name = name;
        this.href = href;
        this.svg = svg;
    }


    public String getName() {
        return name;
    }

    public String getHref() {
        return href;
    }

    public String getSvg() {
        return svg;
    }
}
