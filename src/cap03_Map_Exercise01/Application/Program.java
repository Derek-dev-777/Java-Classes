package cap03_Map_Exercise01.Application;

import cap03_Map_Exercise01.Models.Entities.Candidato;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();

        System.out.print("Enter the path name: ");
        String path = sc.nextLine();

        try ( BufferedReader br = new BufferedReader(new FileReader(path))){

            String line = br.readLine();
            while(line != null){
                String[] fields = line.split(",");
                String nome = fields[0];
                int votos = Integer.parseInt(fields[1]);


                if(map.containsKey(nome)) {
                    int totalVotos = map.get(nome) + votos;
                    map.put(nome, totalVotos);
                }
                else{
                    map.put(nome, votos);
                }

                line = br.readLine();
            }

            for (String key : map.keySet()){
                System.out.println(key + ": " + map.containsKey(key));
            }
        }
        catch(IOException e){
            System.out.println("Error: " + e);
        }
    }
}
