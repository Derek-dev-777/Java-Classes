package cap02_Interfaces_Exercise01.Model.Services;

public interface OnlinePaymentService {
	
	 Double paymentFee(double amount);
	 Double interest(double amount, int months);
}
