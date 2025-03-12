//CS067 Midterm
//Class Made by Tim Groth

import java.time.LocalDate; //java.time and its methods are found from https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html
import java.time.temporal.*;

public class DueDate {
    private LocalDate date;
    private int priority; //priority value will be between 0 (high) and 9 (low)
    private boolean late;
    private boolean hasDate;


    public DueDate(){   //general constructor for tasks that do not have a due date
        hasDate = false;
        priority = 9;   //Has a low priority because of the lack of due date
        late = false;   //It is not possible to be late without a due date
    }

    public DueDate(int d){  //constructor where 'd' is the days from now where it is due
        LocalDate now = LocalDate.now();
        hasDate = true;
        date = now.plusDays(d);
        late = this.getLate();
        this.calculatePriority();
    }

    public DueDate(int month, int day, int year){  //constructor where the date is given
        date = LocalDate.of(year, month, day);
        hasDate = true;
        late = this.getLate();
        this.calculatePriority();
    }

    public int daysTillDue(){
        LocalDate now = LocalDate.now();
        int daysLeft = (int)ChronoUnit.DAYS.between(now, date); //This returns the days between as a long so it is casted to an integer
        return daysLeft;
    }

    public void calculatePriority(){ 
        //Priority 0 is for tasks due today or earlier
        //Priority 1-7 is for tasks due 1-7 days from now
        //Priority 8 is for 1 to 2 weeks
        //Priority 9 is for more than 2 weeks
        if(!hasDate){
            priority = 9;
        }
        else{
            int daysLeft = this.daysTillDue();
            if(daysLeft <= 0)
                priority = 0;
            else if (daysLeft <= 7) 
                priority = daysLeft;
            else if (daysLeft <= 14)
                priority = 8;
            else 
                priority = 9;
        }
    }

    public int getPriority(){
        return priority;
    }

    public boolean getLate(){  //No setter for 'late' as it is fully determined by the due date
        if(!hasDate)
            late = false;
        else if(this.daysTillDue() < 0) //It is only late if it has a due date and negative days until it is due
            late = true;
        else
            late = false;
        return late;
    }

    public LocalDate getDate(){
        if(hasDate)
            return date;
        else
            return LocalDate.of(1,1,1); //if there is not a date, something must be returned
    }

    public void setDate(LocalDate d){
        date = d;
        if(!hasDate)
            hasDate = true;
    }

    public void extendDate(int days){
        if(hasDate)
            date = date.plusDays(days);
        this.calculatePriority();
    }

    public boolean getHasDate(){
        return hasDate;
    } 
    
    public void removeDate(){ //Does not make sense to be able to make it true without actively adding a date
       hasDate = false;
    } 



}
