public class Car {
    private String id;
    private static int count = 1;
    private String mark;
    private String model;
    private int costPerDay;
    private int year;

    private boolean available;

    public Car(String mark, String model, int costPerDay, int year) {//Konstruktor obiektu Car
        id = String.valueOf(count);// Przypisanie użytkownikowi ID do tworzonego samochodu
        count++;// Dodanie do licznika 1, aby każdy samochód miał unikatowe ID
        this.mark = mark;
        this.model = model;
        this.year = year;
        this.costPerDay = costPerDay;
        this.available = true;
    }

    public String toString() {
        return "ID: " + id + " | Samochód: " + mark + " " + model + " | Rok Produkcji: " + year + " | Koszt wypożycznia na dzień: " + costPerDay + "PLN | " + " | Czy dostępny?: " + availableYN(available) + " ";//Metoda określająca wyświetlanie obiektu
    }


    public void rentCar() { //Metoda do wypożyczenia samochodu
        if (available) { //Jeśli zmienna available == true to przepuszcza nas do wypożyczenia samochodu
            available = false; //Zmiana wartości zmiennej na false - auto jest od teraz zablokowane do wypożyczenia
            System.out.println("Auto zostało wypożyczone");
        } else {
            System.out.println("Auto jest obecnie niedostępne do wypożczenia!"); //Obsługa wyjątku, gdzie auto jest już wypożyczone
        }
    }

    public void returnCar() { //Metoda do zwrócenia samochodu
        if (!available) { //Jeśli zmienna available != true puszcza dalej
            available = true; //Zmiana wartości zmiennej na true - od teraz auto jest dostępne do wypożyczenia
        } else {
            System.out.println("Auto obecnie nie jest wypożyczone!"); //Obsługa wyjątku, gdzie auto nie jest wypożyczone
        }
    }

    public boolean isAvailable() { //Metoda pomocnicza. Zwraca true/false w zależności czy auto jest dostępne do wypożyczenia
        if (available)
            return true;

        else
            return false;
    }

    private String availableYN(boolean available) { //Metoda pomocnicza. Przy wyświetlaniu zmienia wartości true/false na tak/nie
        if (available)
            return "Tak";
        return "Nie";
    }

    public String getId() {//Metoda pomocnicza, która zwraca ID danego auta. Używana w metodzie findCarToOperation w klasie RentalCompany
        return id;
    }

    public int costOfRent(int days) {
        if (days == 0) {
            return 0;
        } else {
            int cost = days * costPerDay;
            return cost;
        }

    }
}