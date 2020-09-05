package RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int number = Integer.parseInt(scan.nextLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < number ; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String model = input[0];
            int speed = Integer.parseInt(input[1]);
            int power = Integer.parseInt(input[2]);
            int weight = Integer.parseInt(input[3]);
            String type = input[4];
            double press1 = Double.parseDouble(input[5]);
            int age1 = Integer.parseInt(input[6]);
            double press2 = Double.parseDouble(input[7]);
            int age2 = Integer.parseInt(input[8]);
            double press3 = Double.parseDouble(input[9]);
            int age3 = Integer.parseInt(input[10]);
            double press4 = Double.parseDouble(input[11]);
            int age4 = Integer.parseInt(input[12]);
            Engine engine = new Engine(speed, power);
            Cargo cargo = new Cargo(weight,type);
            Tires tires = new Tires(press1, age1, press2, age2, press3, age3, press4, age4);
            Car presentCar = new Car(model, engine, cargo, tires);
            cars.add(presentCar);
        }
        String option = scan.nextLine();
        switch (option){
            case "fragile":
                cars.stream()
                        .filter(f -> f.getCargo().getType().equals("fragile") && (f.getTires().getPress1() < 1.0 ||
                                f.getTires().getPress2() < 1.0 ) || f.getTires().getPress3() < 1.0 ||
                                f.getTires().getPress4() < 1.0)
                        .forEach(p -> System.out.println(p.getModel()));
                break;
            case "flamable":
                cars.stream()
                        .filter(f -> f.getCargo().getType().equals("flamable") && f.getEngine().getPower() > 250 )
                        .forEach(p -> System.out.println(p.getModel()));
                break;
        }
    }
}

