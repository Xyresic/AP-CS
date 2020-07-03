public class BankAccount{
	private double balance;
	private int accountID;
	private String password;
	public BankAccount(double newBal, int newID, String newPass) {
		balance = newBal;
		accountID = newID;
		password = newPass;
	}
	public double getBal() {
		return balance;
	}
	public int getID() {
		return accountID;
	}
	public void setPassword(String newPass) {
		if(!password.equals(newPass)){
			password = newPass;
			System.out.println("Password sucessfully changed!");
		}
		else{
			System.out.println("New password cannot be the same as the old password!");
		}
	}
	public String toString() {
		return accountID+"\t$"+balance+"0";
	}
	public boolean deposit(double money, String enteredPass) {
		if(!authenticate(enteredPass)){
			System.out.println("Wrong password! Deposit failed!");
			return false;
		}
		else if(money<=0.0) {
			System.out.println("Please enter a positive amount. Deposit failed!");
			return false;
		}
		balance+=money;
		System.out.println("Deposit successful! Your new balance is: $"+balance+"0");
		return true;
	}
	public boolean withdraw(double money, String enteredPass) {
		if(!authenticate(enteredPass)){
			System.out.println("Wrong password! Withdrawal failed!");
			return false;
		}
		else if(money<=0.0) {
			System.out.println("Please enter a positive amount. Withdrawal failed!");
			return false;
		}
		else if(money>balance){
			System.out.println("Please enter an amount less than or equal to your current balance. Withdrawal failed!");
			return false;
		}
		balance-=money;
		System.out.println("Withdrawal successful! Your new balance is: $"+balance+"0");
		return true;
	}
	private boolean authenticate(String password) {
		return this.password.equals(password);
	}
	public boolean transferTo(BankAccount other, double amount, String password) {
		if(!authenticate(password)) {
			System.out.println("Wrong password! Transfer failed!");
			return false;
		}
		else if(amount<=0.0) {
			System.out.println("Please enter a positive amount. Transfer failed!");
			return false;
		}
		else if(amount>balance){
			System.out.println("Please enter an amount less than or equal to your current balance. Transfer failed!");
			return false;
		}
		balance-=amount;
		other.balance+=amount;
		System.out.println("Transfer successful! Your new balance is: $"+balance+"0");
		return true;
	}
}
