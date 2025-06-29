package cap03_Set_Exercise01.Aplication;

import cap03_Set_Exercise01.Models.Entities.LogEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {

        public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o caminho do arquivo: ");
        String path = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

                // Declarando o nosso set
                Set<LogEntry> set = new HashSet<>();

                // Lendo a primeira linha do arquivo
                String line = br.readLine();
                while(line != null){

                        // Separando o texto do arquivo baseado nos espaços em branco
                        // e Adicionando ao vetor de string

                        String[] fields = line.split(" ");
                        String username = fields[0];
                        Date moment = Date.from(Instant.parse(fields[1]));

                        // Adicionando os dados dentro do set
                        // Caso tenha um dado repetido, o set irá barrar
                        set.add(new LogEntry(username,moment));

                        line = br.readLine();
                        
                }
                System.out.println("Total entries: " + set.size());
        }
        catch (IOException e){
                System.out.println("Error: " + e);
        }


        sc.close();
    }
}
