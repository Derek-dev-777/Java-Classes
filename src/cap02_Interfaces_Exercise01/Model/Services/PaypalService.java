package cap02_Interfaces_Exercise01.Model.Services;

public class PaypalService implements OnlinePaymentService{
	

	@Override
	public Double paymentFee(double amount) {
		
		return amount * 0.02;
	}

	@Override
	public Double interest(double amount, int months) {
		
		return amount * 0.01 * months;
	}
	
}
