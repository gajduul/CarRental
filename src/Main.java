import javax.annotation.processing.SupportedSourceVersion;
import java.io.Console;
import java.util.Collections;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
   public static void main(String[] args) {
        int choose = 0;
        int id;

        RentalCompany rentalCompany = new RentalCompany("JanuszRent", "Grunwaldzka 286, Gdańsk", "666 768 223");
        Scanner scanner = new Scanner(System.in);
        while (choose != 8) {

            System.out.println("--- Menu ---");
            System.out.println("1. Wypożyczenie samochodu");
            System.out.println("2. Zwrot samochodu");
            System.out.println("3. Lista dostępnych samochodów");
            System.out.println("4. Dodanie samochodu");
            System.out.println("5. Usunięcie samochodu");
            System.out.println("6. Wyjście");
            System.out.print("Wybierz opcję: ");
            choose = scanner.nextInt();

            switch (choose) {
                case 1:
                    System.out.println("Kto wypożycza samochód?");
                    rentalCompany.getCustomers();
                    
                case 2:
                    // Kod do wykonania dla opcji 2 (zwrot samochodu)
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
                    // Kod do wykonania dla opcji 5 (Usunięcie samochodu)
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Niewłaściwa opcja!");
                    break;
            }
        }
    }

}




