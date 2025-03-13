

public class TaskRepeat {
    private boolean repeatable;


    public TaskRepeat(boolean repeatable) {
        this.repeatable = repeatable;
    }
    

    public boolean isRepeatable() {
        return repeatable;
    }
    
        
    public void setRepeatable(boolean repeatable) {
        this.repeatable = repeatable;
    }

    public static void RepeatTask(Task k, ToDoList myList){
        String name = k.getName();
        String description = k.getdescription();
        boolean repeatable = k.getRepeatable();
        DueDate newTask =  k.getDate();
        int days = k.getDays();
        newTask.extendDate(days);
        Task myTask = new Task(name, description, newTask, repeatable, days);

        myList.add(myTask);
        
        
    }
    
}

    
