package com.teller.Models;

import java.util.HashSet;

import com.teller.interfaces.LoanCalculatable;
import com.teller.interfaces.LoanPayable;
import com.teller.interfaces.LoanQueryable;

public class Loan implements LoanCalculatable, LoanPayable, LoanQueryable {

	private String bankname;
	private String username;
	private Double principal;
	private Double no_of_years;
	private Double rate_of_interest;
	private Integer paymentamount;
	private Integer paymentmonth;

	public Loan(String bankname, String username, Double principal, Double no_of_years, Double rate_of_interest) {

		this.bankname = bankname;
		this.username = username;
		this.principal = principal;
		this.no_of_years = no_of_years;
		this.rate_of_interest = rate_of_interest;
	}

	/**
	 * @return the principal
	 */
	public Double getPrincipal() {
		return principal;
	}

	public Double calculateamount() {

		return this.principal + ((this.principal * this.no_of_years * this.rate_of_interest) / 100);

	}

	public Double calculateinterestpermonth() {

		return Math.ceil(calculateamount() / getNumberofMonths());

	}

	public Double getNumberofMonths() {

		return (no_of_years * 12);
	}

	public Integer getPaymentamount() {
		return paymentamount;
	}

	/**
	 * @return the paymentmonth
	 */
	public Integer getPaymentmonth() {
		return paymentmonth;
	}

	public void setPaymentamount(Integer paymentamount) {
		this.paymentamount = paymentamount;
	}

	/**
	 * @return the paymentmonth
	 */
	public void setPaymentmonth(Integer paymentmonth) {
		this.paymentmonth = paymentmonth;
	}

	public Double[] calculatebalance(Integer emi_months) {

		Double[] data = new Double[2];
		Loan loan = this;
		Double loanamt = loan.calculateamount(); // total amount
		Double intrestamt = loan.calculateinterestpermonth(); // interest
		Double totalamountpaid = intrestamt * emi_months;
		if (emi_months < loan.getPaymentmonth() || loan.getPaymentamount() == null) // No payment made
		{

			data[0] = totalamountpaid;

			data[1] = Math.ceil(loan.getNumberofMonths() - emi_months);

		} else // some payment made
		{
			Integer latestpaymentamount = loan.getPaymentamount();

			Double totalpaid = totalamountpaid + latestpaymentamount; // Total paid amount including latest payment

			Double remamounttopay = Math.ceil(loanamt - totalpaid);
			data[0] = setAmountmax(Math.ceil(totalpaid), loanamt);
			data[1] = Math.ceil(remamounttopay / intrestamt); // gives number of months
		}

		return data;

	}

	private Double setAmountmax(Double totalpaid, Double loanval) {

		return (totalpaid > loanval) ? loanval : totalpaid;

	}

}
