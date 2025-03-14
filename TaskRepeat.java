
/**
 * This class is used to figure out if the task is repeatable or not.
 * it then takes compleated tasks that are repeated and sets a new due date for them and adds them to a new list
 * that new list is then added to the calander
 * 
 * @author Franklin Wohnoutka
 */


public class TaskRepeat
 {
    private boolean repeatable;

    /**
     * TaskRepeat
     * sets task as either repeatable or not repeatable
     * @param repeatable
     */
    public TaskRepeat(boolean repeatable) {
        this.repeatable = repeatable;
    }
    
    /**
     * isRepeatable
     * returns the boolean value of repeatable
     * @return boolean
     */
    public boolean isRepeatable() {
        return repeatable;
    }
    
        
    public void setRepeatable(boolean repeatable) {
        this.repeatable = repeatable;
    }
    /**
     * RepeatTask
     * This method takes in the compleated task object as a paramater and gets all the compentnts of it calling methods from task
     * it then changes the due date of the task
     * using the new due date and the other original paramaters it creats a new task called my task and adds it to a list
     * @param k
     */
    
    public static void RepeatTask(Task k){
        String name = k.getName();
        String description = k.getdescription();
        boolean repeatable = k.getRepeatable();
        DueDate newTask =  k.getDate();
        int days = k.getDays();
        newTask.extendDate(days);
        Task myTask = new Task(name, description, newTask, repeatable, days);
        ToDoList myList2 = new ToDoList();
        myList2.add(myTask);

    }
}

    

    
