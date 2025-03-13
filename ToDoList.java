import java.util.ArrayList;

/**
 * class that contains a todo list made up of task objects
 */
public class ToDoList 
{
    private ArrayList<Task> tasks;

    /**
     * ToDoList
     * constructor that makes an empty list
     */
    public ToDoList()
    {
        tasks = new ArrayList<Task>();
    }

    /**
     * toString
     * to string method for the todo list
     */
    public String toString()
    {
        String rVal = "";
        for( Task t : tasks)
        {
            rVal += t;
            rVal += "\n";
        }
        return rVal;
    }


    /**
     * addTask
     * adds a task to the todo list
     * parameter is a task object
     * @param newTask
     */
    public void addTask(Task newTask) 
    {
        tasks.add(newTask);
    }


}

