import java.util.ArrayList;

/**
 * class that contains a todo list made up of task objects
 */
public class ToDoList extends ArrayList<Task>
{

    /**
     * ToDoList
     * constructor that makes an empty list
     */
    public ToDoList()
    {
        
    }

    
    
    /**
     * toString
     * to string method for the todo list
     */
    public String toString()
    {
        String rVal = "";
        for( Task t : this)
        {
            rVal += t;
            rVal += "\n";
        }
        return rVal;
    }



}
