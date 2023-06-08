package activities;

public class Activity3 {
    public static void main(String args[]){
        double age = 1000000000;
        double earth=31557600;
        double mercury=0.2408467;
        double venus =0.61519726;
        double mars=1.8808158;
        double jupiter=11.862615;
        double saturn =29.447498;
        double uranus =84.016846;
        double neptune =164.79132;

        System.out.println("Age on mercury "+age/earth/mercury);
        System.out.println("Age on venus "+age/earth/venus);
        System.out.println("Age on earth "+age/earth);
        System.out.println("Age on mars "+age/earth/mars);
        System.out.println("Age on jupiter "+age/earth/jupiter);
        System.out.println("Age on saturn "+age/earth/saturn);
        System.out.println("Age on uranus "+age/earth/uranus);
        System.out.println("Age on neptune "+age/earth/neptune);



    }
}
