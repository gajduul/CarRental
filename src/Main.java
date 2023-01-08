import java.time.Year;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        Scanner info = new Scanner(System.in);
        RentalCompany rentalCompany = new RentalCompany("JanuszRent", "Grunwaldzka 286, Gdańsk", "666 768 223");

        while (choice != 10) {
            System.out.println("--- Menu ---");
            System.out.println("1. Wypożyczenie samochodu");
            System.out.println("2. Zwrot samochodu");
            System.out.println("3. Informacja o wypożyczonym aucie przez klienta");
            System.out.println("4. Lista samochodów");
            System.out.println("5. Dodanie samochodu");
            System.out.println("6. Usunięcie samochodu");
            System.out.println("7. Lista Klientów");
            System.out.println("8. Dodanie klienta");
            System.out.println("9. Usunięcie klienta");
            System.out.println("10. Wyjście");
            System.out.print("Wybierz opcję: ");

            if (scanner.hasNextInt())
                choice = scanner.nextInt();
            else {
                System.out.println("Wpisano nieprawidłowy ciąg znaków!");
                break;
            }

            switch (choice) {
                case 1:
                    Customer customerToRent;
                    Car carToRent;
                    String idCustomerRental;
                    String idCarRental;

                    System.out.println("Witaj w panelu wypożyczania samochodu!");

                    if (rentalCompany.isCustomerExist()) {
                        System.out.println("Kto wypożycza samochód? (wskaż ID klienta)");
                        rentalCompany.getCustomers();
                        System.out.print("ID: ");
                        idCustomerRental = scanner.next();
                        if (!idCustomerRental.matches("[0-9]+")) {//Sprawdzenie czy String posiada same liczby
                            System.out.println("Nieprawidłowy ciąg znaków w ID");
                            break;
                        }
                        customerToRent = rentalCompany.findCustomerToOperation(idCustomerRental);
                        if (customerToRent == null) {
                            System.out.println("Nie ma Klienta z takim ID! Spróbuj ponownie wpisując poprawne ID");
                            break;
                        }
                    } else {
                        System.out.println("Brak klientów w bazie!");
                        break;
                    }

                    if (rentalCompany.isCarExist()) {
                        System.out.println("Jakie auto chcesz wypożyczyć? (wskaż ID samochodu)");
                        rentalCompany.getCars();
                        System.out.print("ID: ");
                        idCarRental = scanner.next();
                        if (!idCarRental.matches("[0-9]+")) {//Sprawdzenie czy String posiada same liczby
                            System.out.println("Nieprawidłowy ciąg znaków w ID");
                            break;
                        }
                        carToRent = rentalCompany.findCarToOperation(idCarRental);
                        if (carToRent == null) {
                            System.out.println("Nie ma auta z takim ID! Spróbuj ponownie wpisując poprawne ID");
                            break;
                        }
                    } else {
                        System.out.println("Brak samochodów w bazie!");
                        break;
                    }

                    rentalCompany.rentCar(customerToRent, carToRent);
                    break;

                case 2:

                    Scanner scanner2 = new Scanner(System.in);
                    String idCustomerReturn;
                    Car carToReturn;
                    String idCarReturn;
                    Customer customerToReturn;
                    int dayOfRent;
                    int cost;
                    System.out.println("Witaj w panelu zwracania samochodu!");
                    if (rentalCompany.isCustomerExist()) { //Sprawdzenie czy są jacyś użytkownicy w bazie. Jeśli Tak to przechodzi to operacji wyboru użytkownika
                        System.out.println("Kto zwraca samochód? (wskaż ID klienta)");
                        rentalCompany.getCustomers();
                        System.out.print("ID: ");
                        idCustomerReturn = scanner2.next();
                        if (!idCustomerReturn.matches("[0-9]+")) {//Sprawdzenie czy String posiada same liczby
                            System.out.println("Nieprawidłowy ciąg znaków w ID");
                            break;
                        }
                        customerToReturn = rentalCompany.findCustomerToOperation(idCustomerReturn);
                        if (customerToReturn == null) {
                            System.out.println("Nie ma klienta z takim ID! Spróbuj ponownie wpisując poprawne ID");
                            break;
                        }
                    } else {
                        System.out.println("Brak klientów w bazie!");
                        break;
                    }
                    if (rentalCompany.isCarExist()) {
                        System.out.println("Jakie auto chcesz zwrócić? (wskaż ID samochodu)");
                        rentalCompany.getCars();
                        System.out.print("ID: ");
                        idCarReturn = scanner2.next();
                        if (!idCarReturn.matches("[0-9]+")) {//Sprawdzenie czy String posiada same liczby
                            System.out.println("Nieprawidłowy ciąg znaków w ID");
                            break;
                        }
                        carToReturn = rentalCompany.findCarToOperation(idCarReturn);
                        if (carToReturn == null) {
                            System.out.println("Nie ma auta z takim ID! Spróbuj ponownie wpisując poprawne ID");
                            break;
                        }
                        System.out.print("Ile dni był wypożyczony samochód? (auta wypożyczamy na tylko pełne dni): ");
                        try {
                            dayOfRent = scanner2.nextInt();
                            cost = carToReturn.costOfRent(dayOfRent);
                            if (dayOfRent < 0) {
                                System.out.println("Ilośc dni wypożyczenia nie może być mniejsza od zera!");
                                break;
                            }
                            System.out.println("Do zapłaty: " + cost);
                        } catch (InputMismatchException ime) {
                            System.out.println("Podaj poprawną liczbę!");
                            break;
                        }

                    } else {
                        System.out.println("Brak samochodów w bazie!");
                        break;
                    }


                    System.out.print("Czy kwota została zapłacona?(TAK/NIE): ");
                    Scanner answerOfPayment = new Scanner(System.in);
                    String answer = answerOfPayment.nextLine();
                    if (answer.equalsIgnoreCase("tak")) {
                        rentalCompany.returnCar(customerToReturn, carToReturn);
                        break;
                    } else {
                        if (answer.equalsIgnoreCase("nie")) {
                            System.out.println("Klient nie może oddać auta bez zapłaty!");
                        } else {
                            System.out.println("Wprowadzono niewłaściwy ciąg znaków");
                        }
                        break;
                    }

                case 3:
                    String idCustomerToInfo;
                    Customer customerToInfo;

                    if (rentalCompany.isCustomerExist()) {
                        System.out.println("Tutaj możesz zobaczyć jakie wypożyczenia aut ma dany użytkownik!");
                        System.out.println("Którego użytkownika wypożyczenia chcesz zobaczyć? (wskaż ID klienta)");
                        rentalCompany.getCustomers();
                        System.out.print("ID: ");
                        idCustomerToInfo = scanner.next();
                        if (!idCustomerToInfo.matches("[0-9]+")) {//Sprawdzenie czy String posiada same liczby
                            System.out.println("Nieprawidłowy ciąg znaków w ID");
                            break;
                        }
                        customerToInfo = rentalCompany.findCustomerToOperation(idCustomerToInfo);

                        Car rentedCarByCustomer = rentalCompany.getRentedCar(customerToInfo);
                        if (rentedCarByCustomer == null) {
                            if (customerToInfo == null) {
                                break;
                            } else {
                                System.out.println("Użytkownik nie ma wypożyczonego żadnego auta");
                                break;
                            }
                        } else {
                            System.out.println("Auto wypożyczone przez użytkownika to:");
                            System.out.println(rentedCarByCustomer);
                            break;
                        }
                    } else {
                        System.out.println("Brak klientów w bazie!");
                        break;
                    }

                case 4:
                    System.out.println("Lista samochodów:");
                    rentalCompany.getCars(); //Zwrócenie listy aut
                    break;
                case 5:
                    try {
                        System.out.println("Tutaj dodasz samochód! Najpierw potrzebujemy o nim informacje");
                        System.out.println("Pamiętaj że w naszej wypożyczalni auto nie może być wyprodukowane przed 2000 rokiem!");
                        System.out.print("Marka: ");
                        String mark = info.nextLine();
                        if (!mark.matches("[a-zA-Z]+")) {//Sprawdzenie czy string posiada same litery
                            System.out.println("Nieprawidłowy ciąg znaków w marce auta!");
                            break;
                        }
                        System.out.print("Model: ");
                        String model = info.nextLine();
                        if (model.matches("[0-9!@#$%^&*()_+-=]+")) {//Sprawdzenie czy String address same cyfry i znaki specjalne
                            System.out.println("Nieprawidłowy ciąg znaków w modelu auta!");
                            break;
                        }
                        System.out.print("Koszt wypożycznia za dzień: ");
                        int costPerDay = Integer.parseInt(info.nextLine());
                        System.out.print("Rok produkcji: ");
                        int year = Integer.parseInt(info.nextLine());

                        if (costPerDay < 0) {
                            System.out.println("Kwota nie może być mniejsza od zera!");
                            break;
                        } else {
                            if (year < 2000) {
                                System.out.println("W wypożyczalni nie może być aut starszych niż z 2000 roku!");
                                break;
                            } else if (year > Year.now().getValue()) {
                                System.out.println("Samochód nie powinien pochodzić z przyszłości!");
                                break;
                            } else {
                                Car car = new Car(mark, model, costPerDay, year);
                                rentalCompany.addCar(car);
                                break;
                            }
                        }
                    } catch (NumberFormatException nfe) {
                        System.out.println("Podaj liczbę!");
                        break;
                    }

                case 6:
                    String idCarRemove;

                    if (rentalCompany.isCarExist()) {
                        System.out.println("Tutaj usuniesz samochód!");
                        System.out.println("Jakie auto chcesz usunąć? (wskaż ID samochodu)");
                        rentalCompany.getCars();
                        System.out.print("ID: ");
                        idCarRemove = scanner.next();
                        if (!idCarRemove.matches("[0-9]+")) {//Sprawdzenie czy String posiada same liczby
                            System.out.println("Nieprawidłowy ciąg znaków w ID");
                            break;
                        }

                        Car carToRemove = rentalCompany.findCarToOperation(idCarRemove);
                        if (carToRemove != null) {
                            rentalCompany.removeCar(carToRemove);
                            break;
                        } else {
                            System.out.println("Nie ma auta z takim ID! Spróbuj ponownie wpisując prawidłowe ID");
                            break;
                        }
                    } else {
                        System.out.println("Brak samochodów w bazie!");
                        break;
                    }

                case 7:
                    System.out.println("Lista klientów:");
                    rentalCompany.getCustomers();
                    break;

                case 8:
                    System.out.println("Tutaj dodasz klienta! Najpierw potrzebujemy o nim informacje");
                    System.out.print("Imie: ");
                    String name = info.nextLine();
                    if (!name.matches("[\\p{L}]+")) { //Sprawdzenie czy String posiada tylko litery, w tym polskie znaki
                        System.out.println("Nieprawidłowy ciąg znaków w imieniu klienta!");
                        break;
                    }
                    System.out.print("Nazwisko: ");
                    String surname = info.nextLine();
                    if (!surname.matches("[\\p{L}]+")) {//Sprawdzenie czy String posiada tylko litery, w tym polskie znaki
                        System.out.println("Nieprawidłowy ciąg znaków w nazwisku klienta!");
                        break;
                    }
                    System.out.print("Numer telefonu: ");
                    String phone = info.nextLine();
                    if (phone.matches("^[^0-9]*$")) {//Sprawdzenie czy String posiada tylko litery
                        System.out.println("Nieprawidłowy ciąg znaków numeru telefonu!");
                        break;
                    } else {
                        if (phone.length() > 12) {
                            System.out.println("Numer jest za długi!");
                            break;
                        } else if (phone.length() < 7) {
                            System.out.println("Numer jest za krótki!");
                            break;
                        }
                    }
                    System.out.print("Adres e-mail: ");
                    String email = info.nextLine();
                    if (email.matches("[0-9!@#$%^&*()_+-=]+")) {//Sprawdzenie czy String address same cyfry i znaki specjalne
                        System.out.println("Nieprawidłowy ciąg znaków w adresie e-mail");
                        break;
                    } else {
                        if (!email.contains("@")) {
                            System.out.println("Nieprawidłowy ciąg znaków w adresie e-mail");
                            break;
                        }
                    }
                    System.out.print("Adres zamieszkania: ");
                    String address = info.nextLine();
                    if (address.matches("[0-9!@#$%^&*()_+-=]+")) {//Sprawdzenie czy String address same cyfry i znaki specjalne
                        System.out.println("Nieprawidłowy ciąg znaków w adresie zamieszkania");
                        break;
                    } else {
                        if (!address.matches(".*\\d.*")) {//Sprawdzenie czy String adress zawiera same liczby
                            System.out.println("Nieprawidłowy ciąg znaków w adresie zamieszkania");
                            break;
                        }
                    }

                    Customer customer = new Customer(name, surname, phone, email, address);
                    rentalCompany.addCustomer(customer);
                    break;

                case 9:
                    String idCustomerToRemove;
                    Customer customerToRemove;

                    if (rentalCompany.isCustomerExist()) {
                        System.out.println("Tutaj usuniesz klienta!");
                        System.out.println("Kogo chcesz usunąć? (wskaż ID klienta)");
                        rentalCompany.getCustomers();
                        System.out.print("ID: ");
                        idCustomerToRemove = scanner.next();
                        if (!idCustomerToRemove.matches("[0-9]+")) {//Sprawdzenie czy String posiada same liczby
                            System.out.println("Nieprawidłowy ciąg znaków w ID");
                            break;
                        }
                        customerToRemove = rentalCompany.findCustomerToOperation(idCustomerToRemove);
                        if (customerToRemove != null) {
                            rentalCompany.removeCustomer(customerToRemove);
                            break;
                        } else {
                            System.out.println("Nie ma klienta z takim ID! Spróbuj ponownie wpisując poprawne ID");
                            break;
                        }
                    } else {
                        System.out.println("Brak Klientów w bazie! ");
                        break;
                    }

                case 10:
                    System.out.println("Żegnaj!");
                    break;
                default:
                    System.out.println("Niewłaściwa opcja!");
                    break;
            }
        }
    }
}