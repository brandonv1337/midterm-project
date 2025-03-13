import java.util.Scanner;

public class ToDoListDriver 
{
    public static void main(String[] args) 
    {

        // DueDate date = new DueDate(1, 22, 2022);
        // DueDate date2 = new DueDate(6, 17, 2026);
        // DueDate date3 = new DueDate(4, 9, 2025);
        // DueDate date4 = new DueDate(8, 23, 2026);
        // Task myTask = new Task("Test Task 1","this is to test out our new class", date);





        //System.out.println(myTask);

        //System.out.println("Here is the name of the task: "+myTask.getName());





        // Task myOtherTask = new Task("Second Task!!!","Let's get a couple of tasks into the list", date2);
        // Task myOtherTask1 = new Task("Third Task","Some dummy text for task 3", date3);
        // Task myTask1 = new Task("Fourth Task","More dummy text for task 4", date4);

        // myList.add(myOtherTask);
        // myList.add(myOtherTask1);
        

        // System.out.println(myList);





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
                System.out.println("Please add the day of the due date");
                int day = keyboard.nextInt();
                System.out.println("Please enter the month of the due date(1-12): ");
                int month = keyboard.nextInt();
                System.out.println("Please enter the year of the due date: ");
                int year = keyboard.nextInt();
                System.out.println("Would you like this task to be repatable(Y/N): ");
                String r = keyboard.nextLine();
                TaskRepeat repeatable;
                if(r.equals("Y")){
                    repeatable = new TaskRepeat(true);
                
                }
                else if (r.equals("N")){
                    repeatable = new TaskRepeat(false);
                }
                
                DueDate date = new DueDate(month,day,year);
                Task myTask = new Task(name, "is due on", date, repeatable.isRepeatable());

                keyboard.nextLine(); // keyboard bug fix 
                System.out.println(myTask);

                ToDoList myList = new ToDoList();

                myList.add(myTask);
    
            }

        }
        for(int i;i<myList.length();i++){
            System.out.println("did you compleate this task?(Y/N): ");
            String y = keyboard.nextLine();
            if(y.equals("Y")){
                myList[i].markComplete();
                boolean h = myList[i].isRepeatable();
                if(h=true){
                    //call task repeat with the same name of task but with additional days added to due date
                    // add this task to the task list
                }
            
            }
            else if (y.equals("N")){
                
            }
        }
        Schedule s = new Schedule();


        s.addToDoList(myList);
        System.out.println(s.isInSchedule(myOtherTask));
        System.out.println(s);
        newList.add(myTask1);
        s.addToDoList(newList);
        System.out.println(s);




    }
}
