package HPDB;


import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class DatabaseManager {
    Scanner sc = new Scanner(System.in);
    final String PatientFolder = "//HOSPITAL_DATABASE//PATIENTS//";
    // Method to count the number of folders
    private int count() {
        int result = 0;
        File dir = new File(PatientFolder);
        File[] files = dir.listFiles();
        if (files != null) { // If the directory exists and is not empty
            for (File file : files) {
                if (file.isFile()) {
                    result++;
                }
            }
        }
        return result;
    }

    // Method to add a new patient and create a folder
    public void addPatient() {
        System.out.println("\n\n\n\n\nEnter the following");
        System.out.print("Full Name (50 characters max): ");
        String name = sc.nextLine();
        System.out.print("Age: ");
        String age = sc.nextLine();
        System.out.print("Phone Number (Indian): ");
        String ph = sc.nextLine();

        PATIENT patient = new PATIENT(name, age, ph);
        System.out.println("Verify the data: \n" + patient.toCSV());
        System.out.print("Are you sure you want to add this patient? (y/n): ");
        char confirmation = sc.next().charAt(0);
        sc.nextLine(); // Consume the leftover newline

        if (confirmation == 'y' || confirmation == 'Y') {
            System.out.println("Patient will be added. Please wait!!!");

            // Get the next folder number by calling count
          LocalDateTime currentDate = LocalDateTime.now();
          DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyyMM");
          DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
          String reg = currentDate.format(formatter2);
          String ID = currentDate.format(formatter1)+count();
          File bugga = new File(PatientFolder);
          System.out.println(bugga.getPath());
          
            String newPath = PatientFolder + ID;
                             System.out.println(newPath);
            
            Properties file = new Properties();
            file.setProperty("ID",ID);
            file.setProperty("name", name);
            file.setProperty("age", age);
            file.setProperty("ph", ph);
            file.setProperty("reg",reg);
            file.setProperty("reports", "no reports yet");
            try (FileOutputStream out = new FileOutputStream(newPath)) {
                file.store(out, ID);
                System.out.println("Successfully saved patient at "+newPath);
            } catch (Exception e) {
                System.out.println("AN ERROR OCCURED!!!");
            }

            
        } else {
            System.out.println("Patient addition canceled.");
        }
    }

}
