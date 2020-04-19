package com.acn.bank.domain;

public class CreditAccount extends Account
{
	
	private final int CREDITLINE;

	public CreditAccount(String accountNumber, long balance, int creditline)
	{
		super(accountNumber, balance);
		this.CREDITLINE = creditline;
		
	}

	@Override
	public boolean book(int amount)
	{
		if ((this.balance + CREDITLINE) + amount < 0)
			{
				return false;
			}
			this.balance += amount; 
			return true;
	}

	public int getCreditLine()
	{
		return CREDITLINE;
	}

	
//	@Override
//	public String toString()
//	{
//		return "CreditAccount [creditLine=" + CREDITLINE + "]";
//	}
	
	

}
