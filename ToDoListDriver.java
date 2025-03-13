import java.util.Scanner;

public class ToDoListDriver 
{
    public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);
 
        // Task myTask = new Task("Test Task 1","this is to test out our new class", date);





        //System.out.println(myTask);

        //System.out.println("Here is the name of the task: "+myTask.getName());





        // Task myOtherTask = new Task("Second Task!!!","Let's get a couple of tasks into the list", date2);
        // Task myOtherTask1 = new Task("Third Task","Some dummy text for task 3", date3);
        // Task myTask1 = new Task("Fourth Task","More dummy text for task 4", date4);

        // myList.add(myOtherTask);
        // myList.add(myOtherTask1);
        

        // System.out.println(myList);

        // DueDate date = new DueDate(1, 22, 2022);
        // DueDate date2 = new DueDate(6, 17, 2026);
        // DueDate date3 = new DueDate(4, 9, 2025);
        // DueDate date4 = new DueDate(8, 23, 2026);
        ToDoList myList = new ToDoList();
        System.out.println("How many tasks do you want to add? (Type a number)");
        int count = keyboard.nextInt();
        keyboard.close();
        
        for (int x = 0; x < count; x++){
            Task newTask = userInput();
            myList.add(newTask);
        }

        Schedule s = new Schedule();

        s.addToDoList(myList);
        System.out.println(s);

    }

    public static Task userInput(){

        Scanner keyboard = new Scanner(System.in);

                System.out.println("Please enter the task name: "); 
                String name = keyboard.nextLine();
                System.out.println("Please add the day of the due date");
                int day = keyboard.nextInt();
                System.out.println("Please enter the month of the due date(1-12): ");
                int month = keyboard.nextInt();
                System.out.println("Please enter the year of the due date: ");
                int year = keyboard.nextInt();
                System.out.println("Please give a basic description of the task: ");
                String description = keyboard.nextLine();
                DueDate date = new DueDate(month,day,year);
                Task myTask = new Task(name, description, date);
                keyboard.close();
                return myTask;
    }
}
