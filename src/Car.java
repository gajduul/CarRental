public class Car {
    private int id;
    private String mark;
    private String model;
    private int year;
    private boolean available;

    public Car(int id, String mark, String model, int year) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.year = year;
        this.available = true;
    }


    public void rentCar(){
        if(available){
            available = false;
        }
        else{
            System.out.println("Auto jest obecnie niedostępne do wypożczenia!");
        }
    }

    public void returnCar() {
        if(!available){
            available = true;
        }
        else{
            System.out.println("Auto obecnie nie jest wypożyczone!");
        }
    }

    public boolean isAvailable(){
        if(available)
            return true;
        else
            return false;
    }

    public String getDetails(){
        return String.format("ID: %d, Marka: %s, Model: %s, Rok produkcji: %d", id, mark, model, year);
    }

}