package com.io.ba.dao;

import java.util.ArrayList;

import com.io.ba.model.CustomerDetails;
import com.io.ba.model.TransactionDetails;
import com.io.ba.utility.InsufficientBalanceException;
import com.io.ba.utility.InvalidIdException;

public class TransactionDaoImpl implements TransactionDao {
	UserEntryDaoImpl user = new UserEntryDaoImpl();
	int transId = 1001;
	ArrayList<TransactionDetails> transactions = new ArrayList<TransactionDetails>();

	public int withdraw(int accountNo, int amount, int balance) {
		// TODO Auto-generated method stub
		int c = 0;
		if (balance >= amount) {
			balance = balance - amount;
			int i = updateBalance(balance, accountNo);
			if (i == 1) {
				c++;
			}
		}
		if (c == 1) {
			if (balance == 0)
				return 1;
			else
				return balance;
		} else
			return 0;
	}

	private int updateBalance(int balance, int accountNo) {
		// TODO Auto-generated method stub
		int i = 0;
		CustomerDetails cd = new CustomerDetails();
		for (CustomerDetails customerDetails : user.customerList) {
			if (customerDetails.getAccountNo() == accountNo) {
				customerDetails.setBalance(balance);
				i++;
				break;
			}
		}
		return i;
	}

	public int deposit(int accountNo, int amount, int balance) {
		// TODO Auto-generated method stub
		balance = balance + amount;
		int i = updateBalance(balance, accountNo);
		if (i == 1)
			return balance;
		else
			return 0;
	}

	public int showBalance(int accountNo) {
		// TODO Auto-generated method stub
		int bal = 0;
		for (CustomerDetails customerDetails : user.customerList) {
			if (customerDetails.getAccountNo() == accountNo) {
				bal = customerDetails.getBalance();
				break;
			}
		}
		return bal;
	}

	public int fundTransfer(int fromAccountNo, int toaccountNo, int amount) {
		// TODO Auto-generated method stub
		int toBalance = 0;
		int fromBalance = 0;
		int i = 0;
		int c = 0;
		for (CustomerDetails customerDetails : user.customerList) {
			if (customerDetails.getAccountNo() == toaccountNo) {
				c++;
				toBalance = customerDetails.getBalance();
			}
			if (customerDetails.getAccountNo() == fromAccountNo) {
				fromBalance = customerDetails.getBalance();
			}
		}
		if (c == 1) {
			if (fromBalance >= amount) {
				i = insertAmt(fromAccountNo, toaccountNo, amount);
				if (i == 1) {
					toBalance += amount;
					fromBalance -= amount;
					updateBalance(fromBalance, fromAccountNo);
					updateBalance(toBalance, toaccountNo);
				}
			} else {
				try {
					throw new InsufficientBalanceException();
				} catch (InsufficientBalanceException e) {
					// TODO Auto-generated catch block

				}
			}
		} else {
			try {
				throw new InvalidIdException();
			} catch (InvalidIdException e) {
				// TODO Auto-generated catch block

			}
		}

		if (fromBalance != 0)
			return fromBalance;
		else
			return 1;
	}

	private int insertAmt(int fromAccountNo, int toaccountNo, int amount) {
		// TODO Auto-generated method stub
		int i = 0;
		TransactionDetails td = new TransactionDetails();
		td.setFromAcc(fromAccountNo);
		td.setToAcc(toaccountNo);
		td.setTransactionId(transId++);
		td.setAmt(amount);
		transactions.add(td);
		i++;
		return i;
	}

}
