/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalrecords;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 *  Author Meyer Evenblij
 *  13/10/19
 *  A program to implement and keep track of the hospital patients
 * 
 */
public class HospitalRecords {

    /**
     * @param args the command line arguments
     */
 
    public static void main(String[] args) {
        //  The ArrayList that stores the Patients info
        ArrayList<Patient> patList = new ArrayList<>();
        Boolean foundPatId=false;
        
        String path = "E:\\CPP\\Data Structure & Algorithms\\Practical Task 1\\Question 1\\ListOfPatients.txt";
        //  Path to the ListOfPatients.txt
        
        LineNumberReader lr = null;
        //  Makes it possible to read the patient info 
        String[] oneRecord = new String[4];
       
        //  An array to store patient info
        Patient pat;
        try {
            //  Allows exeption handling to catch possible erros with i/o operations
            FileReader inputStream = new FileReader(path);
            //  Reads the file's contents
            lr = new LineNumberReader(inputStream);
            String str;
           
            while((str = lr.readLine()) != null) {
                //  when another line is found
                oneRecord = str.split(",");
                //  Dividing by a comma and adding to the ArrayList
                pat = new Patient(oneRecord[0], oneRecord[1], oneRecord[2], oneRecord[3]);
                patList.add(pat);
            }
        }
        catch(IOException ioe) {
            System.out.println("IOExcception occured");
        }
        //  Setting the loop to true
        boolean running = true;
       
        //  Performs the loop while the boolean expression is true
        do {
            //  Requires user input and then stores it
            Scanner scannerObject = new Scanner(System.in);
            System.out.println("Press S for search, Press E for exit: ");
            String userInput = scannerObject.nextLine();
            System.out.println(userInput.toUpperCase());
            String outcome = userInput.toUpperCase();

            //  If "S" requires Patient ID 
            if("S".equals(outcome)) {
                System.out.println("Enter Patient ID to search");
                String patientIdInput = scannerObject.nextLine();
                String chosenId = patientIdInput.toUpperCase();
                System.out.println(patientIdInput.toUpperCase());
                
                //  Checks "i" against the patList and if true then executes
                for (int i=0; i<patList.size();i++) {
                    Patient patient = (Patient)patList.get(i);
                   
                    if(chosenId.equals(patient.patientId)){
                        foundPatId = true;
                        System.out.println(patient.toString());
                        System.out.println("Would you like to remove the paitent's"
                                + " record(s)? \nY or N?");
                        String userDelete = scannerObject.nextLine();
                        String confirmDelete = userDelete.toUpperCase();
                        System.out.println(userDelete.toUpperCase());
                        
                        //  If "Yes" the record will be removed from the patList
                        //  If not the "else" statement is executed.
                        if(confirmDelete.equals("Y")) {
                           patList.remove(patient);
                            System.out.println("Record(s) removed sucessfully");
                        } else {
                            System.out.println("You didn't want to remove the record");
                        }
                        
                    } else {
                        foundPatId = false;
                    }
                }
                //  Changes the boolean expression to false so it ends and prints "bye"
            } else {
                running = false;
                System.out.println("Bye...");
                break;
            }          
            
            //  If foundPatId returns false it will say that your search find no  
            //  matching patient
            if(foundPatId == false){
                System.out.println("The search found no matching patient");
            }
            //  Allows the program to be ended if you select "E"
            else if ("E".equals(outcome)) {
                System.out.print("\nBye...\n");
                System.exit(0);
            }
         // keeps the "do" loop continuing until it's "false"
        } while (running == true);
    }
}