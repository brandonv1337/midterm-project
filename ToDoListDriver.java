import java.util.Scanner;

public class ToDoListDriver 
{
    public static void main(String[] args) 
    {



        ToDoList myList = new ToDoList();



        Scanner keyboard = new Scanner(System.in);
        boolean finished = false;

        while (finished == false) {
            System.out.println("Would you like to enter another Task?(Y/N): "); 
            String item = keyboard.nextLine(); // reads statment to see if it should ask for another entry
            if(item.equals("N")){
                finished = true;
            }
            else if(item.equals("Y"))
            {
                System.out.println("Please enter the task name: "); 
                String name = keyboard.nextLine();
                System.out.println("Please enter the description of the task: "); 
                String description = keyboard.nextLine();
                System.out.println("Please add the day of the due date");
                int day = keyboard.nextInt();
                System.out.println("Please enter the month of the due date(1-12): ");
                int month = keyboard.nextInt();
                System.out.println("Please enter the year of the due date: ");
                int year = keyboard.nextInt();
                System.out.println("Would you like this task to be repatable(Y/N): ");
                String r = keyboard.nextLine();
                TaskRepeat repeatable;
                DueDate date = new DueDate(month,day,year);
                Task myTask;
                if(r.equals("Y")){
                    repeatable = new TaskRepeat(true);
                    System.out.println("how many days would you like to extend each time");
                    int days = keyboard.nextInt();
                    myTask = new Task(name, description, date, repeatable.isRepeatable(), days);
                }
                else{
                    repeatable = new TaskRepeat(false);
                    myTask = new Task(name, description, date, repeatable.isRepeatable());
                }
                
                

                keyboard.nextLine(); // keyboard bug fix 
                System.out.println(myTask);



                myList.addTask(myTask);
    
            }

        }

    
        for(int i=0;i<myList.getLength();i++){
            myList.getTask(i).isCompleate();
            System.out.println("did you compleate this task?(Y/N): ");
            String y = keyboard.nextLine();
            if(y.equals("Y")){
                myList.getTask(i).markComplete(myList);
                
            
            }
            else if (y.equals("N")){
                
            }
        }
    
        Schedule s = new Schedule();

        System.out.println("Here is your updated ToDo list");

        for(int y=0;y<myList.getLength();y++){
            System.err.println(myList.getTask(y));
        }




        // s.addToDoList(myList);
        // System.out.println(s.isInSchedule(myOtherTask));
        // System.out.println(s);
        // newList.add(myTask1);
        // s.addToDoList(newList);
        // System.out.println(s);




    }
}
