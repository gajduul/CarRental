public class Main {
    public static void main(String[] args)
    {
        Client client1 = new Client();
        client1.addClient("Andrzej", "Bach", "Gdansk", 1, 123456789);
        System.out.println(client1.showClient());



        Vehicle vehicle1 = new Vehicle();
        vehicle1.addCar("GD XXXXXX", "VF3YD3MFC12E68833", "Chevrolet", "Corvette", 1996, true);
        System.out.println(vehicle1.showCar());
        System.out.println(vehicle1.isAvailable());
    }
}