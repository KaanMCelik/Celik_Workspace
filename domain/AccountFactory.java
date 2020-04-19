package com.acn.bank.domain;

public class AccountFactory
{

	public Account createAccount(String accountNumber, long balance, int creditLine, AccountType type) {
		
		if (accountNumber == null )
		{
			throw new IllegalArgumentException();
		} else if (creditLine < 0 )
		{
			throw new IllegalArgumentException();
		}
		else if (type == null)
		{
			throw new IllegalArgumentException();
		}

		if (type.equals(AccountType.CREDIT))
		{
			return new CreditAccount(accountNumber, balance, creditLine);
		}else if (type.equals(AccountType.SAVING))
		{
			return new SavingAccount(accountNumber, balance);
		}else if (type.equals(AccountType.BAD))
		{
			return new BadAccount(accountNumber, balance);
		}else {
			throw new NullPointerException("Unbekannten Typen angegeben");
		}
		
	}

}
