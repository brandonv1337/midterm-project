import java.util.ArrayList;

public class ToDoList extends ArrayList<Task>
{

    public ToDoList()
    {
        
    }

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
