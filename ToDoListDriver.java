import java.util.Scanner;
/**
 * Class that drives the code asking for user input
 */
public class ToDoListDriver 
{
    public static void main(String[] args) 
    {



        ToDoList myList = new ToDoList(); //uses ToDoList class to make a new empty list



        Scanner keyboard = new Scanner(System.in);
        boolean finished = false;
        //while statment that initailizes values for each task and fills the to do list with as many tasks as the user wants.
        while (finished == false) {
            System.out.println("Would you like to enter another Task?(Y/N): "); 
            String item = keyboard.nextLine(); // reads statment to see if it should ask for another entry
            if(item.equals("N")){
                finished = true;
            }
            else{
            System.out.println("Would you like this task to nest another task?(Y/N):"); // figures out if this new task should be a nested one or not 
            String Nested = keyboard.nextLine();
            if(Nested.equals("N")){

                System.out.println("Please enter the task name: "); 
                String name = keyboard.nextLine();
                System.out.println("Please enter the description of the task: "); 
                String description = keyboard.nextLine();
                System.out.println("Please add the day of the due date");
                int day = keyboard.nextInt();
                keyboard.nextLine(); // Consume newline left-over
                System.out.println("Please enter the month of the due date(1-12): ");
                int month = keyboard.nextInt();
                keyboard.nextLine(); // Consume newline left-over
                System.out.println("Please enter the year of the due date: ");
                int year = keyboard.nextInt();
                keyboard.nextLine(); // Consume newline left-over
                System.out.println("Would you like this task to be repatable(Y/N): ");
                String r = keyboard.nextLine();
                                
                TaskRepeat repeatable; //initializes repeatable vale
                DueDate date = new DueDate(month,day,year); // creates the duedate for the task
                Task myTask;
                if(r.equals("Y")){
                    repeatable = new TaskRepeat(true);
                    System.out.println("how many days would you like the due date to extend by each time the task is repeated? :");
                    int days = keyboard.nextInt();
                    myTask = new Task(name, description, date, repeatable.isRepeatable(), days); //has parapeter days for if the task is being repated
                }
                else{
                    repeatable = new TaskRepeat(false);
                    myTask = new Task(name, description, date, repeatable.isRepeatable());//no days peramater and repatable is set to false 
                }
                
                

                keyboard.nextLine(); // keyboard bug fix 
                System.out.println(myTask);



                myList.add(myTask);
            }
            //does the same thing as above but for a nested task
            else if(Nested.equals("Y")){ 
                System.out.println( "Lets make your dependant task! This will be the task that shows once another taks is completed.");

                System.out.println("Please enter the new task name: "); 
                String name = keyboard.nextLine();
                System.out.println("Please enter the description of the new task: "); 
                String description = keyboard.nextLine();
                System.out.println("Please add the day of the due date");
                int day = keyboard.nextInt();
                keyboard.nextLine(); // Consume newline left-over
                System.out.println("Please enter the month of the due date(1-12): ");
                int month = keyboard.nextInt();
                keyboard.nextLine(); // Consume newline left-over
                System.out.println("Please enter the year of the due date: ");
                int year = keyboard.nextInt();
                keyboard.nextLine(); // Consume newline left-over
                System.out.println("Would you like this task to be repatable(Y/N): ");
                String r = keyboard.nextLine();

                                
                TaskRepeat repeatable;
                DueDate date = new DueDate(month,day,year);
                Task myTask;
                if(r.equals("Y")){
                    repeatable = new TaskRepeat(true);
                    System.out.println("how many days would you like to extend each time");
                    int days = keyboard.nextInt();
                    keyboard.nextLine(); // Consume newline left-over
                    myTask = new Task(name, description, date, repeatable.isRepeatable(), days);
                }
                else{
                    repeatable = new TaskRepeat(false);
                    myTask = new Task(name, description, date, repeatable.isRepeatable());
                }
                
                System.out.println( "Lets make your independant task!");
                
                System.out.println("Please enter the new task name: "); 
                String name2 = keyboard.nextLine();
                System.out.println("Please enter the description of the new task: "); 
                String description2 = keyboard.nextLine();
                System.out.println("Please add the day of the due date");
                int day2 = keyboard.nextInt();
                keyboard.nextLine(); // Consume newline left-over
                System.out.println("Please enter the month of the due date(1-12): ");
                int month2 = keyboard.nextInt();
                keyboard.nextLine(); // Consume newline left-over
                System.out.println("Please enter the year of the due date: ");
                int year2 = keyboard.nextInt();
                System.out.println("Would you like this task to be repatable(Y/N): ");
                String r2 = keyboard.nextLine();
                keyboard.nextLine(); // Consume newline left-over
                                
                TaskRepeat repeatable2;
                DueDate date2 = new DueDate(month2,day2,year2);
                Task myTask2; 
                if(r2.equals("Y")){
                    repeatable2 = new TaskRepeat(true);
                    System.out.println("how many days would you like to extend each time");
                    int days = keyboard.nextInt();
                    myTask2 = new NestedTask(name2, description2, date2, repeatable2.isRepeatable(), days, myTask); //creates independent task for nested task
                }
                else{
                    repeatable2 = new TaskRepeat(false);
                    myTask2 = new NestedTask(name2, description2, date2, repeatable2.isRepeatable(), myTask);  //creates independent task for nested task
                }
                
                

                keyboard.nextLine(); // keyboard bug fix 
                System.out.println(myTask2);



                myList.add(myTask2); 
    
            }
        }

        }

        // Loops through the entirty of the list asking if it is compeated or not.
        //if the task is compleated and is repeatable it gets sent over to the task repeat class
        for(int i=0;i<myList.size();i++){
            myList.get(i).isCompleate();
            System.out.println("did you complete this task?(Y/N): ");
            String y = keyboard.nextLine();
            if(y.equals("Y")){
                if(myList.get(i).isNested()
                ){ 
                    NestedTask Mytask = (NestedTask) myList.get(i);
                    Task Mytask2 = Mytask.getNested();
                    myList.get(i).markComplete(); // gets sent to mark compleate method in Task.java
                    myList.add(Mytask2);
                }
                else{
                myList.get(i).markComplete();  // gets sent to mark compleate method in Task.java           
                }

            }
            

        }
        
    
    
        Schedule s = new Schedule(); 

        System.out.println("Here is your updated ToDo list"); 
        keyboard.close();

        s.addToDoList(myList);
        System.out.println(s); //prints out final schedule with all tasks updated. 

    }




}
