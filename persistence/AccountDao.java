package com.acn.bank.persistence;

import com.acn.bank.domain.Account;

public interface AccountDao 
{
	
	public Account readAccount(String acc); // Interface einfach von UML übernommen
	public void saveAccount(Account account);

}
