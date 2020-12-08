package model.entity;

import java.util.ArrayList;

public class SubjectList {
    private String firstName;
    private ArrayList<ListedSubject> listedSubjects;

    public SubjectList(String name, ArrayList<ListedSubject> listedSubjects) {
        this.firstName = name;
        this.listedSubjects = listedSubjects;
    }

    public String getName() {
        return firstName;
    }


    public ArrayList<ListedSubject> getSubjects() {
        return listedSubjects;
    }


    public void setSubjects(ArrayList<ListedSubject> listedSubjects) {
        this.listedSubjects = listedSubjects;
    }

    @Override
    public String toString() {
        return firstName+" "+ listedSubjects;
    }
}
