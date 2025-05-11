package Diary_Manager;

import java.time.LocalDate;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner myscanner = new Scanner(System.in);
        Diary_Manager mydiary = new Diary_Manager(new ArrayList<Entry>());
        mydiary.loadEntries();

        boolean loop = true;

        try{
          while (loop){
              System.out.println("1. Add Entry");
              System.out.println("2. View Entries");
              System.out.println("3. Search Entries");
              System.out.println("4. Exit and Save");
              int userchoice = myscanner.nextInt();
              myscanner.nextLine();
              switch (userchoice) {
                  case 1:

                      System.out.println("Enter Entry title: ");
                      String title = myscanner.nextLine();

                      System.out.println("Enter Entry content: ");
                      String content = myscanner.nextLine();

                      LocalDate date = LocalDate.now();
                      try {
                          Entry newentry = new Entry(date, title, content);
                          mydiary.addEntry(newentry);
                          System.out.println(title + " has been successfully added to diary at " + date);
                      } catch (IllegalArgumentException e) {
                          System.out.println("Failed to create entry: " + e.getMessage());
                      }



                      break;
                  case 2:
                      System.out.println(mydiary.getAllEntries());
                      break;
                  case 3:
                      System.out.println("Enter text");
                      String text = myscanner.nextLine();

                      mydiary.searchEntry(text);
                      break;
                  case 4:
                      mydiary.saveAllEntries();
                      System.out.println("Exiting and saving diary...");
                      loop = false;
                      break;
                  default:
                      System.out.println("Please select a valid option.");
                      break;
              }

          }

        }
        catch (InputMismatchException e){
            System.out.println("Please enter a valid input!");
        }
        catch (Exception e){
            System.out.println("Error Occurred: " + e.getMessage());
        }
    }
}
