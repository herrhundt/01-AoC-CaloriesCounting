import java.io.*;
import java.util.*;

public class CaloriesCounting
{
    static int [] input;
    //static String filename = "input-sample.txt"; //for testing purposes 
    static String filename = "input.txt"; //the original input 
    
    static int[] calories;  //saves calories
    static int countElves =0; //saves number of elves 
    
    /**
     * This method solves the puzzle 
     */
    public static void calcMaxCalories() throws IOException, InterruptedException
    {
        readInputIntoArray(); 
        int tempCal = 0; //saves temporary calories 
        calories = new int[countElves+1]; //last line (-> +1) 
        int j = 0; 
        
        for(int i=0; i<input.length;i++)
        {
            if((input[i]!=0)) //save calories
            {
               tempCal +=input[i]; 
            }
            if (input[i]==0 || i ==input.length-1) //last elv has no next empty line 
            {
               calories[j++] = tempCal; 
               tempCal = 0; //reset calories count (new elve)
            }
        }
        
        //calories saves now all calories of the individual elves 
        Arrays.sort(calories); //sort the array
        int top3Sum = calories[calories.length-1] + calories[calories.length-2] +  calories[calories.length-3];  
        
        System.out.print("The solution is."); Thread.sleep(500); 
        System.out.print("."); Thread.sleep(500); 
        System.out.print("."); Thread.sleep(500); 
        System.out.println();
        
        System.out.println("Maximum:"+calories[calories.length-1]); 
        System.out.println("Sum of the top three calories: "+top3Sum);

    }
 
    /**
     * Die Methode liest den Input der Textdatei in ein Array ein. 
     */
    public static void readInputIntoArray() throws IOException
    {
    int arraySize =0; 
    try
    {
        arraySize = getInputLength(); 
    }
    catch (IOException e) 
    {
        System.out.println("Es ist ein Fehler beim Einlesen passiert!"); 
        System.exit(1); //Programm beenden
    }
    input = new int[arraySize]; //Erstelle leeres Array mit der Anzahl 
 
    FileReader fr = new FileReader(filename);
    BufferedReader br = new BufferedReader(fr);      
    String zeile = "";
    
    for(int i=0; i<arraySize;i++)
    {
        zeile = br.readLine(); 
        try
        {
            input[i] = Integer.parseInt(zeile); //try to convert the string into an integer  
        }
        catch(NumberFormatException e) 
        {
           input[i] = 0; // empty strings will throw an NumberFormatException --> set value to zero! 
           countElves++; // empty strings indicate ending an elv 
        }
        
    }
      br.close();
      //array should be read correctly  
    }  
    
    /**
     * Methode bestimmt die Länge der Texteingabe 
     */
    public static int getInputLength() throws IOException
    {
     int size = 0;  
     FileReader fr = new FileReader(filename);
     BufferedReader br = new BufferedReader(fr);  
      //Bestimme die Anzahl der Werte! 
     String zeile = "";
     while( (zeile = br.readLine()) != null )
     {
        System.out.println(zeile);
        size++; 
      }
      br.close();
    return size; 
    }    


}
