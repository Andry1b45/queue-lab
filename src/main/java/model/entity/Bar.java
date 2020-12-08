package model.entity;

public class Bar {
    private String name;
    private String href;
    private String svg;

    public Bar(String name, String href, String svg) {
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

    @Override
    public String toString() {
        return name+ " "+href+" "+svg;
    }
}

