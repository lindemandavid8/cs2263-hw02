package edu.isu.cs.cs2263;

public class Course {
    private int number;
    private String subject;
    private String title;

    public Course(int cNum, String subj, String titl){
        //Does course stuff
        this.number = cNum;
        this.subject = subj;
        this. title = titl;
    }
    //setters
    public void setNumber(int num){
        number = num;
    }
    public void setSubject(String subj){
        subject = subj;
    }
    public void setTitle(String title){
        title = title;
    }
    //getters
    public int getNumber(){
        return number;
    }
    public String getSubject(){
        return subject;
    }
    public String getTitle(){
        return title;
    }
    public String toString(){
        return subject + " " + number + " " + title;
    }
}
