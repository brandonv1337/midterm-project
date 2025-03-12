import java.time.LocalDate;
import java.util.Scanner;

public class TaskRepeat {
    private boolean repeatable;
    Scanner keyboard = new Scanner(System.in);
    public TaskRepeat(){
        System.out.println("Is this task repeatable?(Y/N)");
        String R = keyboard.nextLine();
        if (R.equals("Y")){
            repeatable = True;
            }
        else if(R.equals("N")){
            repeatable = False;
        }


    }
    
}
