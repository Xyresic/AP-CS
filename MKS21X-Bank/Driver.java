public class Driver{
	public static void testTransfer(BankAccount acc, BankAccount other, double amount, String pass) {
		if(acc.transferTo(other, amount, pass)){
			System.out.println("Transfer successful!");
		}
		else{
			System.out.println("Transfer failed!");
		}
	}
	public static void main(String[] args) {
		BankAccount account = new BankAccount(1.0,10001,"password");
		BankAccount taxes = new BankAccount(100.0,10002,"public");
		System.out.println(account);
		System.out.println("Your balance is: $"+account.getBal()+"0");
		System.out.println("Your Account ID is: "+account.getID());
		account.deposit(1.0,"password");
		account.withdraw(1.0,"password");
		account.deposit(-1.0,"password");
		account.withdraw(100.0,"password");
		account.setPassword("password");
		account.setPassword("1234567890");
		account.deposit(1.0,"password");
		account.deposit(1.0,"1234567890");
		account.transferTo(taxes, 1.0, "1234567890");
		account.transferTo(taxes, -1.0, "1234567890");
		account.transferTo(taxes, 1.0, "password");
		account.transferTo(taxes, 1000000000.0, "1234567890");
	}
}
