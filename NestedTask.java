/** 
 * This class defines a subclass of task
 * Is used to define an object that can be treated as a task but will be used to contain another class as well
 * The nested class will be retreived in the driver to provide the user with the ability to make dependent tasks
 * @params always takes the params for a task
 * @param name as str
 * @param description as str 
 * @param repeat? as bool
 * @param task to be nested as Task
 * @Author Bradon T
 * 
 * 
 * 
 * 
 * 
*/



public class NestedTask extends Task{
    private Task dependant;

    /** NestedTask1
     * constructs a nested task without a due date
     */
    public NestedTask(String n, String d , boolean r ,Task dependant) {
        super(n,d,r);
        this.dependant = dependant;
    }
    /** NestedTask2
     * constructs a nested task with a due date
     * @param date due as DueDate
    */
    public NestedTask(String n, String d , DueDate date, boolean r, int da,  Task dependant) {
        super(n,d,date,r,da);
        this.dependant = dependant;
    }
    /** NestedTask3 
     * constructs a nested task with a due date
     * @param date due as DueDate
    */
    public NestedTask(String n, String d ,DueDate date, boolean r, Task dependant) {
        super(n,d,date,r);
        this.dependant = dependant;
    }
    /** setNested
     * setter for the dependant task
     * 
     * @param dependant as Task
     */
    public void setNested(Task dependant){
        this.dependant = dependant;
    }
    /** isNested
     * returns true to show that the referenced task is nested
     */
    public Boolean isNested(){
        return true;
    }
    /** 
     * Getter for the dependent task
     * 
     * @return dependent task as Task
     */

    public Task getNested(){
        return this.dependant;
    }

}





























/*      // Getter for independant
    public Task getindependant() {
        return independant;
    }
    // Setter for independant
    public void setindependant(String name) {
       this.independant = independant;
    }
    // Getter for independant
    public Task getdependant() {
    return dependant;
    }
    // Setter for independant
    public void setdependant(String name) {
        this.dependant = dependant;
    } */