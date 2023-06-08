package activities;

public class Activity1 {
    public static void main (String args[]){
        Car Toyota = new Car();
        Toyota.make =2014;
        Toyota.color="Black";
        Toyota.transmission="Manual";
        Toyota.displayCharacteristics();
        Toyota.accelerate();
        Toyota.brake();
    }
}
