import java.util.Comparator;
//

public class Schedule {
   private ToDoList masterList;
   
    public Schedule() {
        masterList = new ToDoList();
    }
    /**
     * addToDoList 
     * Adds a ToDoList into this Schedule object. 
     * @param ToDoList t
     * @return void
     */
    public void addToDoList(ToDoList t){
        for (int x = 0; x<t.size(); x++){
            masterList.add(t.get(x));
        }
    }
    /**
     * isInSchedule
     * Takes in a task to see if it is in this active schedule.
     * @param Task t
     * @return String
     */
    public String isInSchedule(Task t){
        if (masterList.contains(t)){
            return "\"" + t.getName() + "\" is on your schedule!";
        }
        else {
            return "\"" + t.getName() + "\"" + " is not on your schedule.";
        }
    }

    /**
     * toString
     * Prints out the Schedule in chronological order by due date and provides past due Tasks.
     * @return String
     */
    public String toString(){
        String returnString = "";
        int rs = 0;
        String failedReturnString = "";
        int frs = 0;

        masterList.sort(Comparator.comparing(task -> task.dueDate.getDate())); // Sorting algorithm built into ArrayLists
        for (int count = 0; count < masterList.size(); count++){
            if(!masterList.get(count).dueDate.getLate()){
                returnString += ((rs+1) + ". " + "\"" + masterList.get(count).getName() + "\"." + " " + masterList.get(count).dueDate + ".\n");
                rs++;
            }
            else{
                failedReturnString += ((frs+1) + ". " + "\"" + masterList.get(count).getName() + "\"." + " " + masterList.get(count).dueDate + ".\n");
                frs++;
            }
        }

        if (returnString.equals("")){
            return "You have no tasks added to your schedule.";
        }
        else if (failedReturnString.equals("")){
            
            return "Here are your tasks in order by due date: \n" + returnString + "\nYou have no overdue items.";
        }
        else{
            return "Here are your tasks in order by due date: \n\n" + returnString + "\nThese are the tasks that are overdue: \n" + failedReturnString;
        }
        
    }


}
