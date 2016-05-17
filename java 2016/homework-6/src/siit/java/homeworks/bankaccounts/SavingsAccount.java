package siit.java.homeworks.bankaccounts;

import java.util.Calendar;
import java.util.Date;

public class SavingsAccount extends BankAccount{

	private float withdrawalCommision;
    private float interestYear;
	public SavingsAccount(Date accountCreationDate, float monthlyFee,float withdrawalCommision, float interestYear) {
		super(accountCreationDate, monthlyFee);
		this.withdrawalCommision = withdrawalCommision;
		this.interestYear = interestYear;
	}

	@Override
	public void withdrawFunds(float amount) throws InsufficientFundsException {
		super.withdrawFunds(amount + amount * withdrawalCommision);
	}
	
	public float getBalance(Date balanceDate) {
		
		float balance = super.getBalance(balanceDate);
		return balance + getBalanceWithYearInterestApplied( balanceDate);
	
    }

	private float getBalanceWithYearInterestApplied(Date balanceDate) {
	
		Calendar accountCreationTime = Calendar.getInstance();
		accountCreationTime.setTime(accountCreationDate);
		// JANUARY is 0
		int accountCreationYear = accountCreationTime.get(Calendar.YEAR);
		Calendar balanceTime = Calendar.getInstance();
		balanceTime.setTime(balanceDate);
		int currentYear = balanceTime.get(Calendar.YEAR);
		return balance * interestYear * (currentYear - accountCreationYear);
	}
}  


	