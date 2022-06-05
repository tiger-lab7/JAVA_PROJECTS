

import java.util.Scanner;

public class Hello {
	
	
	public static void main(String... args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter int kilometers and double price per kilometer");
		
		int kilometers = scanner.nextInt();
		
		double price = scanner.nextDouble();
		
		double cost = kilometers * price;
		
		System.out.println("Result: " + cost);
		
	}
	
}