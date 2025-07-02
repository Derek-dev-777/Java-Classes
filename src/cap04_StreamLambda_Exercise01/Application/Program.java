package cap04_StreamLambda_Exercise01.Application;

import cap04_StreamLambda_Exercise01.Models.Entities.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the file path: ");
        String path = sc.nextLine();
        List<Product> list = new ArrayList<>();



        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while(line != null){
                String[] fields = line.split(",");
                String nome = fields[0];
                double price = Double.parseDouble(fields[1]);

                list.add(new Product(nome, price));

                line = br.readLine();

            }

            // Função que retorna a media de preços
            double avg = list.stream()
                    .map(p -> p.getPrice())
                    .reduce(0.0, (x,y) -> x + y) / list.size();

            // Função que retorna uma lista de nomes na ordem decrescente
            // e que o preço do seja menor que a media

            Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

            List<String> nomes = list.stream()
                    .filter(p -> p.getPrice() < avg)
                    .map(p -> p.getNome())
                    .sorted(comp.reversed())
                    .collect(Collectors.toList());


            System.out.println("Average price: " + String.format("%.2f",avg));

        } catch (IOException e) {
            System.out.println("Error: " + e);

        }
        sc.close();
    }
}
