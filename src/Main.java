import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
        int choose = 0;
        Scanner scanner = new Scanner(System.in);

        RentalCompany rentalCompany = new RentalCompany("JanuszRent", "Grunwaldzka 286, Gdańsk", "666 768 223");

        while (choose != 9) {
            System.out.println("--- Menu ---");
            System.out.println("1. Wypożyczenie samochodu");
            System.out.println("2. Zwrot samochodu");
            System.out.println("3. Lista samochodów");
            System.out.println("4. Dodanie samochodu");
            System.out.println("5. Usunięcie samochodu");
            System.out.println("6. Lista Klientów");
            System.out.println("7. Dodanie klienta");
            System.out.println("8. Usunięcie klienta");
            System.out.println("9. Wyjście");
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

                    if (customerToRent != null) {
                        if (carToRent != null) {
                            rentalCompany.rentCar(customerToRent, carToRent);
                        } else {
                            System.out.println("Nie ma auta z takim ID! Spróbuj ponownie wpisując poprawne ID");
                        }
                    }
                    else{
                        System.out.println("Nie ma klienta z takim ID! Spróbuj ponownie wpisując poprawne ID");
                    }
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

                    System.out.println("Jakie auto chcesz zwrócić? (wskaż ID samochodu)");
                    rentalCompany.getCars();
                    System.out.print("ID: ");
                    idCarRenturn = scanner.next();

                    Car carToReturn = rentalCompany.findCarToOperation(idCarRenturn);
                    if(carToReturn!= null)
                        rentalCompany.returnCar(customerToReturn,carToReturn);
                    else
                        System.out.println("Nie ma auta z takim ID! Spróbuj ponownie wpisując poprawne ID");
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
                    if(carToRemove != null)
                        rentalCompany.removeCar(carToRemove);
                    else
                        System.out.println("Nie ma auta z takim ID! Spróbuj ponownie wpisując prawidłowe ID");
                    break;
                case 6:
                    System.out.println("Lista klientów:");
                    rentalCompany.getCustomers();
                    break;
                case 7:
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

                case 8:
                    String idCustomerToRemove;
                    System.out.println("Witaj w panelu wypożyczania samochodu!");
                    System.out.println("Kto wypożycza samochód? (wskaż ID klienta)");
                    rentalCompany.getCustomers();
                    System.out.print("ID: ");
                    idCustomerToRemove = scanner.next();
                    Customer customerToRemove = rentalCompany.findCustomerToOperation(idCustomerToRemove);

                    if(customerToRemove != null)
                        rentalCompany.removeCustomer(customerToRemove);
                    else
                        System.out.println("Nie ma klienta z takim ID! Spróbuj ponownie wpisując poprawne ID");
                    break;

                case 9:
                    System.out.println("Żegnaj!");
                    break;

                default:
                    System.out.println("Niewłaściwa opcja!");
                    break;
            }
        }
    }

}




