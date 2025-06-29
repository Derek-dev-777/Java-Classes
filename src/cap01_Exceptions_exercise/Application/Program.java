package cap01_Exceptions_exercise.Application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cap01_Exceptions_exercise.model.Entities.Products;

public class Program {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		// Criando a lista de produtos
		List<Products> lista = new ArrayList<>();
		
		// Coletando o caminho do arquivo digitado pelo usuario
		System.out.println("Enter file path: ");
		String filePathStr = sc.nextLine();
		
		// Criando o nosso arquivo através do caminho passado pelo usuario
		File sourceFile = new File(filePathStr);
		String sourceFolderStr = sourceFile.getParent(); // coletando a root do arquivo
		
		String targetFileStr = sourceFolderStr + "\\out\\sumary.csv";
		
		// Lendo o arquivo que o usuario nos informou utilizando try resource
		try(BufferedReader br = new BufferedReader(new FileReader(sourceFile))) {
			
			String itemCsv = br.readLine();
			while(itemCsv != null) {
				
				// Coletando os dados e separando eles pelas virgulas
				String[] fields = itemCsv.split(",");
				String nome = fields[0];
				Double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);
				// teste
				// E com base nesses dados, adicionamos dentro da nossa lista, o produto
				lista.add(new Products(quantity,price,nome));
					
				// Agora nós iremos adicionar usando bufferedWriter, os items no outro arquivo
				try(BufferedWriter wr = new BufferedWriter(new FileWriter(targetFileStr))) {
					
					for (Products item : lista) {
						wr.write(item.getName() + "," + String.format("%.2f", item.total()));
						wr.newLine();
					}
				} catch (IOException e) {
					System.out.println("Error writing file:" + e);
				}
				
				
				itemCsv = br.readLine();
			}
		} catch(IOException e) {
			System.out.println("Error writing file: " + e);
		}
		
		
		
		
		sc.close();
	}
}
