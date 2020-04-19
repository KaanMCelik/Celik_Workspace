package com.acn.bank.persistence;

import java.util.HashMap;
import java.util.Map;

import com.acn.bank.domain.Account;

public class InMemoryAccountDaoImpl  implements AccountDao
{
	
	private Map<String, Account> accMap ;

	public InMemoryAccountDaoImpl()
	{
		this.accMap = new HashMap<String,Account>();
		
	}

	@Override
	public Account readAccount(String accountNumber)
	{
		
		if (accountNumber != null)
		{
			return accMap.get(accountNumber);
		}else {
			throw new NullPointerException("Kein Account gefunden in der Map");
		}

	}
	@Override
	public void saveAccount(Account account)
	{

		if (account != null)
		{
			accMap.put(account.getAccountNumber(), account);
		}
		else{
			throw new NullPointerException("Kein Account gefunden");
		}

	}

	public Map<String, Account> getAccMap()
	{
		return accMap;
	}

	@Override
	public String toString()
	{
		return "InMemoryAccountDaoImpl [" + (accMap != null ? "accMap=" + accMap : "") + "]";
	}
	
	

}
