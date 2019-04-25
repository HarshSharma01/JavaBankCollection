package com.io.ba.model;

public class TransactionDetails {
	private int transactionId;
	private int fromAcc;
	private int toAcc;
	private int amt;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getFromAcc() {
		return fromAcc;
	}
	public void setFromAcc(int fromAcc) {
		this.fromAcc = fromAcc;
	}
	public int getToAcc() {
		return toAcc;
	}
	public void setToAcc(int toAcc) {
		this.toAcc = toAcc;
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
	
}
