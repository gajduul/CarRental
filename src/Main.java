import java.time.Year;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choose = 0;
        Scanner scanner = new Scanner(System.in);
        Scanner info = new Scanner(System.in);
        RentalCompany rentalCompany = new RentalCompany("JanuszRent", "Grunwaldzka 286, Gdańsk", "666 768 223");

        while (choose != 10) {
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
                choose = scanner.nextInt();
            else {
                System.out.println("Wpisano nieprawidłowy ciąg znaków!");
                break;
            }

            switch (choose) {
                case 1:
                    Customer customerToRent;
                    Car carToRent;
                    String idCustomerRental;
                    String idCarRental;

                    System.out.println("Witaj w panelu wypożyczania samochodu!");

                    if (rentalCompany.isCustomerExist()) { //Sprawdzenie czy są jacyś użytkownicy w bazie. Jeśli Tak to przechodzi to operacji wyboru użytkownika
                        System.out.println("Kto wypożycza samochód? (wskaż ID klienta)");
                        rentalCompany.getCustomers(); // Wyświetlenie użytkowników
                        System.out.print("ID: ");
                        idCustomerRental = scanner.next();
                        customerToRent = rentalCompany.findCustomerToOperation(idCustomerRental); //Wywołanie metody wyszukującej użytkownika o danym ID i przypisanie go do zmiennej customerToRent
                        if (customerToRent == null) { //Sprawdzenie czy użytkownik o danym ID został znaleziony. Jeśli nie to zwraca true i wywala wyjątek
                            System.out.println("Nie ma Klienta z takim ID! Spróbuj ponownie wpisując poprawne ID");
                            break;
                        }
                    } else {
                        System.out.println("Brak klientów w bazie!"); //Wyjątek wyrzucany w przypadku kiedy metoda isCustomerExist zwróci false - wyrzucane jest powiadomienie
                        break; //zerwanie pętli
                    }

                    if (rentalCompany.isCarExist()) {//Sprawdzenie czy są jakieś auta w bazie. Jeśli Tak to przechodzi to operacji wyboru auta
                        System.out.println("Jakie auto chcesz wypożyczyć? (wskaż ID samochodu)");
                        rentalCompany.getCars();// Wyświetlenie aut
                        System.out.print("ID: ");
                        idCarRental = scanner.next();
                        carToRent = rentalCompany.findCarToOperation(idCarRental);//Wywołanie metody wyszukującej auta o danym ID i przypisanie go do zmiennej carToRent
                        if (carToRent == null) {//Sprawdzenie czy auto o danym ID zostałp znalezione. Jeśli nie to zwraca true i wywala wyjątek
                            System.out.println("Nie ma auta z takim ID! Spróbuj ponownie wpisując poprawne ID");
                            break;
                        }
                    } else {
                        System.out.println("Brak samochodów w bazie!");//Wyjątek wyrzucany w przypadku kiedy metoda isCarExist zwróci false - wyrzucane jest powiadomienie
                        break; //zerwanie pętli
                    }

                    rentalCompany.rentCar(customerToRent, carToRent); //Wywołanie metody rentCar mającej na celu wypożyczenie samochodu
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
                    System.out.println("Pamiętaj aby przed korzystaniem z programu zapoznać się z regulamin naszej wypożyczalni!");
                    if (rentalCompany.isCustomerExist()) { //Sprawdzenie czy są jacyś użytkownicy w bazie. Jeśli Tak to przechodzi to operacji wyboru użytkownika
                        System.out.println("Kto zwraca samochód? (wskaż ID klienta)");
                        rentalCompany.getCustomers();// Wyświetlenie użytkowników
                        System.out.print("ID: ");
                        idCustomerReturn = scanner2.next();
                        customerToReturn = rentalCompany.findCustomerToOperation(idCustomerReturn); //Wywołanie metody wyszukującej użytkownika o danym ID i przypisanie go do zmiennej customerToReturn
                            if (customerToReturn == null) {
                                System.out.println("Nie ma klienta z takim ID! Spróbuj ponownie wpisując poprawne ID");//Sprawdzenie czy użytkownik o danym ID został znaleziony. Jeśli nie to zwraca true i wywala wyjątek
                                break;
                            }
                        } else {
                            System.out.println("Brak klientów w bazie!"); //Wyjątek wyrzucany w przypadku kiedy metoda isCustomerExist zwróci false - wyrzucane jest powiadomienie
                            break;
                        }
                        if (rentalCompany.isCarExist()) { //To samo działanie jak wcześniejsza pętla
                            System.out.println("Jakie auto chcesz zwrócić? (wskaż ID samochodu)");
                            rentalCompany.getCars();
                            System.out.print("ID: ");
                            idCarReturn = scanner2.next();
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
                                break;
                            } else {
                                System.out.println("Wprowadzono niewłaściwy ciąg znaków");
                                break;
                            }
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
                                if(!idCustomerToInfo.matches("[0-9]+")) {
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
                                System.out.println("Brak klientów w bazie!"); //Wyjątek wyrzucany w przypadku kiedy metoda isCustomerExist zwróci false - wyrzucane jest powiadomienie
                                break;
                            }

                        case 4:
                            System.out.println("Lista samochodów:");
                            rentalCompany.getCars(); //Zwrócenie listy aut
                            break;
                        case 5:
                            try {
                                System.out.println("Tutaj dodasz samochód! Najpierw potrzebujemy o nim informacje"); //Metoda zczytuje od użytkownika dane auta
                                System.out.println("Pamiętaj że w naszej wypożyczalni auto nie może być wyprodukowane przed 2000 rokiem!");
                                System.out.print("Marka: ");
                                String mark = info.nextLine();
                                if (!mark.matches("[a-zA-Z]+")) {
                                    System.out.println("Nieprawidłowy ciąg znaków w marce auta!");
                                    break;
                                }
                                System.out.print("Model: ");
                                String model = info.nextLine();
                                if (model.matches("[0-9!@#$%^&*()_+-=]+")) {
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
                                        Car car = new Car(mark, model, costPerDay, year); //Utworzenie obiektu na zasadzie danych wpisanych
                                        rentalCompany.addCar(car); //Dodanie auta
                                        break;
                                    }
                                }
                            } catch (NumberFormatException nfe) {
                                System.out.println("Podaj liczbę!");
                                break;
                            }

                        case 6:
                            String idCarRemove;

                            if (rentalCompany.isCarExist()) { //To samo co case 1 i case 2
                                System.out.println("Tutaj usuniesz samochód");
                                System.out.println("Jakie auto chcesz usunąć? (wskaż ID samochodu)");
                                rentalCompany.getCars();
                                System.out.print("ID: ");
                                idCarRemove = scanner.next();
                                if(!idCarRemove.matches("[0-9]+")) {
                                    System.out.println("Nieprawidłowy ciąg znaków w ID");
                                    break;
                                }

                                Car carToRemove = rentalCompany.findCarToOperation(idCarRemove);
                                if (carToRemove != null)
                                    rentalCompany.removeCar(carToRemove);
                                else
                                    System.out.println("Nie ma auta z takim ID! Spróbuj ponownie wpisując prawidłowe ID");
                                break;
                            } else {
                                System.out.println("Brak samochodów w bazie!");
                                break;
                            }

                        case 7:
                            System.out.println("Lista klientów:"); //Wyświetlenie listy użytkowników
                            rentalCompany.getCustomers();
                            break;

                        case 8:
                            System.out.println("Tutaj dodasz klienta! Najpierw potrzebujemy o nim informacje"); //Metoda zczytuje dane od użytkownika i tworzy obiekt
                            System.out.print("Imie: ");
                            String name = info.nextLine();
                            if (!name.matches("[\\p{L}]+")) {
                                System.out.println("Nieprawidłowy ciąg znaków w imieniu klienta!");
                                break;
                            }
                            System.out.print("Nazwisko: ");
                            String surname = info.nextLine();
                            if (!surname.matches("[\\p{L}]+")) {
                                System.out.println("Nieprawidłowy ciąg znaków w nazwisku klienta!");
                                break;
                            }
                            System.out.print("Numer telefonu: ");
                            String phone = info.nextLine();
                            if (phone.matches("\"[0-9]+\"")) {
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
                            if (email.matches("[0-9!@#$%^&*()_+-=]+") ) {
                                System.out.println("Nieprawidłowy ciąg znaków w adresie e-mail");
                                break;
                            } else{
                                if (!email.contains("@")){
                                    System.out.println("Nieprawidłowy ciąg znaków w adresie e-mail");
                                    break;
                                }
                            }
                            System.out.print("Adres zamieszkania: ");
                            String address = info.nextLine();
                            if (address.matches("[0-9!@#$%^&*()_+-=]+")) {
                                System.out.println("Nieprawidłowy ciąg znaków w adresie zamieszkania");
                                break;
                            } else{
                                if (!address.matches(".*\\d.*")){
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

                            if (rentalCompany.isCustomerExist()) {//To samo co case 1 2 i 5
                                System.out.println("Tutaj usuniesz klienta!");
                                System.out.println("Kogo chcesz usunąć? (wskaż ID klienta)");
                                rentalCompany.getCustomers();
                                System.out.print("ID: ");
                                idCustomerToRemove = scanner.next();
                                if(!idCustomerToRemove.matches("[0-9]+")) {
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
                            System.out.println("Niewłaściwa opcja!"); //Wpisanie innej cyfry niż te z zakresu 1-9 powoduje ponowny powrót do menu bez żadnych akcji
                            break;
                    }
            }
        }
    }