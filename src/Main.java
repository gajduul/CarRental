import java.io.Console;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---WITAJ W WYPOŻYCZALNI SAMOCHODÓW---");
        System.out.println("Do jakiego działu chcesz się przenieść?\n1. Klienci \n2. Samochody \n3. Wypożyczenia \n4. Pracownicy");
        int choose = Integer.parseInt(scanner.nextLine());
        System.out.println("Co robimy?");
        switch (choose){
            case 1:
                System.out.println("1.Dodaj klienta");
                System.out.println("2.Usuń klienta");
                System.out.println("3.Edytuj klienta");
                System.out.println("5.Informacje o kliencie");
                break;
            case 2:
                System.out.println("1.Dodaj samochód");
                System.out.println("2.Usuń samochód");
                System.out.println("3.Edytuj samochód");
                System.out.println("5.Informacje o samochodzie");
                break;
            case 3:
                System.out.println("1.Wypożycz samochód");
                System.out.println("2.Przedłuż wypożyczenie");
                System.out.println("3.Informacje o wypożyczeniu");
                break;
            case 4:
                System.out.println("1.Informacje o pracowniku");
                break;
        }






        /* STREFA TESTÓW
        Client client1 = new Client("Andrzej", "Bach", "1999-12-12","Gdańsk, Papieska 2137" , 21372005 , "+48 123 123 123","example@gmail.com");
        client1.getInfo();

        Employee employee1= new Employee("Tomasz", "Tłoczek","1979-12-11", "Service Manager ");
        employee1.getInfo();

        Vehicle vehicle1 = new Vehicle();
        vehicle1.addVehicle("GD XXXXXX", "VF3YD3MFC12E68833", "Chevrolet", "Corvette", 1996, true);
        System.out.println(vehicle1.showVehicle());
        System.out.println(vehicle1.isAvailable());*/
    }
}