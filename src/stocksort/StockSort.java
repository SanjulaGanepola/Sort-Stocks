/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stocksort;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 348676487
 */
public class StockSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Sorting helper class        
        Sorts sort = new Sorts();

        //Add unsorted data from the file to an array
        StockInfo[] unsortedInfo = fileToArray("stockdataunsorted.txt");

        //Store the bubble sorted data
        StockInfo[] sortedInfo = (StockInfo[]) sort.bubbleSort(unsortedInfo);

        //Write the sorted array to a file
        arrayToFile(sortedInfo, "stockdatasorted.txt");
    }

    public static StockInfo[] fileToArray(String fileName) {
        //Temporary arraylist for holding the stocks in the file
        ArrayList<StockInfo> tempInfo = new ArrayList<StockInfo>();
        //Initialize file using the given file name
        File f = new File(fileName);
        Scanner s = null;
        try {
            //Scanner for reading the file
            s = new Scanner(f);
            //Add each line as an element into the array
            while (s.hasNextLine()) {
                //Split the line using commas
                String[] split = s.nextLine().split(",");
                //Loop through the information of a stock
                for (int i = 0; i < split.length; i++) {
                    //Check if the category is blank or is not applicable
                    if (split[i].equals("NA") || split[i].equals("")) {
                        //Replace the text with a -1
                        split[i] = "-1";
                    }
                }
                //Add the stock to the array list
                tempInfo.add(new StockInfo(Double.parseDouble(split[0]), split[1], Double.parseDouble(split[2]), Double.parseDouble(split[3]), Double.parseDouble(split[4]), Double.parseDouble(split[5]), Double.parseDouble(split[6])));
            }
            //Close the scanner
            s.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        //Array of all the stocks from the file
        return tempInfo.toArray(new StockInfo[tempInfo.size()]);
    }

    public static void arrayToFile(StockInfo[] list, String fileName) {
        //Initialize file using the given file name
        File f = new File(fileName);
        try {
            //Initialize PrintWriter to write to the sorted file
            PrintWriter pw = new PrintWriter(new FileWriter(f, false));
            //Loop through the array
            for (int i = 0; i < list.length; i++) {
                //Write the element to the file
                pw.println(list[i]);
            }
            //Close the PrintWriter
            pw.close();
        } catch (IOException ex) {
            System.out.println("IO Error");
        }
    }
}
