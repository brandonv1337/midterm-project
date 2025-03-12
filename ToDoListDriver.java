public class ToDoListDriver 
{
    public static void main(String[] args) 
    {
        Task myTask = new Task("Test Task 1","this is to test out our new class");

        //System.out.println(myTask);

        myTask.markComplete();

        //System.out.println(myTask);

        //System.out.println("Here is the name of the task: "+myTask.getName());

        ToDoList myList = new ToDoList();

        myList.addTask(myTask);

        Task myOtherTask = new Task("Second Task!!!","Let's get a couple of tasks into the list");

        myList.addTask(myOtherTask);

        System.out.println(myList);

    }
}
