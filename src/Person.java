public class Person{
    String name;
    String surname;
    String dateOfBirth;
    public Person(String name, String surname, String dateOfBirth){
        this.name=name;
        this.surname=surname;
        this.dateOfBirth=dateOfBirth;
    }
    public void getInfo(){
        System.out.print("Imie: "+ name + "\n") ;
        System.out.print("Nazwisko: "+ surname + "\n") ;
        System.out.print("Data urodzenia: " + dateOfBirth + "\n") ;
    }
}
