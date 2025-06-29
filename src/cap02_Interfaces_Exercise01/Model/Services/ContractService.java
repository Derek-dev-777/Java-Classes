package cap02_Interfaces_Exercise01.Model.Services;

import java.time.LocalDate;

import cap02_Interfaces_Exercise01.Model.Entities.Contract;
import cap02_Interfaces_Exercise01.Model.Entities.Installment;

public class ContractService {
	
	private cap02_Interfaces_Exercise01.Model.Services.OnlinePaymentService onlinePaymentService;
	
	// Constructor
	public ContractService(cap02_Interfaces_Exercise01.Model.Services.OnlinePaymentService onlinePaymentService) {
		
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
