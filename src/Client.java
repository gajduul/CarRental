public class Client {

    String name;
    String surname;
    String address;
    int idNumber;
    int idDrivingLicense;


    public String toString() {
        return name + "\n" + surname + "\n" + address + "\n" + idNumber + "\n" + idDrivingLicense;
     }


    public void listClient(String name, String surname, String address, int idNumber, int idDrivingLicense){
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.idNumber = idNumber;
        this.idDrivingLicense = idDrivingLicense;
    }


}
