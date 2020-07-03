public class CtoFTester {
	public static double celsiusToFahrenheit(double C) {
		return C*(9/5.0)+32;
	}
	public static double fahrenheitToCelsius(double F) {
		return (F-32)*(5.0/9);
	}
	public static void main(String[] args) {
		System.out.println(celsiusToFahrenheit(0.0));
		System.out.println(fahrenheitToCelsius(32.0));
	}
}
