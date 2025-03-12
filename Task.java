public class Task
{
    private String name;
    private String description;
    private boolean complete;
    public DueDate dueDate; //public so that the date can be accessed from driver for specific tasks, class has own protections to keep variables safe: Added by Tim
    private int priority; //priority value will be between 0 (high) and 9 (low) or 10 (completed): Added by Tim

    public Task(String n, String d) //Constructor for tasks without a due date
    {
        name = n;
        description = d;
        complete = false;
        dueDate = new DueDate();
        calculatePriority();
    }

    public Task(String n, String d, DueDate date)  //Constructor for tasks with a due date
    {
        name = n;
        description = d;
        complete = false;
        dueDate = date;
        calculatePriority();
    }

    public String toString()
    {
        String rVal = name + "\n" + description + "\n" + dueDate + "\n" + "Priority Level: " + priority + "\n" + "Complete? " + complete;
        return rVal;
    }

    public String getName()
    {
        return name;
    }

    public void markComplete()
    {
        complete = true;
    }

    public void markIncomplete()
    {
        complete = false;
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
