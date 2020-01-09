interface Car{
    public boolean hasWheel = true;
    public void refillEnergy(int a);
}


public class LC_BMW implements Car {
    // The Make is prop. for the Class;
    private final static String make = "BMW";
    // Once constructed (manufactured), the model is finalized 
    private String color;
    private String owner;
    private int gas;
    // Once constructed (manufactured), VIN is set
    private final String vin;
    private final String model;
    // Once constructed (manufactured), mileage should be 0, and not visible unless you Get getMileage
    private double mileage = 0.00;
    private boolean isSecondHand = false;
    // When constructing a new car, model, color, and vin should be given.
    public LC_BMW(String model, String color, String vin, String owner){
        this.model = model;
        this.color = color;
        this.vin = vin;
        this.owner = owner;
    }
 
    // Get the mileage
    public String getModel(){
        return this.model;
    }
 
    // Get the mileage
    public double getMileage(){
        return this.mileage;
    }
    // Get the color
    public String getColor(){
        return this.color;
    }
    // Update the mileage
    public void setMileage(double mile){
        this.mileage = mile;
    }
    // Update the color
    public void setColor(String newColor){
        this.color = newColor;
    }
    // Get the VIN
    public String getVin(){
        return this.vin;
    }
    // Get the Make
    public String getMake(){
        return make;
    }
    // Get the current owner
    public String getOwner(){
        return this.owner;
    }
    // Change ownership to someone
    public void changeOwnershipTo(String newOwner){
        this.owner = newOwner;
        setIsSecondHand(true);
    }
    public void setIsSecondHand(boolean x){
        this.isSecondHand = x;
    }
    public boolean getIsSecondHand(){
        return this.isSecondHand;
    }
    public void refillEnergy(int gallon){
        gas += gallon;
    }
 
    public static void main(String[] args) {
        // Construct/Manufacture a new BMW car;
        LC_BMW myBMW = new LC_BMW("X5","Blue","XX234SADF41WFS","Lifu");
        // Ask what is the make of this car?
        System.out.println("the make is: " + myBMW.getMake());
        // The props of this new car
        System.out.println("the owner is: " + myBMW.getOwner());
        System.out.println("is the car second hand?" + myBMW.getIsSecondHand());
        System.out.println("the model is: " + myBMW.getModel());
        System.out.println("the color is: " + myBMW.getColor());
        System.out.println("the VIN is: " + myBMW.getVin());
        System.out.println("current mileage is: " + myBMW.getMileage());
        System.out.println("the owner is: " + myBMW.getOwner());
        System.out.println("Lifu has been driving the car for 2 years");
        myBMW.setMileage(29441.12);
        System.out.println("Now, current mileage is: " + myBMW.getMileage());
        System.out.println("Lifu sold the car to someone");
        myBMW.changeOwnershipTo("Martin");
        System.out.println("Now, the new owner is: " + myBMW.getOwner());
        System.out.println("Martin painted the car to yellow");
        myBMW.setColor("Yellow");
        System.out.println("Now, the color is" + myBMW.getColor());
        System.out.println("Now, is the car second hand?" + myBMW.getIsSecondHand());
    }
 }

class Tesla implements Car{
    private int battery = 0;
    public void refillEnergy(int mA){
        battery += mA;
    }
}