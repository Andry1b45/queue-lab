package model.entity;

public class Student {
    private int id;
    private String group;
    private String name;
    private String surname;
    private String password;

    public Student(String group, String name, String surname, String password) {
        this.group = group;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    public Student(int id, String group, String name, String surname, String password) {
        this.id = id;
        this.group = group;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return id+ " "+ group+" "+ name+" "+surname+" "+password;
    }

}
