package CarSalesmn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();
        List<Engine> engines = new ArrayList<>();
        int number = Integer.parseInt(scan.nextLine());
        for (int i = 0; i <number ; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String modelEng = input[0];
            String power = input[1];
            if (input.length == 4){
                String displacement = input[2];
                String efficiency = input[3];
                Engine engine = new Engine(modelEng, power, displacement, efficiency);
                engines.add(engine);
            }else if (input.length == 3){
                if (input[2].charAt(0) >= 48 && input[2].charAt(0) <= 57){
                    String displacement = input[2];
                    Engine engine = new Engine(modelEng, power, displacement);
                    engines.add(engine);
                } else{
                    String displacement = "n/a";
                    String efficiency = input[2];
                    Engine engine = new Engine(modelEng, power, displacement, efficiency);
                    engines.add(engine);
                }
            }else if (input.length == 2){
                Engine engine = new Engine(modelEng, power);
                engines.add(engine);
            }

        }

        number = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < number ; i++) {
            boolean checkEngine = false;
        String[] input = scan.nextLine().split("\\s+");
        String model = input[0];
        String engine = input[1];
        int index = -1;
            for (int j = 0; j < engines.size() ; j++) {
                if (engine.equals(engines.get(j).getModel())){
                    checkEngine = true;
                    index = j;
                    break;
                }
            }
            if (checkEngine){
                Engine eng = engines.get(index);
                if (input.length == 4){
                    String weight = input[2];
                    String color = input[3];
                    Car car = new Car(model, eng, weight, color);
                    cars.add(car);
                }else   if (input.length == 3){
                    if (input[2].charAt(0) >= 48 && input[2].charAt(0) <= 57){
                        String weight = input[2];
                        Car car = new Car(model, eng, weight);
                        cars.add(car);
                    } else{
                        String weight = "n/a";
                        String color = input[2];
                        Car car = new Car(model, eng, weight, color);
                        cars.add(car);
                    }
                }else if (input.length == 2){
                    Car car = new Car(model, eng);
                    cars.add(car);
                }
            }

        }

        cars.stream().forEach(p -> System.out.println(p));

    }
}
