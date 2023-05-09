//Aaron Gold
//April 10th 2023
//CS280

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Names {
	public static void main(String[] args) {

    Scanner in = null;
    //Creates all 3 hash maps
    HashMap<String, Integer> girlsMap = new HashMap<String, Integer>();
    HashMap<String, Integer> boysMap = new HashMap<String, Integer>();
    HashMap<String, Integer> commonMap = new HashMap<String, Integer>();
    int value = 0, common = 0, girlsTotal = 0, boysTotal = 0, boysTemp, girlsTemp;
    
    String key = null, str = null;
    
    try{
    	//Looks for file "girlsnames.txt"
        in = new Scanner(new FileInputStream("girlnames.txt"));
        while (in.hasNextLine()) {
            str = in.nextLine();
            //Creates hash map with name as the key and the quantity as the value
            int index = str.indexOf(" ");
            key = str.substring(0, index);
            value = Integer.parseInt(str.substring(index + 1));
            //Adds value to the total number of girls
            girlsTotal += value;
            //Puts key/value pair in girls hash map
            girlsMap.put(key, value);
        }
        
} catch(IOException e){}
    
    try{
    	//Looks for file "boysnames.txt"
        in = new Scanner(new FileInputStream("boynames.txt"));
        while (in.hasNextLine()) {
            str = in.nextLine();
            //Creates hash map with name as the key and the quantity as the value
            int index = str.indexOf(" ");
            key = str.substring(0, index);
            value = Integer.parseInt(str.substring(index + 1));
            //Adds value to the total number of boys
            boysTotal += value;
            //Checks if name is in girls hash map. If so, adds to common map
            if (girlsMap.containsKey(key)) {
                commonMap.put(key, value);
            }
            boysMap.put(key, value);
            //Puts key/value pair in boys hash map
        }
    } catch (IOException x){}

    common = commonMap.size();
    //Print statements
    System.out.println("There are a total of " + common + " common names.\n");
    //Prints all names (or keys) in commonMap
    System.out.println(commonMap.keySet());
    System.out.println("\nTotal number of girls in the census: " + girlsTotal + ".\n");
    System.out.println("Total number of boys in the census: " + boysTotal + ".\n");
    
    //Finds total number of boys and girls with each common name
    for (String i: commonMap.keySet())
    {
    	boysTemp = boysMap.get(i);
    	girlsTemp = girlsMap.get(i);
      	System.out.println("For the name " + i + ", there are " + boysTemp + " boys and " + girlsTemp + " girls.");

    }
       
	}
}