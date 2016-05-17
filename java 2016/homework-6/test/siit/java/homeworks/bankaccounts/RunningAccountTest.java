package siit.java.homeworks.bankaccounts;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
public class RunningAccountTest {

	@Test
	public void monthlyFeesAreApplied() {
		Date accountCreationTime = TestUtils.getDate(2016, 1, 1);
		RunningAccount runningAccount = new RunningAccount(accountCreationTime,3);
		runningAccount.addFunds(1000);
		Date balanceInterogationTime = TestUtils.getDate(2016, 2, 1); 
		assertEquals("0ne month of fee ",997, runningAccount.getBalance(balanceInterogationTime), 0);
	}

}
