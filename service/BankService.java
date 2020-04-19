package com.acn.bank.service;

import com.acn.bank.domain.Account;
import com.acn.bank.persistence.AccountDao;

public class BankService
{
	AccountDao accountDao;
	
	public BankService()
	{
		
	}
	
	public BankService(AccountDao accountDao)
	{
		this.accountDao = accountDao;
		
	}
	
	protected void transfer(Account account1, Account account2, int amount) throws BookingFaildException{
		
		if (amount <= 0)
		{
			throw new IllegalArgumentException();
		}
		if (account1 == null)
		{
			throw new IllegalArgumentException();
		}
		if (account2 == null)
		{
			throw new IllegalArgumentException();
		}
		
		if (account1.getBalance() < amount)
		{
			throw new BookingFaildException("Account: " + account1 + " hat zu wenig geld auf dem Konto");
		}else {
			account1.book((-1)*amount);
			if (!account2.book(amount))
			{
				account1.book(amount);
				throw new BookingFaildException("Es gab Fehler bei der Buchung auf Konto 2, daher wird die Buchung zurück genommen");
			}
		
			
		}
	}
		public void transfer(String accNumber1, String accNumber2, int amount) throws BookingFaildException{
			
			
			if (amount <= 0)
			{
				throw new IllegalArgumentException();
			}
			if (accNumber1 == null)
			{
				throw new IllegalArgumentException();
			}
			if (accNumber2 == null)
			{
				throw new IllegalArgumentException();
			}
			
			Account account1 = accountDao.readAccount(accNumber1);
			Account account2 = accountDao.readAccount(accNumber2);

			if (account1.getBalance() < amount)
			{
				throw new BookingFaildException("Account: " + account1 + " hat zu wenig geld auf dem Konto");
			}else {
				account1.book((-1)*amount);
			
				if (!account2.book(amount))
				{
					account1.book(amount);
					throw new BookingFaildException("Es gab Fehler bei der Buchung auf Konto 2, daher wird die Buchung zurück genommen");
				}
			
				
			}
			persistAccount(account1);
			persistAccount(account2);
			

		}
		
		public void persistAccount(Account account) {
			this.accountDao.saveAccount(account);
		}
		
}
