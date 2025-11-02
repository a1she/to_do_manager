package todo.manager;

import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.nio.file.Path;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main{
public static void main(String[] args) {
    int choice;

    Scanner myScanner = new Scanner(System.in);

    System.out.println("Welcome to Todo Manager! This programme will help you keep track of your tasks.");

    System.out.println("Would you like to proceed? Yes/No");

    String proceed = myScanner.nextLine();
    //do while loop
    while (proceed.equals("Yes") || proceed.equals("yes")) {
        System.out.println("Now, Let's begin... In this programme you have a variety of choices:");
        System.out.println("Option 1: Create a new task");
        System.out.println("Option 2: List all tasks");

        do {
            System.out.println("Please select (1-4)");
            choice = myScanner.nextInt();
        }
        while ((!(choice > 0 && choice < 5)));

        if (choice == 1) {
            //shouldn't ID be automatic: UUID
            System.out.println("Enter an ID");
            int taskID = myScanner.nextInt();
            myScanner.nextLine();
            System.out.println("Give the task a title");
            String taskTitle = myScanner.nextLine();
            
            System.out.println("Enter an due date in the format dd-mm-yyyy");
            String taskDueDate = myScanner.nextLine();
            
            //don't know if this should be here:
            try {
                //gets location of the file path
                Path filePath= Paths.get("taskData.json"); 
                //location passed so that writer knows where to write to & opens/creates buffer writer
                BufferedWriter writer = Files.newBufferedWriter(filePath);
                //create a hashmap with values string & object and store in task.
                Map<String, Object> task = new HashMap<String, Object>();

                //add hashmap values to task
                task.put("ID", taskID);
                task.put("Title", taskTitle);
                task.put("Due Date", taskDueDate);

                //this is specfically for a new task so might have to create a sperate method for this
                task.put("Done ", false);
                //create instance of gson
                Gson gson = new Gson();
                //converts java objects from task into json values
                String inJson = gson.toJson(task);
                //add json values to file location
                writer.write(inJson);
                writer.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if (choice == 2){
            try {
                
            } catch (Exception e) {
                // TODO: handle exception
            }

        }
    }

    if (proceed.equals("No")) {
        System.out.println("Goodbye!");
    }
    myScanner.close();
}
}
