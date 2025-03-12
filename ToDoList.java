import java.util.ArrayList;

public class ToDoList 
{
    private ArrayList<Task> tasks;

    public ToDoList()
    {
        tasks = new ArrayList<Task>();
    }

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

    public void addTask(Task newTask) 
    {
        tasks.add(newTask);
    }


}
