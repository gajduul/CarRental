public class Vehicle {

    String registrationNumber;
    String vin;
    String make;
    String model;
    int yearOfProduction;
    boolean availability;

    //konstruktor samochod
    public void addVehicle(String registrationNumber, String vin,String mark, String model, int yearOfProduction, boolean availability){
        this.registrationNumber = registrationNumber;
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.availability = availability;
    }

    public String showVehicle(){
        return registrationNumber +" "+ vin  +" "+ make  +" "+ model  +" "+ yearOfProduction;
    }

    public Boolean isAvailable(){
        return availability;
    }


    //DO OGARNIECIA
    /*
    public void removeVehicle() {

    }

    public void editVehicle(){

    }

    public void searchVehicle{

    }
    */
}
