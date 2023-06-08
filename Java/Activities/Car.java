package activities;

public class Car {
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;

     Car(){
        this.tyres =4;
        this.doors =4;
    }

    public void displayCharacteristics(){
        System.out.println("The colour of car is "+color);
        System.out.println("The transmission of car is "+transmission);
        System.out.println("The make of the car is "+make);
        System.out.println("The number of tyres of car is "+tyres);
        System.out.println("The number of doors is "+doors);
    }
    public void accelerate(){
        System.out.println("Car is moving forward");
    }

    public void brake(){
        System.out.println("Car is stopped");
    }
}
