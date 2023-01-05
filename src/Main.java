import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
        int choose = 0;
        Scanner scanner = new Scanner(System.in);
        Scanner info = new Scanner(System.in);
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
                    Customer customerToRent;
                    Car carToRent;
                    String idCustomerRental;
                    String idCarRental;

                    System.out.println("Witaj w panelu wypożyczania samochodu!");

                    if(rentalCompany.isCustomerExist()){
                    System.out.println("Kto wypożycza samochód? (wskaż ID klienta)");
                    rentalCompany.getCustomers();
                    System.out.print("ID: ");
                    idCustomerRental = scanner.next();
                    customerToRent = rentalCompany.findCustomerToOperation(idCustomerRental);
                    if (customerToRent == null) {
                        System.out.println("Nie ma Klienta z takim ID! Spróbuj ponownie wpisując poprawne ID");
                        break;
                    }
                    }
                    else {
                        System.out.println("Brak klientów w bazie!");
                        break;
                    }

                    if(rentalCompany.isCarExist()) {
                        System.out.println("Jakie auto chcesz wypożyczyć? (wskaż ID samochodu)");
                        rentalCompany.getCars();
                        System.out.print("ID: ");
                        idCarRental = scanner.next();
                        carToRent = rentalCompany.findCarToOperation(idCarRental);
                        if (carToRent == null) {
                            System.out.println("Nie ma auta z takim ID! Spróbuj ponownie wpisując poprawne ID");
                            break;
                        }
                    }
                    else {
                        System.out.println("Brak samochodów w bazie!");
                        break;
                    }

                    rentalCompany.rentCar(customerToRent,carToRent);
                    break;
                case 2:
                    String idCustomerReturn;
                    Car carToReturn;
                    String idCarRenturn;
                    Customer customerToReturn;

                    System.out.println("Witaj w panelu zwracania samochodu!");

                    if(rentalCompany.isCustomerExist()){
                        System.out.println("Kto zwraca samochód? (wskaż ID klienta)");
                        rentalCompany.getCustomers();
                        System.out.print("ID: ");
                        idCustomerReturn = scanner.next();
                        customerToReturn = rentalCompany.findCustomerToOperation(idCustomerReturn);
                        if(customerToReturn == null)
                        {
                            System.out.println("Nie ma klienta z takim ID! Spróbuj ponownie wpisując poprawne ID");
                            break;
                        }
                    }
                    else{
                        System.out.println("Brak klientów w bazie!");
                        break;
                    }

                    if(rentalCompany.isCarExist()){
                        System.out.println("Jakie auto chcesz zwrócić? (wskaż ID samochodu)");
                        rentalCompany.getCars();
                        System.out.print("ID: ");
                        idCarRenturn = scanner.next();
                        carToReturn = rentalCompany.findCarToOperation(idCarRenturn);
                        if(carToReturn== null) {
                            System.out.println("Nie ma auta z takim ID! Spróbuj ponownie wpisując poprawne ID");
                            break;
                        }
                    }
                    else{
                        System.out.println("Brak samochodów w bazie!");
                        break;
                    }

                    rentalCompany.returnCar(customerToReturn,carToReturn);
                    break;

                case 3:
                    System.out.println("Lista samochodów:");
                    rentalCompany.getCars();
                    break;
                case 4:
                    System.out.println("Tutaj dodasz samochód! Najpierw potrzebujemy o nim informacje");
                    System.out.print("Marka: ");
                    String mark = info.nextLine();
                    System.out.print("Model: ");
                    String model = info.nextLine();
                    System.out.print("Rok produkcji: ");
                    int year = Integer.parseInt(info.nextLine());

                    Car car = new Car(mark,model,year);
                    rentalCompany.addCar(car);
                    break;

                case 5:
                    String idCarRemove;

                    if(rentalCompany.isCarExist()) {
                        System.out.println("Tutaj usuniesz samochód");
                        System.out.println("Jakie auto chcesz usunąć? (wskaż ID samochodu)");
                        rentalCompany.getCars();
                        System.out.print("ID: ");
                        idCarRemove = scanner.next();

                        Car carToRemove = rentalCompany.findCarToOperation(idCarRemove);
                        if (carToRemove != null)
                            rentalCompany.removeCar(carToRemove);
                        else
                            System.out.println("Nie ma auta z takim ID! Spróbuj ponownie wpisując prawidłowe ID");
                        break;
                    }
                    else {
                        System.out.println("Brak samochodów w bazie!");
                        break;
                    }

                case 6:
                    System.out.println("Lista klientów:");
                    rentalCompany.getCustomers();
                    break;

                case 7:
                    System.out.println("Tutaj dodasz klienta! Najpierw potrzebujemy o nim informacje");
                    System.out.print("Imie: ");
                    String name = info.nextLine();
                    System.out.print("Nazwisko: ");
                    String surname = info.nextLine();
                    System.out.print("Numer telefonu: ");
                    String phone = info.nextLine();
                    System.out.print("Adres e-mail: ");
                    String email = info.nextLine();
                    System.out.print("Adres zamieszkania: ");
                    String address = info.nextLine();

                    Customer customer = new Customer(name,surname,phone,email,address);
                    rentalCompany.addCustomer(customer);
                    break;

                case 8:
                    String idCustomerToRemove;
                    Customer customerToRemove;

                    if(rentalCompany.isCustomerExist()) {
                        System.out.println("Tutaj usuniesz klienta! Najpierw potrzebujemy o nim informacje!");
                        System.out.println("Kogo chcesz usunąć? (wskaż ID klienta)");
                        rentalCompany.getCustomers();
                        System.out.print("ID: ");
                        idCustomerToRemove = scanner.next();
                        customerToRemove = rentalCompany.findCustomerToOperation(idCustomerToRemove);
                        if (customerToRemove != null) {
                            rentalCompany.removeCustomer(customerToRemove);
                            break;
                        } else {
                            System.out.println("Nie ma klienta z takim ID! Spróbuj ponownie wpisując poprawne ID");
                            break;
                        }
                    }
                    else
                    {
                        System.out.println("Brak Klientów w bazie! ");
                        break;
                    }

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