public class Car {
    private String id;
    private static int count = 1;
    private String mark;
    private String model;
    private int year;
    private boolean available;
    private String availableYesNo;

    public Car(String mark, String model, int year) {
        id = String.valueOf(count);
        count++;
        this.mark = mark;
        this.model = model;
        this.year = year;
        this.available = true;
        this.availableYesNo = availableYN();
    }
    public String toString(){
        return "ID: "+id+" | Marka i model: "+mark+" - "+ model +" | Rok Produkcji: "+ year +" | Dostępność: "+ availableYesNo +" ";
    }


    public void rentCar(){
        if(available){
            available = false;
            System.out.println("Auto zostało wypożyczone");
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

    private String availableYN(){
        if(available){
            return availableYesNo = "tak";
        }else{
            return availableYesNo = "nie";
        }
    }

    public String getId(){
        return id;
    }
}