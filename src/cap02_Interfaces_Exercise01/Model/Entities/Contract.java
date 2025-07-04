package cap02_Interfaces_Exercise01.Model.Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
	
	// Atributos
	private Integer number;
	private LocalDate date;
	private Double totalValue;
	
	// Composições
	private List<Installment> installments = new ArrayList<>();
	
	

	// Construtores
	public Contract() {
		
	}
	
	public Contract(Integer number, LocalDate date, Double totalValue) {
		super();
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}
	
	// Getters and setters
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	
	public List<Installment> getInstallments() {
		return installments;
	}
	
	
}
