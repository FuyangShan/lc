abstract class CarFactory{
    private String make;
    private int partNumber;
    public void process(){
        System.out.println("Build some factory somewhere");
        System.out.println("There are some number of parts");
        System.out.println("productivity is somewhat");
    }
    public void reduceParts(int n){
        partNumber -= n;
    }
    abstract public void improveProductivity(int n);
}

class TeslaFactory extends CarFactory{
    private final String make = "Tesla";
    private int partNumber = 1000;
    private String location = "Shanghai";
    private int productivityPerWeek = 700;

    public void process(){
        System.out.println("Built a factory at " + this.location);
        System.out.println("a " + this.make + " has " + this.partNumber + " parts");
        System.out.println("productivityPerYear is" + this.productivityPerWeek);
    }
    public void reduceParts(int byPartCount){
        partNumber -= n * 0.8;
    }
    public void improveProductivity(int n){
        productivityPerWeek += n;
    }
}

class Toyota extends CarFactory{
    private final String make = "Toyota";
    private int partNumber = 1500;
    private String[] location = {"San Antonio","Tokyo","Reno"};
    private int productivityPerYear = 700;

    public void process(){
        for (int i = 0; i < location.length; i ++){
            System.out.println("Built a factory at " + location[i]);
        }
        System.out.println("a " + this.make + " has " + this.partNumber + " parts");
        System.out.println("productivityPerYear is" + this.productivityPerYear);
    }
    public void reduceParts(int byPartCount){
        partNumber -= n * 1.2;
    }
    public void improveProductivity(int n){
        productivityPerYear += n;
    }
}