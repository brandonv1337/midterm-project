public class Task
{
    private String name;
    private String description;
    private boolean complete;
    private boolean repeatable;
    public DueDate dueDate; //public so that the date can be accessed from driver for specific tasks, class has own protections to keep variables safe: Added by Tim
    private int priority; //priority value will be between 0 (high) and 9 (low) or 10 (completed): Added by Tim
    private int days;
    private ToDoList toDoList;


    /**
     * Task
     * Creates a task for tasks that are repatable
     * @param n
     * @param d
     * @param date
     * @param r
     * @param da
     */
    public Task(String n, String d, DueDate date, boolean r, int da)  //Constructor for tasks with a due date
    {
        name = n;
        description = d;
        complete = false;
        dueDate = date;
        repeatable = r;
        days = da;
        calculatePriority();
    }
    /**
     * Task
     * Creats a task for tasks that are not repeatable 
     * @param n
     * @param d
     * @param date
     * @param r
     */
    public Task(String n, String d, DueDate date, boolean r)  //Constructor for tasks with a due date
    {
        name = n;
        description = d;
        complete = false;
        dueDate = date;
        repeatable = r;
        calculatePriority();
    }
    /**
     * String
     * creats a string that holds the priority level
     * @return String
     */ 
    public String toString()
    {
        String rVal = name + "\n" + description + "\n" + dueDate + "\n" + "Priority Level: " + priority + "\n" + "Complete? " + complete;
        return rVal;
    }
    /**
     * getDays
     * @return int
     */
    public int getDays()
    {
        return days;
    }
    /**
     * getDate
     * @return DueDate
     */
    public DueDate getDate()
    {
        return dueDate;
    }
    /**
     * getName
     * @return String
     */
    public String getName()
    {
        return name;
    }
    /**
     * getRepeatable
     * finds out if task is repeatable or not 
     * @return boolean
     */
    public boolean getRepeatable(){
        return repeatable;
    }

    /**
     * getdescription
     * @returndescription
     */
    public String getdescription()
    {
        return description;
    }
    /**
     *  markComplete
     * marks task as compleate 
     * sends task to repeat task in task repeat so that it can be repated
     */
    public void markComplete()
    {
        complete = true;
        TaskRepeat.RepeatTask(this);

    }
    /**
     * markIncomplete
     * marks task as incompleate making its compleate boolean value be false
     */
    public void markIncomplete()
    {
        complete = false;
    }  
    /**
     * isCompleate
     * tells us if task is compleate or not
     * @return boolean
     */
    public boolean isCompleate(){
        return complete;
    }
    /**
     * isNested
     * @return boolean
     */
    public Boolean isNested(){
        return false;
    }

    private void calculatePriority(){ //private because there is no point in calculating from outside of this class without getting it returned
        //Added by Tim
        //Priority 0 is for tasks due today or earlier
        //Priority 1-7 is for tasks due 1-7 days from now
        //Priority 8 is for 1 to 2 weeks
        //Priority 9 is for more than 2 weeks
        //Priority 10 is completed
        if(complete)
            priority = 10;
        else if(!dueDate.getHasDate())
            priority = 9;
        else{
            int daysLeft = dueDate.daysTillDue();
            if(daysLeft <= 0)
                priority = 0;
            else if (daysLeft <= 7) 
                priority = daysLeft;
            else if (daysLeft <= 14)
                priority = 8;
            else 
                priority = 9;
        }
        if(complete)
            priority = 10;
    }

    public int getPriority(){ //Added by Tim
        this.calculatePriority();
        return priority;
    }

}
