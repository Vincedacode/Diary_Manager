package Diary_Manager;
import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Diary_Manager implements Serializable {
    protected ArrayList<Entry> myentries;

    public Diary_Manager(ArrayList<Entry> myentries) {
        this.myentries = myentries;
    }

    public void displayEntries(){
        for (int i = 0; i < myentries.size(); i++){
            System.out.println(myentries.get(i));
        }
    }
    public void addEntry(Entry myentry) {
        myentries.add(myentry);
        System.out.println("Entry successfully added!");
    }
    public String getAllEntries() {
        if(myentries.isEmpty()){
            System.out.println("Diary is empty!");
        }
        for (int i = 0; i < myentries.size(); i++) {
            System.out.println(myentries.get(i));
        }
        return "Done";
    }

    public void saveAllEntries() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("mydiary.txt"))) {
            out.writeObject(myentries);
            System.out.println("All entries saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void searchEntry(String text) {
      try{
          boolean found = false;
          Pattern mypattern = Pattern.compile(text, Pattern.CASE_INSENSITIVE);

          for (Entry thentry : myentries) {
              Matcher titleMatch = mypattern.matcher(thentry.getTitle());
              Matcher contentMatch = mypattern.matcher(thentry.getContent());

              if (titleMatch.find() || contentMatch.find()) {
                  found = true;
                  System.out.println("Match found!");
                  System.out.println(thentry);
              }
          }

          if (!found) {
              System.out.println("Match not found!");
          }
      }catch (PatternSyntaxException e){
          e.printStackTrace();
      }
    }

    public void loadEntries() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("mydiary.txt"))) {
            myentries = (ArrayList<Entry>) in.readObject();
            System.out.println("Entries loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No previous entries found.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }






}
