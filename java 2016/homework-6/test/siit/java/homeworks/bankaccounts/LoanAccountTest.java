package siit.java.homeworks.bankaccounts;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
public class LoanAccountTest {

	@Test
 
	public void insttalmentForMonthAreAplay() throws InsufficientFundsException{
		Date accountCreationDate = TestUtils.getDate(2016, 1, 1);
	    float insttalmentForMonth = 1000f;
		float credit = 10000f;
		LoanAccount loanAccount = new LoanAccount( accountCreationDate, 0, credit, insttalmentForMonth );
		Date balanceInterogationTime = TestUtils.getDate(2016, 5, 1);
		assertEquals(7000, loanAccount.getBalance(balanceInterogationTime), 0);
	}
 
	@Test
	
	public void creditWithInterestAreAplay(){
		float credit = 10000f;
		Date accountCreationDate = TestUtils.getDate(2016, 1, 1);
		LoanAccount loanAccount = new LoanAccount( accountCreationDate, 0, credit, 0 );
		assertEquals(11000, loanAccount.creditWithInterest(credit), 0);
	}
}
