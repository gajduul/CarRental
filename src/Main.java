public class Main {
    public static void main(String[] args)
    {

        Client client1 = new Client("Andrzej", "Bach", "1999-12-12","Gdańsk, Papieska 2137" , 21372005 , "+48 123 123 123","example@gmail.com");
        client1.getInfo();



        Vehicle vehicle1 = new Vehicle();
        vehicle1.addVehicle("GD XXXXXX", "VF3YD3MFC12E68833", "Chevrolet", "Corvette", 1996, true);
        System.out.println(vehicle1.showVehicle());
        System.out.println(vehicle1.isAvailable());
    }
}