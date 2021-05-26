package io.altar.jseproject.textinterface;

import java.util.Scanner;

public class ScannerUtils {

	private Scanner s = new Scanner(System.in);
	
	public String getText() { return s.nextLine(); }
	
	public int getInt() {
		do {
			if(s.hasNextInt()) {
				int in = s.nextInt();
				s.nextLine();
				return in;
			}
			else {
				System.out.println("Let's try again:");
				s.nextLine(); }
		} while (true);
	}
		
	public int getInt(int max) {
		int i;
		do {
			while(!s.hasNextInt()) {
				s.nextLine();
			}
			i = s.nextInt();
		} while(i > max && i != 0);
		return i;
	}
	
	public float getFloat() {
		do {
			if(s.hasNextFloat()) return s.nextFloat();
			else {
				System.out.println("Let's try again:");
				s.nextLine(); }
		} while (true);
	}
	
	public long getLong(long max) {
		long l;
		do {
			while(!s.hasNextLong()) {
				s.next();
			}
			l = s.nextLong();
		} while(l > max && l != 0);
		return l;
	}
	
	public int getInRange(int min, int max) {
		int i;
		do {
			i = getInt();
		} while(i > max || i < min);
		return i;
	}
	
	public int getOption(int... options) {
		int i;
		do {
			while(!s.hasNextInt()) {
				s.next();
			}
			i = s.nextInt();
			String s = "You must type one of these options:\n:: ";
			for(int option : options) {
				if(option == i) return i;
				s += option + " :: ";
			}
			System.out.println(s);
		} while(true);	
	}
	
	public void clearBuffer() {
		
		System.out.println("Clearbuffer");
		if(s.hasNext()) {
			s.nextLine();
			System.out.println("Has next");
		}
	}
	
}
