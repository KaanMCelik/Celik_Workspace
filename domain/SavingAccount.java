package com.acn.bank.domain;

public class SavingAccount extends Account
{

	public SavingAccount(String accountNumber, long balance)
	{
		super(accountNumber, balance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean book(int amount)
	{
		if ( this.balance + amount < 0)
		{
			return false;
		}
		this.balance += amount; 
		return true;
	}
	
	

}
