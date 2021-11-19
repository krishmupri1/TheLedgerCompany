import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.net.URL;

import org.junit.Test;

import com.teller.EmiTrust;
import com.teller.Models.Loan;

public class LoanTest {



	@Test
	public void calculateamounttest() throws FileNotFoundException {

		Loan loan = new Loan("IDIDI", "Dale", 5000.0, 1.0, 6.0);
		Double amount = loan.calculateamount();
		assertEquals(Double.valueOf(5300.0), amount);

	}
	
	@Test
	public void calculateinterestpermonthtest() {
		Loan loan = new Loan("IDIDI", "Dale", 5000.0, 1.0, 6.0);
		Double amount = loan.calculateinterestpermonth();
		assertEquals(Double.valueOf(442.0), amount);
		
	}
	
	@Test
	public void getNumberofMonthstest() {
		Loan loan = new Loan("IDIDI", "Dale", 5000.0, 1.0, 6.0);
		Double months = loan.getNumberofMonths();
		assertEquals(Double.valueOf(12), months);
		
	}
	
	

}
