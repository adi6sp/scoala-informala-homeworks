package siit.java.homeworks.bankaccounts;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
public class SavingAccountsTest {
	@Test
public void commissionFeeAndWithdrawalCommissionAreAplay() throws InsufficientFundsException{
	Date accountCreationDate = TestUtils.getDate(2016, 1, 1);
	float withdrawalCommision = 0.02f;
	float monthlyFee = 3f;
	float interestYear = 0.06f;
	SavingsAccount savingsAccount = new SavingsAccount(accountCreationDate, monthlyFee, withdrawalCommision, interestYear);
	savingsAccount.addFunds(1000);
	savingsAccount.withdrawFunds(400);
	Date balanceInterogationTime = TestUtils.getDate(2016, 2, 1);
	assertEquals("1 months worth of fees and the withdrawal comision have been deducted.", 589 ,savingsAccount.getBalance(balanceInterogationTime) , 0);
}
	@Test
	public void interestForYearIsApply() throws InsufficientFundsException
 {
	 Date accountCreationDate = TestUtils.getDate(2016, 1, 1);
	 float interestYear = 0.06f;
	 SavingsAccount savingsAccount = new SavingsAccount(accountCreationDate, 3f , 0.02f , interestYear);
	 savingsAccount.addFunds(1000);
     savingsAccount.withdrawFunds(400);
     Date balanceInterogationTime = TestUtils.getDate(2017, 2, 1);
     assertEquals("1 year worth of interes have been aded.", 624.34 ,savingsAccount.getBalance(balanceInterogationTime) , 1);
 }
	
	
}
