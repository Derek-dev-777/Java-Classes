package cap02_Interfaces_Exercise01.Application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import cap02_Interfaces_Exercise01.Model.Entities.Contract;
import cap02_Interfaces_Exercise01.Model.Entities.Installment;
import cap02_Interfaces_Exercise01.Model.Services.ContractService;

public class Program {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre os dados do contrato");
		
		System.out.print("Numero: ");
		int numeroContrato = sc.nextInt();
		
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.nextLine(), fmt);
		
		System.out.print("Valor do Contrato: ");
		double valorContrato = sc.nextDouble();
		
		Contract contract = new Contract(numeroContrato, date, valorContrato);
		
		System.out.print("Entre com o numero de parcelas: ");
		int numeroParcelas = sc.nextInt();
		
		ContractService contractService = new ContractService(null);
		
		contractService.processContract(contract, numeroParcelas);
		
		System.out.println("Parcelas: ");
		for( Installment installment : contract.getInstallments()) {
			System.out.println(installment);
			
		}
		
		
	}
}
