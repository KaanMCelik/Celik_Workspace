package com.acn.bank.domain;

public class BadAccount extends Account
{

	public BadAccount(String accountNumber, long balance)
	{
		super(accountNumber, balance);
		
	}

	@Override
	public boolean book(int amount)
	{
		return false;
	}

}
