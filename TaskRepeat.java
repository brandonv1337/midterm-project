import java.time.LocalDate;

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

    public void RepeatTask(){
        //figure out how to return the same task with the new due date
    }
    
}
