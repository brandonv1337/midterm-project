public class ToDoListDriver 
{
    public static void main(String[] args) 
    {

        DueDate date = new DueDate(1, 22, 2022);
        DueDate date2 = new DueDate(6, 17, 2026);
        DueDate date3 = new DueDate(4, 9, 2025);
        DueDate date4 = new DueDate(8, 23, 2026);
        Task myTask = new Task("Test Task 1","this is to test out our new class", date);

        //System.out.println(myTask);

        myTask.markComplete();

        //System.out.println(myTask);

        //System.out.println("Here is the name of the task: "+myTask.getName());

        ToDoList myList = new ToDoList();
        ToDoList newList = new ToDoList();

        myList.add(myTask);

        Task myOtherTask = new Task("Second Task!!!","Let's get a couple of tasks into the list", date2);
        Task myOtherTask1 = new Task("Third Task","Some dummy text for task 3", date3);
        Task myTask1 = new Task("Fourth Task","More dummy text for task 4", date4);

        myList.add(myOtherTask);
        myList.add(myOtherTask1);
        

        System.out.println(myList);


        Schedule s = new Schedule();


        s.addToDoList(myList);
        System.out.println(s.isInSchedule(myOtherTask));
        System.out.println(s);
        newList.add(myTask1);
        s.addToDoList(newList);
        System.out.println(s);


    }
}
