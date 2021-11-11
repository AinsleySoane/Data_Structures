package homework;

import java.util.ArrayList;

/*
 *  DS1 Homework 3b:  the file name must be  PairOfDice
 *  Version 1.0
 *  
 *   Ainsley Soane
 *   Data Structures
 *   
 *   Delete one of the following:
 *  A) The work submitted here is solely mine. 
 *  
 *  B) I had *some* help on the following parts of this assignment
 *   
 *   
 *  copy/paste the output in the space below
 *  ------------------------------------------------------
 *  
 *  
 *  
 *  --------------------------------------------------------
 *  
 * This is a skeleton file for your homework. Edit the sections marked TODO.
 *
 * You must not change the declaration of any method. 
 * You may not use any other Java classes (e.g. ArrayLists, etc) without permission
 * of the instructor.
 * Do not change the main function
 */
import stdlib.StdOut;
import stdlib.StdRandom;
/*
 * The class PairOfDice implements some basic functionality
 * of a pair of dice.  You may not add any methods to this class
 * other than those indicated below.
 */
public class PairOfDice {
	private int die1, die2;

	public PairOfDice() {  // constructor
		roll();
	}

	public void roll() {  // randomize the dice values
		die1 = StdRandom.uniform(1, 7);  // returns a random number from 1 to 6
		die2 = StdRandom.uniform(1, 7);
	}
	public boolean isDoubles() { // determines if the two die values are the name
		return die1 == die2;
	}
	public int sum() {     // the the sum of the two die values
		return die1 + die2;
	}
	public String toString() {  // create a string representation
		return " D1: " + die1 + " D2: " + die2;
	}

	// ToDo 1
	// add an instance method that determines if the current dice sum is less than 5 or greater than 10
	// return true or false
	
	public boolean fiveTen() {
		return (this.sum() < 5 || this.sum() > 10); 
	}

	// ToDo 2
	// add an instance method that determines if the dice values are within 2 of each other
	// example:  1,2 are within 2 of each other;  
	// example:  2,4 are within 2 of each other
	// example:  2 5 are not within 2 of each other
	// hint boolean
	
	public boolean withinTwo() {
		return ((die1 - die2) == 2 || (die2 - die1) == 2 || (die1 - die2) == 1 || (die2 - die1) == 1 || (die2 - die1) == 0 );
	}
	// Math.abs(die1-die2)
	
	
	//------------------------------------- testing program    static functions  ---------------------

	/*
	 * experiment A
	 * Question:  what is the likelihood of the die values being within 2 of each other?
	 * To answer this, complete this function which
	 * should roll the dice 1,000,000 times and 
	 * determine and return the percentage of rolls that are within 2 of each other.
	 * 
	 * Hint: you will need to used instance methods of the PairOfDice class
	 */
	public static double experimentA( PairOfDice x) {
		//how do you call in another premade function form above
		
		double perc = 0;
		
		for (int count = 0; count < 1000000; count++) {
			x.roll();
			if (x.withinTwo()) {
				perc++;
			}
		}
		return perc / 1000000; 
	}
	
	//Math.abs
	
	/* experiment B
	 * 
	 * Q. how many rolls does it take (on the average) to roll a value less than 5 or greater than 10?
	 * 
	 * first write a loop to count the number of rolls needed to roll a 2,3,4,11, or 12
	 * For example   if the rolls were:  5 8 6 5 7 11, it took 6 rolls to get an 11 (this time)
	 * then add code to repeat that test 1,000,000 times.  
	 * return: the average (number of rolls needed) of all the tests
	 * hint:  nested loops, use the  lessThan5GreaterThan10 instance method that you wrote above
	 */

	public static double experimentB( PairOfDice x) {
		
		double count= 0;

		for (double j = 0; j < 1000000; j++) {
			for (double i = 0; ;i++) {
				x.roll();
				count++;
				if (x.sum()==2 || x.sum()==3  || x.sum()==4  || x.sum()==11  || x.sum()==12 ) {
					break;
				}
			}
		}
		return count/1000000;

	}

	// nothing to do here
	public static void main(String[] args) {

		PairOfDice myDice = new PairOfDice();

		// test your instance methods?
		// roll the dice, print the die values, call and print the results of your method, manually verify
		// remove or comment out this testing code before submitting
		
		
		double probWithin2 = experimentA(myDice);   
		double rollsToGet2341112 = experimentB(myDice); // 2, 3, 4 11 or 12
		
		StdOut.format(" The experimental probablity of the die values being within 2 of each other  %5.3f\n", probWithin2);
		StdOut.format(" The average number of rolls to get a value less than 5 or more than 10 was %5.3f\n", rollsToGet2341112);

	}



}
