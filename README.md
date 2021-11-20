# TheLedgerCompany
<h3>A marketplace for banks to lend money to borrowers and receive payments for the loan</h3>
<h3>A system to find out how much amount a user has paid the bank and how many EMIs are remaining.</h3>
<h2>LOAN</h2>
The LOAN command receives a Bank name, Borrower name, Principal Amount, No of Years of Loan period and the Rate of Interest along with it.
Format - LOAN BANK_NAME BORROWER_NAME PRINCIPAL NO_OF_YEARS RATE_OF_INTEREST
Example- LOAN IDIDI Dale 10000 5 4 means a loan amount of 10000 is paid to Dale by IDIDI for a tenure of 5 years at 4% rate of interest.
<h2>PAYMENT</h2>
The PAYMENT command receives a Bank name, Borrower name, Lump sum amount and EMI number along with it. The EMI number indicates that the lump sum payment is done after that EMI.
Format - PAYMENT BANK_NAME BORROWER_NAME LUMP_SUM_AMOUNT EMI_NO
Example - PAYMENT MBI Dale 1000 5 means a lump sum payment of 1000 was done by Dale to MBI after 5 EMI payments.

<h2>BALANCE</h2>
The BALANCE command receives a Bank name, Borrower name and a EMI number along with it. It prints the total amount paid by the borrower, including all the Lump Sum amounts paid including that EMI number, and the no of EMIs remaining.

Input format - BALANCE BANK_NAME BORROWER_NAME EMI_NO
Example - BALANCE MBI Harry 12 means - print the amount paid including 12th EMI, and EMIs remaining for user Harry against the lender MBI.

Output format - BANK_NAME BORROWER_NAME AMOUNT_PAID NO_OF_EMIS_LEFT
Example - MBI Harry 1250 43

<H2>ASSUMPTION</H2>
<ol>
  <li>Repayments will be paid every month as EMIs until the total amount is recovered.</li>
  <li>Lump sum amounts can be paid at any point of time before the end of tenure.</li>
  <li>The EMI amount will be always ceiled to the nearest integer. For example 86.676767 can be ceiled to 87 and 100.10 to 101.</li>
  <li>The no of EMIs should be ceiled to the nearest whole number. For example 23.79 will be ceiled to 24 and 23.1 will also be ceiled to 24.</li>
  <li>If the last EMI is more than the remaining amount to pay, then it should be adjusted to match the amount remaining to pay. E.g. if the remaining amount to pay is 150 and your EMI is 160, then the last EMI amount paid should be 150.</li>
  <li> The total amount remaining at any EMI number should always include the EMIs paid and lump sum payments until that number. For example if there was a lump sum payment after EMI number 10, then the balance command for EMI number 10 should include the lump sum payment as well.</li>
</ol>
<h2>SIMPLE INPUT OUTPUT</h2>
<h2>INPUT</h2>
LOAN IDIDI Dale 10000 5 4<BR>
LOAN MBI Harry 2000 2 2<BR>
BALANCE IDIDI Dale 5<BR>
BALANCE IDIDI Dale 40<BR>
BALANCE MBI Harry 12<BR>
BALANCE MBI Harry 0<BR>

<H2>OUTPUT</H2>
IDIDI Dale 1000 55<BR>
IDIDI Dale 8000 20<BR>
MBI Harry 1044 12<BR>
MBI Harry 0 24<BR>
