package com.javatechie;

import java.math.BigDecimal;

@FunctionalInterface
interface Bank {

	public abstract BigDecimal interestRate();

	static BigDecimal withdraw(BigDecimal balanceAmt, BigDecimal amount) {
		balanceAmt = balanceAmt.subtract(amount);
		return balanceAmt;
	}

	static BigDecimal deposit(BigDecimal amount, BigDecimal balanceAmt) {
		balanceAmt = balanceAmt.add(amount);
		return balanceAmt;
	}

}

class HDFCBANK implements Bank {
	BigDecimal balanceAmt;

	@Override
	public BigDecimal interestRate() {

		return new BigDecimal(0.75);
	}

}

public class BankDemo {

	public static void main(String[] args) {
		BigDecimal bigDecimal = new BigDecimal(1000);
		BigDecimal bigDecimal2 = new BigDecimal(500);
		Bank.deposit(bigDecimal, bigDecimal2);

		System.out.println(Bank.deposit(bigDecimal, bigDecimal2));
		bigDecimal=bigDecimal.add(new BigDecimal(100));
		System.out.println(Bank.withdraw(bigDecimal, bigDecimal2));
	}

}
