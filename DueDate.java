//CS067 Midterm

import java.time.LocalDate; //java.time and its methods are found from https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html
import java.time.temporal.*;

/**
 * Class that stores the due date for an object
 * 
 * Includes the date, if the object is late, and how many days until the due date
 * 
 * @author Tim Groth
 */
public class DueDate {
    private LocalDate date;
    private boolean late;
    private boolean hasDate;

    /**
     * general constructor for tasks that do not have a due date
     */
    public DueDate(){   
        hasDate = false;
        late = false;   //It is not possible to be late without a due date
    }

    /**
     * constructor where 'd' is the days from now where it is due
     * 
     * @param d the number of days from now where the due date will be set
     */
    public DueDate(int d){  
        LocalDate now = LocalDate.now();
        hasDate = true;
        date = now.plusDays(d);
        late = this.getLate();
    }

    /**
     * constructor where the date is given
     * 
     * @param month the month of the due date
     * @param day the day of the due date
     * @param year the year of the due date
     */
    public DueDate(int month, int day, int year){ 
        date = LocalDate.of(year, month, day);
        hasDate = true;
        late = this.getLate();
    }

    /**
     * Calculates the number of days between the current date and the due date
     * 
     * @return 1000 if there is no due date, otherwise the number of days until the due date
     */
    public int daysTillDue(){
        if(hasDate){
            LocalDate now = LocalDate.now();
            int daysLeft = (int)ChronoUnit.DAYS.between(now, date); //This returns the days between as a long, so it is casted to an integer
            return daysLeft;
        }
        else
            return 1000;
    }

    /**
     * Returns if the due date is passed or not
     * 
     * @return true if the due date has passed, false if it has not or there is no due date
     */
    public boolean getLate(){  //No setter for 'late' as it is fully determined by the due date
        if(!hasDate)
            late = false;
        else if(this.daysTillDue() < 0) //It is only late if it has a due date and negative days until it is due
            late = true;
        else
            late = false;
        return late;
    }

    /**
     * Returns the due date
     * 
     * @return a LocalDate object for the due date
     */
    public LocalDate getDate(){
        if(hasDate)
            return date;
        else
            return LocalDate.of(1,1,1); //if there is not a date, something must be returned
    }

    /**
     * Sets the due date to a new date
     * 
     * @param d is the LocalDate for the new due date
     */
    public void setDate(LocalDate d){
        date = d;
        if(!hasDate)
            hasDate = true;
    }

    /**
     * Extends the due date by a number of days
     * 
     * @param days is the number of days to expend the due date by
     */
    public void extendDate(int days){
        if(hasDate)
            date = date.plusDays(days);
    }

    /**
     * Returns if there is a set due date
     * 
     * @return true if there is a due date, false if no due date
     */
    public boolean getHasDate(){
        return hasDate;
    } 
    
    /**
     * removes the due date
     */
    public void removeDate(){ //Does not make sense to be able to make hasDate true without actively adding a date
       hasDate = false;
    } 

    /**
     * toString class for the DueDate object
     */
    public String toString(){
        if(!hasDate)
            return "This task has no due date";
        else {
            int daysLeft = this.daysTillDue();
            if(daysLeft < 0)    //task was due in past
                return "This task was due " + Math.abs(daysLeft) + " days ago, on " + date; 
            else if(daysLeft == 0)  //task is due today
                return "This task is due today, on " + date;
            else    //task is due in future
                return "This task is due " + daysLeft + " days from now, on " + date;
        }
    }


}
