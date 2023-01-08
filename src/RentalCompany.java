import java.util.ArrayList;
import java.util.List;

public class RentalCompany {
    private String name;
    private String address;
    private String phone;
    private List<Car> cars;
    private List<Customer> customers;


    public RentalCompany(String name, String address, String phone) { // Konstruktor obiektu RentalCompany
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.cars = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void rentCar(Customer customer, Car car) {//Metoda do wypożyczenia samochodu. Przyjmuje 2 obiekty - klasy Customer i Car
        if (car.isAvailable()) {
            customer.rentCar(car);
        } else {
            System.out.println("Auto jest już wypożyczone");
        }
    }

    public void returnCar(Customer customer, Car car) { //Metoda do zwrotu samochodu Przyjmuje 2 obiekty - klasy Customer i Car
        if (customer.hasRentedCars(car)) {
            customer.returnCar(car);
            System.out.println("Auto zostało zwrócone!");
        } else {
            if (customer.rentedAnyCar()) {
                System.out.println("Błąd, klient aktualnie ma wypożyczony ten samochód:");
                System.out.println(customer.getRentedCar());
                System.out.println("Spróbuj ponownie!");
            } else
                System.out.println("Klient nie wypożyczył żadnego samochodu!");
        }
    }

    public void addCar(Car car) { //metoda dodania samochodu do bazy
        if (!cars.contains(car)) {
            cars.add(car);
            System.out.println("Samochód został dodany do bazy!");
        }
    }

    public void removeCar(Car car) { //Metoda usuwania samochodu z bazy
        if (car.isAvailable()) {
            cars.remove(car);
            System.out.println("Samochód został usunięty z bazy!");
        } else {
            System.out.println("Nie można usunąć auta, które jest wypożyczone!");
        }

    }

    /**
     * Metoda dodania użytkownika do bazy
     * @param customer
     */
    public void addCustomer(Customer customer) {
        if (!customers.contains(customer)) {
            customers.add(customer);
            System.out.println("Klient został dodany do bazy!");
        }

    }

    public void removeCustomer(Customer customer) { //Metoda usuwania użytkownika z bazy
        if (customer.rentedAnyCar()) {
            System.out.println("Nie można usunąć użytkownika, który posiada wypożyczone auto!");
        } else {
            customers.remove(customer);
            System.out.println("Klient został usunięty z bazy!");
        }
    }

    public void getCustomers() { //Metoda wyświetlająca użytkowników z bazy
        List<Customer> customerList = new ArrayList<>();
        for (Customer customer : customers) {
            customerList.add(customer);
        }
        if (customerList.isEmpty()) {
            System.out.println("Brak klientów w bazie! Musisz dodać klienta!");
        } else {
            for (Customer customer : customers) {
                System.out.println(customer.toString());
            }
        }
    }

    public void getCars() {//Metoda wyświetlająca auta z bazy
        List<Car> carsList = new ArrayList<>();
        for (Car car : cars) {
            carsList.add(car);
        }
        if (carsList.isEmpty()) {
            System.out.println("Brak samochodów w bazie! Musisz dodać samochód!");
        } else {
            for (Car car : cars) {
                System.out.println(car.toString());
            }
        }
    }

    public Customer findCustomerToOperation(String id) { // Metoda która szuka użytkownika o danym ID, które zostało podane przez użytkownika
        Customer foundCustomer = null;
        for (Customer c : customers) {
            if (c.getId().equals(id)) {
                foundCustomer = c;
                break;
            }
        }
        return foundCustomer;
    }

    public Car findCarToOperation(String id) { //Metoda, która szuka auta o danym ID, które zostało podane przez użytkownika. METODA BLIŹNIACZA DO findCustomerToOperation
        Car foundCar = null;
        for (Car c : cars) {
            if (c.getId().equals(id)) {
                foundCar = c;
                break;
            }
        }
        return foundCar;
    }

    public boolean isCustomerExist() { // Metoda pomocnicza - zwraca informację czy mamy jakiegokolwiek użytkownika w bazie
        if (customers.isEmpty())
            return false;
        else
            return true;
    }

    public boolean isCarExist() {// Metoda pomocnicza - zwraca informację czy mamy jakiekolwiek auto w bazie
        if (cars.isEmpty())
            return false;
        else
            return true;
    }

    public Car getRentedCar(Customer customer) {
        if (customers.contains(customer)) {
            return customer.getRentedCar();
        } else {
            System.out.println("Nie ma takiego użytkownika w bazie!");
            return null;
        }
    }
}