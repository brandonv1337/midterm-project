public class NestedTask extends Task{
    private Task dependant;

    public NestedTask(String n, String d , boolean r ,Task dependant) {
        super(n,d,r);
        this.dependant = dependant;
    }
    public NestedTask(String n, String d , DueDate date, boolean r, int da,  Task dependant) {
        super(n,d,date,r,da);
        this.dependant = dependant;
    }
    public NestedTask(String n, String d ,DueDate date, boolean r, Task dependant) {
        super(n,d,date,r);
        this.dependant = dependant;
    }

    public void setNested(Task dependant){
        this.dependant = dependant;
    }
    public Boolean isNested(){
        return true;
    }

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