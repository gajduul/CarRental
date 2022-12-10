public class Main {
    public static void main(String[] args)
    {
        Client client1 = new Client();

        client1.listClient("Andrzej", "Bach", "Gdansk", 1, 123456789);

        System.out.println(client1.toString());
    }
}