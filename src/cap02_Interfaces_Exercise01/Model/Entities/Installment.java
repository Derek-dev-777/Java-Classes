package cap02_Interfaces_Exercise01.Model.Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Installment {
	
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	// Atributos
	private LocalDate dueDate;
	private Double amount;
	
	
	
	// Constructors
	
	public Installment() {
		
	}
	
	public Installment(LocalDate dueDate, Double amount) {
		
		this.dueDate = dueDate;
		this.amount = amount;
	}
	
	// Getters and setters
	public LocalDate getDueDate() {
		return dueDate;
	}


	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return dueDate.format(fmt) + " - " + String.format("%.2f" , amount);
	}
	
}
