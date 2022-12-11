public class Employee extends Person{
    String position;
    public Employee(String name, String surname, String dateOfBirth, String position){
        super(name, surname, dateOfBirth);
        this.position = position;
    }

    @Override
    public void getInfo(){
        super.getInfo();
        System.out.print("Stanowisko: "+ position + "\n") ;
    }
}
