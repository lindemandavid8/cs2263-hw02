package edu.isu.cs.cs2263;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.reflect.TypeToken;
import netscape.javascript.JSException;

import java.util.List;

public class IOManager {

    /**
     * read a JSON file that contains a List of Student objects
     */
    public static ArrayList<Student> readData(String file) throws IOException{

        Gson fileGson = new Gson();


        try {
            Type studentListType = new TypeToken<ArrayList<Student>>(){}.getType();
            BufferedReader read = new BufferedReader(new FileReader(file));
            ArrayList<Student> studlst = fileGson.fromJson(read, studentListType);
            read.close();
            return studlst;
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return null;
    }

    /**
     * writes data to an existing json file
     */
    public static void writeData(String file, ArrayList<Student> data){
        Gson fileGson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try {
            FileWriter writer = new FileWriter(file);
            fileGson.toJson(data, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}