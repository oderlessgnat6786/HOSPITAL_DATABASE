package HPDB;

import java.util.*;
public class main {

    public static void main(String[] args) {
        DatabaseManager db = new DatabaseManager();
        Scanner sc = new Scanner(System.in);
        String hospitalName = "PRO DEV";

        while (true) {
            System.out.println("\t\t!!!WELCOME TO " + hospitalName + " DATABASE!!!");
            System.out.println("CHOOSE MODE:\n\t1 - VIEW INSTRUCTIONS\n\t2 - ADD PATIENT\n\t2 - VIEW PATIENTS\n\t3 - REMOVE PATIENT\n\t4 - EDIT PATIENT\n(any other input to exit)");

            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                sc.nextLine(); // Consume the leftover newline

                switch (choice) {
                    case 1:
                        System.out.println("\n\n\n\n\n nothing but if you choose mode 100 (type 100) then you will get access to the file path in file explorer \n\n\n\n\n");
                        break;
                    case 2:
                        db.addPatient();
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 100:
                        break;
                    default:
                        System.out.println("!!! PROGRAM ENDED !!!");
                        sc.close();
                        System.exit(0);
                }
            } else {
                System.out.println("Invalid input. Exiting program.");
                sc.close();
                System.exit(0);
            }
        }
    }
}
