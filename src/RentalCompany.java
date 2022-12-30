import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentalCompany {
    private String name;
    private String address;
    private String phone;
    private List<Car> cars;
    Scanner scanner = new Scanner(System.in);
    private List<Customer> customers;


    public RentalCompany(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.cars = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void rentCar(Customer customer, Car car) {

        if (cars.contains(car) && car.isAvailable()) {
            customer.rentCar(car);
        } else {
            System.out.println("Auto nie jest możliwe do wypożyczenia");
        }
    }

    public void returnCar(Customer customer, Car car) {
        if (customers.contains(customer) && customer.hasRentedCars(car)) {
            customer.returnCar(car);
        } else {
            System.out.println("Klient nie wypożyczył żadnego samochodu");
        }
    }

    public void addCar(Car car) {
        if (!cars.contains(car)) {
            cars.add(car);
        }
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public void addCustomer(Customer customer) {
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    public List<Car> getAvailableCars() {
        List<Car> availableCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.isAvailable()) {
                availableCars.add(car);
            }
        }
        return availableCars;
    }

    public void getCustomers(){
        List<Customer> customerList = new ArrayList<>();
        for (Customer customer : customers) {
            customerList.add(customer);
        }
        if(customerList.isEmpty()){
            System.out.println("Brak klientów w bazie! Musisz dodać klienta!");
        }
        else{
            for (Customer customer : customers) {
                System.out.println(customer.toString());
            }
        }
    }

    public void getRentalHistory(Customer customer) {
        if (customers.contains(customer)) {
            System.out.println(customer.RentalHistory());
        } else {
            System.out.println("Użytkownik nie wypożyczył jeszcze żadnego auta w wypożyczalni");
        }
    }



}

