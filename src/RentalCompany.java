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

    public void addCustomer(Customer customer) { //Metoda dodania użytkownika do bazy
        if (!customers.contains(customer)) { //Sprawdzenie czy użytkownik nie istnieje w bazie
            customers.add(customer); //Dodanie auta do bazy
            System.out.println("Klient został dodany do bazy!");
        }

    }

    public void removeCustomer(Customer customer) { //Metoda usuwania użytkownika z bazy
        if (customer.rentedAnyCar()) {
            System.out.println("Nie można usunąć użytkownika, który posiada wypożyczone auto!");
        } else {
            customers.remove(customer); //Usunięcie użytkownika z bazy
            System.out.println("Klient został usunięty z bazy!");
        }
    }

    public void getCustomers() { //Metoda wyświetlająca użytkowników z bazy
        List<Customer> customerList = new ArrayList<>(); //Utworzenie tymczasowej listy customerList
        for (Customer customer : customers) { //Za pomocą pętli for dodanie użytkowników z listy customers to listy customerList
            customerList.add(customer);
        }
        if (customerList.isEmpty()) { //Sprawdzenie czy lista użytkowników nie jest pusta. Jeśli tak to komunikat że nie ma nic w bazie
            System.out.println("Brak klientów w bazie! Musisz dodać klienta!");
        } else {
            for (Customer customer : customers) { //Jeśli lista nie jest pusta to wyświetlamy użytkowników
                System.out.println(customer.toString());
            }
        }
    }

    public void getCars() {//Metoda wyświetlająca auta z bazy
        List<Car> carsList = new ArrayList<>(); //Utworzenie tymczasowej listy carsList
        for (Car car : cars) {//Za pomocą pętli for dodanie użytkowników z listy cars to listy carsList
            carsList.add(car);
        }
        if (carsList.isEmpty()) {//Sprawdzenie czy lista aut nie jest pusta. Jeśli tak to komunikat że nie ma nic w bazie
            System.out.println("Brak samochodów w bazie! Musisz dodać samochód!");
        } else {
            for (Car car : cars) {//Jeśli lista nie jest pusta to wyświetlamy auta
                System.out.println(car.toString());
            }
        }
    }

    public Customer findCustomerToOperation(String id) { // Metoda która szuka użytkownika o danym ID, które zostało podane przez użytkownika
        Customer foundCustomer = null; //Utworzenie zmiennej pomocniczej
        for (Customer c : customers) { //Przeszukanie listy customers w poszukiwaniu użytkownika
            if (c.getId().equals(id)) { //Jeśli metoda getID z klasy Customer zwróci to samo ID, które podał użytkownik otrzymamy wartość true
                foundCustomer = c; //Przypisanie to naszej pomocniczej zmiennej obiektu, który zwrócił to samo ID co szukane
                break; //Wychodzimy z pętli
            }
        }
        return foundCustomer; //Zwracamy obiekt o szukanym ID
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