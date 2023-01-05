
import java.util.ArrayList;
import java.util.List;

public class RentalCompany {
    private String name;
    private String address;
    private String phone;
    private List<Car> cars;
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
            System.out.println("Auto jest już wypożyczone");
        }
    }

    public void returnCar(Customer customer, Car car) {
        if (customers.contains(customer) && customer.hasRentedCars(car)) {
            customer.returnCar(car);
            System.out.println("Auto zostało zwrócone!");
        } else {
            if(customer.rentedAnyCar())
                System.out.println("Klient ma wypożyczony inny samochód!");
            else
                System.out.println("Klient nie wypożyczył żadnego samochodu!");
        }
    }

    public void addCar(Car car) {
        if (!cars.contains(car)) {
            cars.add(car);
            System.out.println("Samochód został dodany do bazy!");
        }
    }

    public void removeCar(Car car) {
        cars.remove(car);
        System.out.println("Samochód został usunięty z bazy!");
    }

    public void addCustomer(Customer customer) {
        if (!customers.contains(customer)) {
            customers.add(customer);
            System.out.println("Klient został dodany do bazy!");
        }

    }

    public void removeCustomer(Customer customer) {
        customers.remove(customer);
        System.out.println("Klient został usunięty z bazy!");
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

    public void getCars(){
        List<Car> carsList = new ArrayList<>();
        for (Car car : cars) {
            carsList.add(car);
        }
        if(carsList.isEmpty()){
            System.out.println("Brak samochodów w bazie! Musisz dodać samochód!");
        }
        else{
            for (Car car : cars) {
                    System.out.println(car.toString());
            }
        }
    }

    public Customer findCustomerToOperation(String id){
        Customer foundCustomer = null;
        for(Customer c : customers){
            if(c.getId().equals(id)){
                foundCustomer = c;
                break;
            }
        }
        return foundCustomer;
    }

    public Car findCarToOperation(String id){
        Car foundCar = null;
        for(Car c : cars){
            if(c.getId().equals(id)){
                foundCar = c;
                break;
            }
        }
        return foundCar;
    }

    public boolean isCustomerExist (){
        if(customers.isEmpty())
            return false;
        else
            return true;
    }
    public boolean isCarExist (){
        if(cars.isEmpty())
            return false;
        else
            return true;
    }

}