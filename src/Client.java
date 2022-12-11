public class Client extends Person{

    String name;
    String surname;
    String address;
    int idNumber;
    int idDrivingLicense;
    String contactPhomeNumber;
    String contactEmailAddress;

    //konstruktor
    public void addClient(String name, String surname, String address, int idNumber, int idDrivingLicense, String contactPhomeNumber, String contactEmailAddress){
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.idNumber = idNumber;
        this.idDrivingLicense = idDrivingLicense;
        this.contactPhomeNumber = contactPhomeNumber;
        this.contactEmailAddress = contactEmailAddress;
    }

    public String showClient() {
        return name + "\n" + surname + "\n" + address + "\n" + idNumber + "\n" + idDrivingLicense + "\n" + contactPhomeNumber + "\n" + contactEmailAddress;
     }

    public void removeClient(){
        //Tutaj dziś pracuje wyjazd stąd XD
    }

     //DO NAPISANIA
    /*


    public void editClient(){

    }

    public void searchClient(){

    }

     */
}
