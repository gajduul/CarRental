public class Vehicle {

    String registrationNumber;
    String vin;
    String make;
    String model;
    int yearOfProduction;
    boolean availability;

    //konstruktor samochod
    public void addCar(String registrationNumber, String vin,String make, String model, int yearOfProduction, boolean availability){
        this.registrationNumber = registrationNumber;
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.availability = availability;
    }

    public String showCar(){
        return registrationNumber +" "+ vin  +" "+ make  +" "+ model  +" "+ yearOfProduction;
    }

    public Boolean isAvailable(){
        return availability;
    }


    //DO OGARNIECIA
    /*public String showAvailable(){

    }

    public String showAll(){

    }

    public String showNotAvailable(){

    }*/



}
