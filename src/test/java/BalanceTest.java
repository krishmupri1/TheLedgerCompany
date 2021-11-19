import static org.junit.Assert.*;

import org.junit.Test;

import com.teller.Models.Loan;


public class BalanceTest {

	@Test
	public void calculatebalancetest() {
		Loan loan = new Loan("IDIDI", "Dale", 5000.0, 1.0, 6.0);
		loan.setPaymentamount(1000);
		loan.setPaymentmonth(5);
	
		Double[] result = {1326.0,9.0};

		assertArrayEquals(result,loan.calculatebalance(3));
	}
	
	@Test
	public void calculatebalance2test() {
		Loan loan = new Loan("IDIDI", "Dale", 5000.0, 1.0, 6.0);
		loan.setPaymentamount(1000);
		loan.setPaymentmonth(5);
	
		Double[] result = {3652.0,4.0};

		assertArrayEquals(result,loan.calculatebalance(6));
	}

}
