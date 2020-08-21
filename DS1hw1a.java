//Ainsley Soane
// unique variable count is 2
//the diffrence between the max and min is 2.0
//the average to the power of min is 474.2716049382717
//
//unique variable count is 3
//the diffrence between the max and min is 3.0
//the average to the power of min is 203067.06310013722

package homework;

import stdlib.StdIn;
import stdlib.StdOut;

public class DS1hw1a {

	public static void main(String[] args){
		double A,B,C;
		StdOut.println("enter A");
		A= StdIn.readDouble();
		StdOut.println("enter B");
		B= StdIn.readDouble();
		StdOut.println("enter C");
		C= StdIn.readDouble();
		int count = 0;
		double average = (A + B + C)/ 3;
		double maxx = Math.max(Math.max(A, B), C);
		double minn = Math.min(Math.min(A, B), C);
		double diff = maxx - minn;
		double avgmin = Math.pow(average, minn);
		
		if (A != B) {
			if (A != C) {
				count++;
				if (B == C) {
					count++;
				}
				
			}
		}
		if (B != A) {
			if (B != C) {
				count++;
				if (A == C) {
					count++;
	}
		}
		if (C != A) {
			if (C != B) {
				count++;
				if (B == A) {
					count++;
	}
			}
		}
		}
	StdOut.println("unique variable count is " + count);
	StdOut.println("the diffrence between the max and min is " + diff);
	StdOut.println("the average to the power of min is " + avgmin);
	

	}
}

