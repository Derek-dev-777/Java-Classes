package cap04_StreamLambda_Exercise02.Application;

import cap04_StreamLambda_Exercise02.Model.Entities.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        List<Employee> list = new ArrayList<>();

        System.out.print("Enter the full file path: ");
        String path = sc.nextLine();
        System.out.print("Enter the salary filter: ");
        Double salaryFilter = sc.nextDouble();



        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();

            while(line != null){
                String[] fields = line.split(",");
                list.add(new Employee(fields[0], Double.parseDouble(fields[2]), fields[1]));

                line = br.readLine();

            }
        }
        catch (IOException e){
            System.out.println("Error: " + e);
        }

        // Comparando as strings, checando qual é maior
        Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

        List<String> emailOrdemAlfabetica = list.stream()
                .filter(e -> e.getSalary() > salaryFilter)
                .map(e -> e.getEmail())
                .sorted(comp)
                .collect(Collectors.toList());

        System.out.println("Email of people whose salary is more than: " + salaryFilter);

        for(String email : emailOrdemAlfabetica){
            System.out.println(email);
        }


        double salaryPeopleM = list.stream()
                .filter(e -> e.getNome().charAt(0) == 'M')
                .map(e -> e.getSalary())
                .reduce(0.0, (x,y) -> x + y);

        System.out.println("Sum of salary of people whose name starts with 'M': " + salaryPeopleM);

    }
}
