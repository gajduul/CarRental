import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
        int choose = 0;


        RentalCompany rentalCompany = new RentalCompany("JanuszRent", "Grunwaldzka 286, Gdańsk", "666 768 223");
        Scanner scanner = new Scanner(System.in);
        while (choose != 8) {
            System.out.println("--- Menu ---");
            System.out.println("1. Wypożyczenie samochodu");
            System.out.println("2. Zwrot samochodu");
            System.out.println("3. Lista samochodów");
            System.out.println("4. Dodanie samochodu");
            System.out.println("5. Usunięcie samochodu");
            System.out.println("6. Dodanie klienta");
            System.out.println("7. Usunięcie klienta");
            System.out.println("8. Wyjście");
            System.out.print("Wybierz opcję: ");
            choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    String idCustomerRental;
                    String idCarRental;
                    System.out.println("Witaj w panelu wypożyczania samochodu!");
                    System.out.println("Kto wypożycza samochód? (wskaż ID klienta)");
                    rentalCompany.getCustomers();
                    System.out.print("ID: ");
                    idCustomerRental = scanner.next();
                    Customer customerToRent = rentalCompany.findCustomerToOperation(idCustomerRental);

                    System.out.println("Jakie auto chcesz wypożyczyć? (wskaż ID samochodu)");
                    rentalCompany.getCars();
                    System.out.print("ID: ");
                    idCarRental = scanner.next();

                    Car carToRent = rentalCompany.findCarToOperation(idCarRental);
                    rentalCompany.rentCar(customerToRent,carToRent);
                    break;
                case 2:
                    String idCustomerReturn;
                    String idCarRenturn;
                    System.out.println("Witaj w panelu zwracania samochodu!");
                    System.out.println("Kto zwraca samochód? (wskaż ID klienta)");
                    rentalCompany.getCustomers();
                    System.out.print("ID: ");
                    idCustomerReturn = scanner.next();
                    Customer customerToReturn = rentalCompany.findCustomerToOperation(idCustomerReturn);

                    System.out.println("Jakie auto chcesz wypożyczyć? (wskaż ID samochodu)");
                    rentalCompany.getCars();
                    System.out.print("ID: ");
                    idCarRenturn = scanner.next();

                    Car carToReturn = rentalCompany.findCarToOperation(idCarRenturn);
                    rentalCompany.returnCar(customerToReturn,carToReturn);
                    break;
                case 3:
                    System.out.println("Lista samochodów:");
                    rentalCompany.getCars();
                    break;
                case 4:
                    System.out.println("Tutaj dodasz samochód! Najpierw potrzebujemy o nim informacje");
                    System.out.print("Marka: ");
                    String mark = scanner.next();
                    System.out.print("Model: ");
                    String model = scanner.next();
                    System.out.print("Rok produkcji ");
                    int year = Integer.parseInt(scanner.next());

                    Car car = new Car(mark,model,year);
                    rentalCompany.addCar(car);
                    break;
                case 5:
                    String idCarRemove;
                    System.out.println("Tutaj usuniesz samochód");

                    System.out.println("Jakie auto chcesz usunąć? (wskaż ID samochodu)");
                    rentalCompany.getCars();
                    System.out.print("ID: ");
                    idCarRemove = scanner.next();

                    Car carToRemove = rentalCompany.findCarToOperation(idCarRemove);
                    rentalCompany.removeCar(carToRemove);
                    break;
                case 6:
                    System.out.println("Tutaj dodasz klienta! Najpierw potrzebujemy o nim informacje");
                    System.out.print("Imie: ");
                    String name = scanner.next();
                    System.out.print("Nazwisko: ");
                    String surname = scanner.next();
                    System.out.print("Numer telefonu: ");
                    String phone = scanner.next();
                    System.out.print("Adres e-mail: ");
                    String email = scanner.next();
                    System.out.print("Adres zamieszkania: ");
                    String address = scanner.next();

                    Customer customer = new Customer(name,surname,phone,email,address);
                    rentalCompany.addCustomer(customer);
                    break;
                case 7:
                    String idCustomerToRemove;
                    System.out.println("Witaj w panelu wypożyczania samochodu!");
                    System.out.println("Kto wypożycza samochód? (wskaż ID klienta)");
                    rentalCompany.getCustomers();
                    System.out.print("ID: ");
                    idCustomerToRemove = scanner.next();
                    Customer customerToRemove = rentalCompany.findCustomerToOperation(idCustomerToRemove);
                    rentalCompany.removeCustomer(customerToRemove);
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Niewłaściwa opcja!");
                    break;
            }
        }
    }

}




