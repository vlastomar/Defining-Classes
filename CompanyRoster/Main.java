package CompanyRoster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = Integer.parseInt(scan.nextLine());
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < number ; i++) {
            String[] input = scan.nextLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String department = input[3];
            if (input.length == 6){
                String email = input[4];
                int age = Integer.parseInt(input[5]);
                Employee person = new Employee(name, salary, position, department, email, age);
                employees.add(person);
            }else if (input.length == 5){
                if (input[4].contains("@")){
                    String email = input[4];
                    Employee person = new Employee(name, salary, position, department, email);
                    employees.add(person);
                }else {
                    int age = Integer.parseInt(input[4]);
                    Employee person = new Employee(name, salary, position, department, age);
                    employees.add(person);
                }
            } else if (input.length == 4){
                Employee person = new Employee(name, salary, position, department);
                employees.add(person);

            }
        }
        double average = 0.00;
        String depart = "";
        for (int i = 0; i < employees.size() ; i++) {
            double sum = Double.MIN_VALUE;
            int counter = 0;

            String temp = employees.get(i).getDepartment();
            for (int j = 0; j < employees.size() ; j++) {
                if (temp.equals(depart)){
                    break;
                }
                if (employees.get(j).getDepartment().equals(temp)){
                    sum += employees.get(j).getSalary();
                    counter++;
                }
            }
            double averageTemp = sum / counter;
            if (averageTemp > average){
                average = averageTemp;
                depart = temp;
            }
        }

        String finalDepart = depart;
        System.out.println(String.format("Highest Average Salary: %s", depart));
        employees.stream()
                .filter(f -> f.getDepartment().equals(finalDepart))
                .sorted((s1, s2) -> {
                    double first = s1.getSalary();
                    double second = s2.getSalary();
                    return  Double.compare(second, first);
                })
                .forEach(p -> System.out.println(String.format("%s %.2f %s %d", p.getName(), p.getSalary(), p.getEmail(), p.getAge())));

    }

}
