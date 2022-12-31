import java.util.List;
import java.util.ArrayList;
public class Customer {
    private int id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String adress;
    private static int count;
    private Car rentedCar;
    private List<Car> rentalHistory;

    public Customer(String name,String surname,String phone,String email,String adress){
        count++;
        id = count;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.adress = adress;
    }

    public String toString(){
        return name +" "+ surname +" "+ phone +" "+ email +" "+ adress;
    }

    public void rentCar(Car car){
        if(rentedCar == null){
            rentedCar = car;
            car.rentCar();
            rentalHistory.add(car);
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
    public List<Car> RentalHistory() {
        return rentalHistory;
    }
}
