package com.teller;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


import com.teller.Models.Loan;
import com.teller.interfaces.ConstantUtils;
import com.teller.interfaces.Initializer;


public class Processor implements Initializer {
	
	
	HashMap<String, Loan> loan_details;
	Scanner scanner;
	GeneralUtils generalutils;

	public void calculateEmi(String path) throws FileNotFoundException {

		initialize(path);
		
		while (scanner.hasNextLine()) {
			String[] genarr = generalutils.split(scanner.nextLine());
			if (genarr[0].equals(ConstantUtils.Loan)) {
				setLoan(genarr);

			} else if (genarr[0].equals(ConstantUtils.Payment)) {
				setPayment(genarr);

			} else if (genarr[0].equals(ConstantUtils.Balance)) {

				calculatebalance(genarr);

			}
		}

		scanner.close();

	}

	public void initialize(String path) throws FileNotFoundException {
		scanner = new FileUtils().getscanner(path);
		generalutils = new GeneralUtils();
		loan_details = new HashMap<String, Loan>();
		

	}

	//Read and set Loan
	private void setLoan(String loanarr[]) {

		Loan loan = new Loan(loanarr[1].toString(), loanarr[2].toString(), Double.parseDouble(loanarr[3]),
				Double.parseDouble(loanarr[4]), Double.parseDouble(loanarr[5]));

		//Key Bankname + username
		addLoan(loanarr[1].toString() + loanarr[2].toString(), loan);

	}

	//Read and set Payment
	private void setPayment(String paymentarr[]) {

		Loan loan = loan_details.get(paymentarr[1].toString() + paymentarr[2].toString());
		
		Integer paymentamount = Integer.parseInt(paymentarr[3]);
		Integer paymentmonth  = Integer.parseInt(paymentarr[4]);
	    loan.setPaymentamount(paymentamount);
	    loan.setPaymentmonth(paymentmonth);

	}
	
	//Read and calculate balance
	private void calculatebalance(String balancearr[]) {

		Double[] output;
		Loan loan = loan_details.get(balancearr[1].toString() + balancearr[2].toString());
		Integer emimonths = Integer.parseInt(balancearr[3]);
	
			output = loan.calculatebalance(emimonths);
		

		System.out
				.println(balancearr[1] + " " + balancearr[2] + " " + output[0].intValue() + " " + output[1].intValue());

	}

	private void addLoan(String user, Loan loan) {

		loan_details.put(user, loan);

	}



}
