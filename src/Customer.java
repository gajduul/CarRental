public class Customer {
    private String id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String adress;
    private static int count = 1;
    private Car rentedCar;

    public Customer(String name, String surname, String phone, String email, String adress) { //Konstruktor obiektu Customer
        id = String.valueOf(count); // Przypisanie użytkownikowi ID z licznika
        count++; // Dodanie do licznika 1, aby każdy użytkownik miał unikatowe ID
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.adress = adress;
    }

    public String toString() {
        return "ID: " + id + " | Imie i nazwisko: " + name + " " + surname + " | Nr tel: " + phone + " | E-mail: " + email + " | Adres: " + adress; //Metoda określająca wyświetlanie obiektu
    }

    public void rentCar(Car car) { //Metoda odpowiedzialna za wypożyczenie samochodu
        if (rentedCar == null) { //Sprawdzenie czy użytkownik nie ma już wypożyczonego auta
            rentedCar = car; // Przypisanie użytkownikowi wypożyczonego przez niego auta
            car.rentCar(); // Wywołanie metody rentCar z klasy car
        } else {
            System.out.println("Użytkownik obecnie posiada wypożyczone auto!"); //Obsługa wyjątku, gdzie użytkownik ma już wypożyczone auto
        }
    }

    public void returnCar(Car car) { //Metoda odpowiedzialna za zwrócenie samochodu
        {
            if (rentedCar != null && rentedCar == car) { // Sprawdzenie czy użytkownik ma wypożyczony samochód oraz czy auto które użytkownik chce zwrócić jest wypożyczone przez niego
                rentedCar = null; //Wyzerowanie zmiennej przechowującej wypożyczone przez użytkownika auto
                car.returnCar(); // Wywołanie metody returnCar z klasy Car
            } else {
                System.out.println("Użytkownik nie ma obecnie  wypożyczonego auta!"); //Obsługa wyjątkie gdzie użytkownik ma wypożyczony inny samochód ( warunek rentedCar == car nie jest spełniony)
            }
        }
    }

    public boolean hasRentedCars(Car car) {
        return rentedCar == car;
    } //Metoda pomocnicza zwracająca wartość true/false. Porównuje czy auto wypożyczone przez użytkownika to to samo auto co to do oddania

    public boolean rentedAnyCar() { // Metoda pomocnicza - zwraca wartość true/false. Odpowiada na pytanie czy użytkownik ma wypożyczone jakiekolwiek auto
        if (rentedCar == null) //Warunek sprawdzający czy użytkownik ma wypożyczone jakieś auto
            return false; //Zwraca false jeśli NIE
        else
            return true; //Zwraca true jeśli TAK
    }

    public Car getRentedCar() {
        return rentedCar;
    }

    public String getId() {//Metoda pomocnicza, która zwraca ID danego użytkownika. Używana w metodzie findCustomerToOperation w klasie RentalCompany
        return id;
    }
}