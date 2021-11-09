package bankomat;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {
	// Referenzvariablen
	private int customerNr;
	private int pinNr;
	private double checkBalance = 0;
	private double saveBalance = 0;

	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

	public Account() {
	}

	public Account(int customerNumber, int pinNumber) {
		this.customerNr = customerNumber;
		this.pinNr = pinNumber;
	}

	public Account(int customerNumber, int pinNumber, double checkingBalance, double savingBalance) {
		this.customerNr = customerNumber;
		this.pinNr = pinNumber;
		this.checkBalance = checkingBalance;
		this.saveBalance = savingBalance;
	}

	public int setCustomerNumber(int customerNumber) {
		this.customerNr = customerNumber;
		return customerNumber;
	}

	public int getCustomerNumber() {
		return customerNr;
	}

	public int setPinNumber(int pinNumber) {
		this.pinNr = pinNumber;
		return pinNumber;
	}

	public int getPinNumber() {
		return pinNr;
	}

	public double getCheckingBalance() {
		return checkBalance;
	}

	public double getSavingBalance() {
		return saveBalance;
	}

	public double calcCheckingWithdraw(double amount) {
		checkBalance = (checkBalance - amount);
		return checkBalance;
	}

	public double calcSavingWithdraw(double amount) {
		saveBalance = (saveBalance - amount);
		return saveBalance;
	}

	public double calcCheckingDeposit(double amount) {
		checkBalance = (checkBalance + amount);
		return checkBalance;
	}

	public double calcSavingDeposit(double amount) {
		saveBalance = (saveBalance + amount);
		return saveBalance;
	}

	public void calcCheckTransfer(double amount) {
		checkBalance = checkBalance - amount;
		saveBalance = saveBalance + amount;
	}

	public void calcSavingTransfer(double amount) {
		saveBalance = saveBalance - amount;
		checkBalance = checkBalance + amount;
	}

	public void getCheckingWithdrawInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(checkBalance));
				System.out.print("\nAmount you want to withdraw from Checkings Account: ");
				double amount = input.nextDouble();
				if ((checkBalance - amount) >= 0 && amount >= 0) {
					calcCheckingWithdraw(amount);
					System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(checkBalance));
					end = true;
				} else {
					System.out.println("\nBalance Cannot be Negative.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	public void getsavingWithdrawInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(saveBalance));
				System.out.print("\nAmount you want to withdraw from Savings Account: ");
				double amount = input.nextDouble();
				if ((saveBalance - amount) >= 0 && amount >= 0) {
					calcSavingWithdraw(amount);
					System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(saveBalance));
					end = true;
				} else {
					System.out.println("\nBalance Cannot Be Negative.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	public void getCheckingDepositInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(checkBalance));
				System.out.print("\nAmount you want to deposit from Checkings Account: ");
				double amount = input.nextDouble();
				if ((checkBalance + amount) >= 0 && amount >= 0) {
					calcCheckingDeposit(amount);
					System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(checkBalance));
					end = true;
				} else {
					System.out.println("\nBalance Cannot Be Negative.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	public void getSavingDepositInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(saveBalance));
				System.out.print("\nAmount you want to deposit into your Savings Account: ");
				double amount = input.nextDouble();

				if ((saveBalance + amount) >= 0 && amount >= 0) {
					calcSavingDeposit(amount);
					System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(saveBalance));
					end = true;
				} else {
					System.out.println("\nBalance Cannot Be Negative.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	public void getTransferInput(String accType) {
		boolean end = false;
		while (!end) {
			try {
				if (accType.equals("Checkings")) {
					System.out.println("\nSelect an account you wish to tranfers funds to:");
					System.out.println("1. Savings");
					System.out.println("2. Exit");
					System.out.print("\nChoice: ");
					int choice = input.nextInt();
					switch (choice) {
					case 1:
						System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(checkBalance));
						System.out.print("\nAmount you want to deposit into your Savings Account: ");
						double amount = input.nextDouble();
						if ((saveBalance + amount) >= 0 && (checkBalance - amount) >= 0 && amount >= 0) {
							calcCheckTransfer(amount);
							System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(saveBalance));
							System.out.println(
									"\nCurrent Checkings Account Balance: " + moneyFormat.format(checkBalance));
							end = true;
						} else {
							System.out.println("\nBalance Cannot Be Negative.");
						}
						break;
					case 2:
						return;
					default:
						System.out.println("\nInvalid Choice.");
						break;
					}
				} else if (accType.equals("Savings")) {
					System.out.println("\nSelect an account you wish to tranfers funds to: ");
					System.out.println("1. Checkings");
					System.out.println("2. Exit");
					System.out.print("\nChoice: ");
					int choice = input.nextInt();
					switch (choice) {
					case 1:
						System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(saveBalance));
						System.out.print("\nAmount you want to deposit into your savings account: ");
						double amount = input.nextDouble();
						if ((checkBalance + amount) >= 0 && (saveBalance - amount) >= 0 && amount >= 0) {
							calcSavingTransfer(amount);
							System.out.println("\nCurrent checkings account balance: " + moneyFormat.format(checkBalance));
							System.out.println("\nCurrent savings account balance: " + moneyFormat.format(saveBalance));
							end = true;
						} else {
							System.out.println("\nBalance Cannot Be Negative.");
						}
						break;
					case 2:
						return;
					default:
						System.out.println("\nInvalid Choice.");
						break;
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}
}