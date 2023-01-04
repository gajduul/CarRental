import java.util.List;
import java.util.ArrayList;
public class Customer {
    private String id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String adress;
    private static int count = 1 ;
    private Car rentedCar;


    public Customer(String name,String surname,String phone,String email,String adress){
        id = String.valueOf(count);
        count++;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.adress = adress;
    }

    public String toString(){
        return "ID: "+id +" | Imie i nazwisko: " + name +" "+surname+" | Nr tel:"+phone+" | E-mail:"+email+" | Adres:"+adress;
    }

    public void rentCar(Car car){
        if(rentedCar == null){
            rentedCar = car;
            car.rentCar();
        } else {
            System.out.println("Użytkownik obecnie posiada wypożyczone auto!");
        }
    }

    public void returnCar(Car car){
        {
            if (rentedCar != null && rentedCar == car) {
                rentedCar = null;
                car.returnCar();
            } else {
                System.out.println("Użytkownik nie ma obecnie  wypożyczonego auta!");
            }
        }
    }
    public boolean hasRentedCars(Car car){
        return rentedCar == car;
    }

    public String getId(){
        return id;
    }
}