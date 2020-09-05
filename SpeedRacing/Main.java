package SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //List<Car> cars = new ArrayList<>();
        Map<String, Car> cars = new LinkedHashMap<>();
        int number = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < number ; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String model = input[0];
            double fuel = Double.parseDouble(input[1]);
            double fuelCost1km = Double.parseDouble(input[2]);
            Car car = new Car(model, fuel, fuelCost1km);
            cars.putIfAbsent(model, new Car(model, fuel, fuelCost1km));
            cars.put(model, car);
        }

        String input = scan.nextLine();
        while (!"End".equals(input)){
            String[] token = input.split("\\s+");
            String model = token[1];
            int distanceTravlled = Integer.parseInt(token[2]);
            Drive drive = new Drive(model,distanceTravlled);
            Car car = cars.get(model);
            car = car.calculateFuel(car, drive);
            cars.put(model, car);

            input = scan.nextLine();
        }

        cars.entrySet()
                .forEach(p -> System.out.println(String.format("%s %.2f %d", p.getValue().getModel(), p.getValue().getFuel(), p.getValue().getDistanceTraveled())));
    }
}
