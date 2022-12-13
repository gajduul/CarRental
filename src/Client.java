public class Client extends Person {

    String address;
    int idNumber;
    int idDrivingLicense;
    String contactPhoneNumber;
    String contactEmailAddress;

    //konstruktor
    public Client(String name, String surname, String dateOfBirth,String address, int idDrivingLicense, String contactPhoneNumber, String contactEmailAddress) {
        super(name, surname, dateOfBirth);
        this.address = address;
        this.idDrivingLicense = idDrivingLicense;
        this.contactPhoneNumber = contactPhoneNumber;
        this.contactEmailAddress = contactEmailAddress;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.print("Adres: "+ address + "\n") ;
        System.out.print("Prawo jazdy nr. serii: "+ idDrivingLicense + "\n") ;
        System.out.print("Telefon kontaktowy: " + contactPhoneNumber + "\n") ;
        System.out.print("e-mail: " + contactEmailAddress + "\n") ;
     }



     //DO NAPISANIA
    /*
    public void removeClient(){

    }

    public void editClient(){

    }

    public void searchClient(){

    }

     */
}
