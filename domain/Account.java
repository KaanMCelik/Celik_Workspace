package com.acn.bank.domain;

public abstract class Account
{
	
	private final String accountNumber; // private String für den Konstruktor der nicht veränderbar ist
	protected long balance; // Geldeinheit vom Konto
	
	public Account(String accountNumber, long balance)
	{
		this.accountNumber = accountNumber;
		this.balance = balance;
		boolean isNumber = testString(accountNumber); // testString --> nur Zahlen, unten Methode
		
		
		if ((accountNumber == null) || (accountNumber.length() < 9) ||  !isNumber )
		{
			throw new IllegalArgumentException(accountNumber + " is not valid");
		} // Wenn der Konstruktor keine Accountnummer hat und die länge über 10 ist 
		
		
	}
	
	public String getAccountNumber()
	{
		return accountNumber;
	}
	
	public long getBalance()
	{
		return balance;
	}

	@Override
	public String toString()
	{
		return this.getClass().getSimpleName() + "[ " + (accountNumber != null ? "accountNumber=" + accountNumber + ", " : "") + "balance="
				+ balance + "]";
	}


	
	public abstract boolean book(int amount);
	
	
	
	 // Methode um zu checken ob jede Eingabe eine nummer ist
	public boolean testString (String text){
		  for( int i = 0, n = text.length(); i<n; i++ )
		    if( ! Character.isDigit(text.charAt( i ))){ // is digit checkt ob an der Stelle ne Zahl ist
		    	return false;
		    }
		  return true;
		}
	
	

}
