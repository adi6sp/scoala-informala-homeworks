package siit.java.homeworks.bankaccounts;

import java.util.Calendar;
import java.util.Date;

public class LoanAccount extends BankAccount {

	private float insttalmentForMonth;
	private float credit;
	public LoanAccount(Date accountCreationDate, float monthlyFee, float credit,float insttalmentForMonth ) {
		super(accountCreationDate, 0);
		this.credit = credit;
		this.insttalmentForMonth = insttalmentForMonth;
	}
	
	@Deprecated
	@Override
	public void withdrawFunds(float amount) throws InsufficientFundsException {
		throw new UnsupportedOperationException();
	}

	public float creditWithInterest(float credit){
		
		return credit + (credit / 10);
	}
	
	public float getBalance(Date balanceDate) {
		return getBalanceWithInsttalmentForMonthApplied(balanceDate);
	}
	
	private float getBalanceWithInsttalmentForMonthApplied(Date balanceDate) {
		// We assume that the account dates are always from the same year
		Calendar accountCreationTime = Calendar.getInstance();
		accountCreationTime.setTime(accountCreationDate);
		// JANUARY is 0
		int accountCreationMonth = accountCreationTime.get(Calendar.MONTH);
		Calendar balanceTime = Calendar.getInstance();
		balanceTime.setTime(balanceDate);
		int currentYear = balanceTime.get(Calendar.MONTH);
		return  creditWithInterest(credit) - ((currentYear - accountCreationMonth) * insttalmentForMonth);
	}
}
