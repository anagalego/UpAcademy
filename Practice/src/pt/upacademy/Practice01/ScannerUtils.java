package pt.upacademy.Practice01;

import java.util.Scanner;

public class ScannerUtils {
	private Scanner sc = new Scanner(System.in);
	
	public int getInt() {
		do {
			if(sc.hasNextInt()) return sc.nextInt();
			else {
				System.out.println("Let's try again. Please only numbers:");
				sc.nextLine(); }
		} while (true);
	}
	
	
	public void setRange(int min, int max) {
		int val = getInt();
		while(val < min || val > max) {
			if(min > val) {
				System.out.println("This number is below " + min + ".\nType again:");
				val = getInt();
			} else if(val > max) {
				System.out.println("This number is above " + max + ".\nType again:");
				val = getInt();
			}
		} fizzBuzz(val); 
	}
	
	public void fizzBuzz(int val) {
		int start = 1;
		do{
			if(start%3 == 0 && start%5 == 0) System.out.println(start + ": FizzBuzz");
			else if(start%3 == 0) System.out.println(start + ": Fizz");
			else if(start%5 == 0) System.out.println(start + ": Buzz");
			else System.out.println(start + ": ");
			start++;
		} while(start<=val);
		
	}
}














