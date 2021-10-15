/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package edu.isu.cs.cs2263;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import com.google.gson.Gson;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static edu.isu.cs.cs2263.IOManager.*;

public class App extends Application{
    //public attribute1:type = defaultValue;
    public List<Student> studentList;
    private List<Course> courseList;

    public String getGreeting() { //kept for AppTest.java for now
        return "Hello World!";
    }
    @Override
    public void start(Stage stage) throws Exception {
        //Initialize data structures
        HashMap<String,ArrayList<Course>> displayInfo = new HashMap<>();
        ArrayList<String> studNamesList = new ArrayList<>();


        //read the data then convert it into a form for our display

        //initialize variables for ListViews
        ObservableList<String> studList = FXCollections.observableArrayList(studNamesList);
        ListView<String> listViewStud = new ListView<>(studList);
        ArrayList<Course> studCourse = new ArrayList<>();
        ObservableList<Course> courseList = FXCollections.observableArrayList(studCourse);
        ListView<Course> listViewCourse = new ListView<>(courseList);

        //labels
        Label studL = new Label("Students");
        Label corsL = new Label("Courses");
        Label isTak = new Label("Is Taking...");

        //buttons
        Button button1 = new Button("Load Data");

        //boxes for display
        HBox listBoxes = new HBox(100);
        VBox studVBox = new VBox(10);
        VBox corsVBox = new VBox(10);
        //VBox midVBox = new VBox(10);

        //assign elements to boxes
        studVBox.getChildren().addAll(studL, listViewStud);
        corsVBox.getChildren().addAll(corsL, listViewCourse);
        //midVBox.getChildren().add(isTak);
        listBoxes.getChildren().addAll(studVBox, corsVBox);

        //assign boxes to groups
        Group group = new Group(listBoxes,isTak, button1);

        //Set sizes and positions
        group.minHeight(480);
        group.minWidth(640);

        button1.setLayoutX(480);
        button1.setLayoutY(440);

        isTak.setLayoutY(210);
        isTak.setLayoutX(270);

        //set scene
        Scene scene = new Scene(group, 640, 480);
        stage.setTitle("Homework 2 for CS 2263");
        stage.setScene(scene);
        stage.show();

        button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //writes and/or creates the json file with the predefined data
                String jName = "testJSON.json";
                ArrayList<Student> preJsonStudents = makeTestStudents(); //only used for testing
                writeData(jName, preJsonStudents); //used for testing

                //reads the data from our recently saved json file and updates our scene
                try{
                    ArrayList<Student> tstLst = readData(jName);
                    for(Student s : tstLst){displayInfo.put(s.getName(), s.getCourses());}
                    //sets the listView for the students
                    Set<String> studNamesSet = displayInfo.keySet();
                    for(String s : studNamesSet){studNamesList.add(s);}
                    ObservableList<String> studList = FXCollections.observableArrayList(studNamesList);
                    listViewStud.setItems(studList);
                    ArrayList<Course> studCourse = new ArrayList<>();
                    ObservableList<Course> courseList = FXCollections.observableArrayList(studCourse);
                    listViewCourse.setItems(courseList);
                }
                catch (IOException e) {
                    e.printStackTrace();
                    System.exit(-1);
                }
                button1.setDisable(true); //prevents data from being loaded in multiple times
            }
        });

        //event for when student in the ListView is clicked
        listViewStud.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String curStud = listViewStud.getSelectionModel().getSelectedItem();
                //ListView<Course> lvCourse = setListViewCourse(displayInfo.get(curStud));
                courseList.clear();
                ObservableList<Course> courseList = FXCollections.observableArrayList(displayInfo.get(curStud));
                listViewCourse.setItems(courseList);
            }
        });
    }

    public ListView<Course> setListViewCourse(ArrayList<Course> arryLst){
        ObservableList<Course> obvList = FXCollections.observableArrayList(arryLst);
        ListView<Course> listView = new ListView<>(obvList);
        return listView;
    }

    public static void main(String[] args) throws IOException {
        launch(args); //Application
    }
    public static ArrayList<Student> makeTestStudents() {
        ArrayList<Student> tstStuds = new ArrayList<Student>();
        ArrayList<Course> cStack1 = new ArrayList<Course>();
        ArrayList<Course> cStack2 = new ArrayList<Course>();
        ArrayList<Course> cStack3 = new ArrayList<Course>();
        ArrayList<Course> cStack4 = new ArrayList<Course>();
        Course cor1bw = new Course(1103, "Basket Weaving", "Intro to Basket Weaving");
        Course cor2bw = new Course(2103, "Basket Weaving", "Intermediate Basket Weaving");
        Course cor3bw = new Course(3343, "Basket Weaving", "Galaxy Weave Technique");
        Course cor1al = new Course(1107, "Alchemy", "So you want to turn lead into gold");
        Course cor2al = new Course(1185, "Alchemy", "Philosopher Stone basics");
        Course cor3al = new Course(3221, "Alchemy", "Basics of Homunculi");
        Course cor4al = new Course(4731, "Alchemy", "Advanced Alchemical Reproduction");
        cStack1.add(cor1bw);
        cStack1.add(cor3al);
        cStack1.add(cor2al);
        cStack1.add(cor4al);

        cStack2.add(cor2bw);
        cStack2.add(cor3bw);
        cStack2.add(cor1al);

        cStack3.add(cor3bw);
        cStack3.add(cor3al);
        cStack3.add(cor4al);
        Student stud1 = new Student();
        stud1.initStudent("Frank", "Rudabega", cStack1);

        Student stud2 = new Student();
        stud2.initStudent("Genny", "Badabadaboo", cStack1);

        Student stud3 = new Student();
        stud3.initStudent("Dilbert", "Bilberto", cStack3);

        Student stud4 = new Student();
        stud4.initStudent("Yoda", "Badoda", cStack2);

        Student stud5 = new Student();
        stud5.initStudent("Slacker", "NoClass", cStack4);

        tstStuds.add(stud1);
        tstStuds.add(stud2);
        tstStuds.add(stud3);
        tstStuds.add(stud4);
        tstStuds.add(stud5);

        return tstStuds;
        //System.out.println(readData(jsonNAME));
    }
}
