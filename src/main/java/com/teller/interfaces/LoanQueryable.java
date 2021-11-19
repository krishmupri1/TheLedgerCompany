package com.teller.interfaces;

import com.teller.Models.Loan;

public interface LoanQueryable {

	public Double[] calculatebalance(Integer emi_months);
}
