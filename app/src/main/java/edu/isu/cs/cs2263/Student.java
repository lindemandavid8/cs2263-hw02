package edu.isu.cs.cs2263;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private ArrayList<Course> courses;

    public void Student(){
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
    }
    //constructor
    public void initStudent(String firName, String lasName, ArrayList<Course> courseList){
        this.setFirstName(firName);
        this.setLastName(lasName);
        this.setCourses(courseList);
    }

    //setters
    public void setFirstName(String name){
        firstName = name;
    }
    public void setLastName(String name){
        lastName = name;
    }
    public void setCourses(ArrayList<Course> courselist) { courses = courselist; }
    //getters
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public ArrayList<Course> getCourses(){return courses;}
    public String getCoursesAsString() {
        String courseView = "";
        Boolean firstView = true;
        for(Course cors : courses){
            if(firstView){
                courseView += cors.toString();
                firstView = false;
            }else{courseView += "\n" + cors.toString();}
        }
        return courseView;
    }
    //add courses
    public void addCourse(Course course){
        courses.add(course);
    }
    public void removeCourse(Course course){
        courses.remove(course);
    }

    public String getName(){return firstName+ " " + lastName;}

    public String toString(){
        return firstName + " " + lastName + " taking...\n" + courses;
    }

}
