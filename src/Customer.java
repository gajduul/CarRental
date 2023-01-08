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
        id = String.valueOf(count);
        count++;
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
        if (rentedCar == null) {
            rentedCar = car;
            car.rentCar();
        } else {
            System.out.println("Użytkownik obecnie posiada wypożyczone auto!");
        }
    }

    public void returnCar(Car car) { //Metoda odpowiedzialna za zwrócenie samochodu
        {
            if (rentedCar != null && rentedCar == car) {
                rentedCar = null;
                car.returnCar();
            } else {
                System.out.println("Użytkownik nie ma obecnie wypożyczonego auta!");
            }
        }
    }

    public boolean hasRentedCars(Car car) {
        return rentedCar == car;
    } //Metoda pomocnicza zwracająca wartość true/false. Porównuje czy auto wypożyczone przez użytkownika to to samo auto co to do oddania

    public boolean rentedAnyCar() { // Metoda pomocnicza - zwraca wartość true/false. Odpowiada na pytanie czy użytkownik ma wypożyczone jakiekolwiek auto
        return rentedCar != null;
    }

    public Car getRentedCar() {
        return rentedCar;
    }

    public String getId() {//Metoda pomocnicza, która zwraca ID danego użytkownika. Używana w metodzie findCustomerToOperation w klasie RentalCompany
        return id;
    }
}