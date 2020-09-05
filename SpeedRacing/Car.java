package SpeedRacing;

public class Car {
    private String model;
    private double fuel;
    private double fuelCost1km;
    private int distanceTraveled;
    private Drive drive;

    public Car(String model, double fuel, double fuelCost1km) {
        this.model = model;
        this.fuel = fuel;
        this.fuelCost1km = fuelCost1km;
        this.distanceTraveled = 0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getFuelCost1km() {
        return fuelCost1km;
    }

    public void setFuelCost1km(double fuelCost1km) {
        this.fuelCost1km = fuelCost1km;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public Car calculateFuel(Car car, Drive drive){
        double totalKm = car.getFuel() / car.fuelCost1km;
                //this.fuel / this.fuelCost1km;

        if (totalKm >= drive.getDistance()){
            int temp = car.getDistanceTraveled();
            temp += drive.getDistance();
            car.setDistanceTraveled(temp);
            double fuelTemp = car.getFuel() -  drive.getDistance()* 1.0 * car.getFuelCost1km();
            car.setFuel(fuelTemp);
        }else{
            System.out.println("Insufficient fuel for the drive");
        }
        return car;
    }
}
