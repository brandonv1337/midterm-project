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
            else; 
            System.out.println("Would you like this task to nest another task?(Y/N):");
            String Nested = keyboard.nextLine();
            if(Nested.equals("N")){

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



                myList.add(myTask);
            }
            else if(item.equals("Y")){
                System.out.println( "Lets make your dependant task! This will be the task that shows once another taks is completed.");

                System.out.println("Please enter the new task name: "); 
                String name = keyboard.nextLine();
                System.out.println("Please enter the description of the new task: "); 
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
                
                System.out.println( "Lets make your independant task!");
                
                System.out.println("Please enter the new task name: "); 
                String name2 = keyboard.nextLine();
                System.out.println("Please enter the description of the new task: "); 
                String description2 = keyboard.nextLine();
                System.out.println("Please add the day of the due date");
                int day2 = keyboard.nextInt();
                System.out.println("Please enter the month of the due date(1-12): ");
                int month2 = keyboard.nextInt();
                System.out.println("Please enter the year of the due date: ");
                int year2 = keyboard.nextInt();
                System.out.println("Would you like this task to be repatable(Y/N): ");
                String r2 = keyboard.nextLine();
                                
                TaskRepeat repeatable2;
                DueDate date2 = new DueDate(month2,day2,year2);
                Task myTask2;
                if(r2.equals("Y")){
                    repeatable2 = new TaskRepeat(true);
                    System.out.println("how many days would you like to extend each time");
                    int days = keyboard.nextInt();
                    myTask2 = new NestedTask(name2, description2, date2, repeatable2.isRepeatable(), days, myTask);
                }
                else{
                    repeatable2 = new TaskRepeat(false);
                    myTask2 = new NestedTask(name2, description2, date2, repeatable2.isRepeatable(), myTask);
                }
                
                

                keyboard.nextLine(); // keyboard bug fix 
                System.out.println(myTask2);



                myList.add(myTask2);
    
            }

        }

    
        for(int i=0;i<myList.size();i++){
            myList.get(i).isCompleate();
            System.out.println("did you complete this task?(Y/N): ");
            String y = keyboard.nextLine();
            if(y.equals("Y")){
                if(myList.get(i).isNested() == true){ 
                    NestedTask Mytask = (NestedTask) myList.get(i);
                    Task Mytask2 = Mytask.getNested();
                    myList.get(i).markComplete();
                    myList.add(Mytask2);
                }
                else{
                myList.get(i).markComplete();                   
                }

            }
            

        }
        }
    
        Schedule s = new Schedule();

        System.out.println("Here is your updated ToDo list");
        keyboard.close();

        s.addToDoList(myList);
        System.out.println(s);

        // for(int y=0;y<myList.size();y++){
        //     System.err.println(myList.get(y));
        // }




        // s.addToDoList(myList);
        // System.out.println(s.isInSchedule(myOtherTask));
        // System.out.println(s);
        // newList.add(myTask1);
        // s.addToDoList(newList);
        // System.out.println(s);




    }

