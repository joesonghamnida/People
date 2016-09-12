import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Reads a csv file and maps country name to a list of people who are from that country.
 * Then, for each list sorts by last name.
 */
public class People {

    static HashMap<String, ArrayList<Person>> personMap = new HashMap<>();
    static ArrayList<Person> personList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Scanner keyboard = new Scanner(System.in);

        readFile();
        writeOutput();
    }


    public static HashMap readFile()throws IOException{

        String personPrevious = "";
        //read file in
        File f = new File("people.csv");
        Scanner fileScanner = new Scanner(f);

        while (fileScanner.hasNext()) {


            String line = fileScanner.nextLine();
            String[] columns = line.split(",");

            //assign country key
            String key = columns[4];
            //keys okay

            //assign values
            Person person = new Person(columns[1], columns[2], columns[4]);
            //values being assigned properly

            if (personMap.containsKey(key)) {
                personList = personMap.get(key);
                personList.add(person);
                Collections.sort(personList);
            } else {
                personList = new ArrayList<>();
                personList.add(person);
                personMap.put(key, personList);
                Collections.sort(personList);
            }

        }//end while
        fileScanner.close();
        return personMap;
    }

    public static void writeOutput() {

        for (ArrayList list : personMap.values())
        {
            System.out.println(list);
        }
    }

    public static void writeFile()throws IOException{

    File j = new File("person.json");

    //write json boilerplate
    //helper method
    //need to use getter and setter for serializer
    JsonSerializer serializer = new JsonSerializer();
            serializer.include("*");
    String json = serializer.serialize(personMap);
            System.out.println(json);
    FileWriter fw = new FileWriter(j);
            fw.write(json);
            try

    {
        fw.close();
    } catch(
    IOException e)

    {
        e.printStackTrace();
    }
}
    }



