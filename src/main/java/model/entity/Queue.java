package model.entity;

import java.util.Date;

public class Queue {
    private Subject subject;
    private Student student;
    private Date date;

    private String studentName;
    private String studentSurname;

    public Queue(Subject subject, Student student) {
        this.subject = subject;
        this.student = student;
    }

    public Queue(String name, String surname, Date date){
        this.studentName = name;
        this.studentSurname = surname;
        this.date = date;
    }

    public Subject getSubject() {
        return subject;
    }

    public Student getStudent() {
        return student;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return subject +" "+ student+" "+ date;
    }
}
