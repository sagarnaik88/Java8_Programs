package Java8.stream.api.preparation;

import Java8.stream.api.preparation.inter.Fmultify;

/**
 * @author Sagar_09_11_2021
 * Write a program to multify two numbers using functional interface
 */
public class MultifyNumberUsingFunctionalInter {

	public static void main(String[] args) {
		Fmultify total = (a , b) -> a * b;
		System.out.println("Total Multify is :- "+ total.multify(5, 5));
	}
}
