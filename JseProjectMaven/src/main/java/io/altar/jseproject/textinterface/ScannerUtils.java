package io.altar.jseproject.textinterface;

import java.util.Scanner;

import io.altar.jseproject.repositories.ShelfRepository;

public class ScannerUtils {

	private Scanner sc = new Scanner(System.in);
	
	public String getText() { return sc.nextLine(); }
	
	public int getInt() {
		do {
			if(sc.hasNextInt()) return sc.nextInt();
			else {
				System.out.println("Let's try again:");
				sc.nextLine(); }
		} while (true);
	}
		
	public int getInt(int max) {
		int i;
		do {
			while(!sc.hasNextInt()) {
				sc.next();
			}
			i = sc.nextInt();
		} while(i > max && i != 0);
		return i;
	}
	
	public float getFloat() {
		do {
			if(sc.hasNextFloat()) return sc.nextFloat();
			else {
				System.out.println("Let's try again:");
				sc.nextLine(); }
		} while (true);
	}
	
	public long getLong(long max) {
		long l;
		do {
			while(!sc.hasNextLong()) {
				sc.next();
			}
			l = sc.nextLong();
		} while(l > max && l != 0);
		return l;
	}
	
	public int getInRange(int min, int max) {
		int i;
		do {
			while(!sc.hasNextInt()) {
				sc.next();
			}
			i = sc.nextInt();
		} while(i > max || i < min);
		return i;
	}
	
	public int getOption(int... options) {
		int i;
		do {
			while(!sc.hasNextInt()) {
				sc.next();
			}
			i = sc.nextInt();
			String s = "You must type one of these options:\n";
			for(int option : options) {
				if(option == i) return i;
				s += option + " | ";
			}
			System.out.println(s);
		} while(true);	
	}
	
	
}
