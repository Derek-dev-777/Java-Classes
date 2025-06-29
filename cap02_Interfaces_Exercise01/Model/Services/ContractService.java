package Model.Services;

import java.time.LocalDate;

import Model.Entities.Contract;
import Model.Entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;
	
	// Constructor
	public ContractService(OnlinePaymentService onlinePaymentService) {
		
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contract, int months) {
		
		double basicQota = contract.getTotalValue() / months;
		
		for ( int i = 1; i <= months ; i++) {
			LocalDate dueDate = contract.getDate().plusMonths(i);
			
			double interest = onlinePaymentService.interest(basicQota, i);
			double fee = onlinePaymentService.paymentFee(basicQota + interest);
			
			double qota = basicQota + interest + fee;
			
			contract.getInstallments().add(new Installment (dueDate, qota));
		}
	}
	
	
}
