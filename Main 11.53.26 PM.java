/*This program converts Arabic numbers into Roman Numerals
*	Made by Kevin Ge
*	7/15/18
*/
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input from 1 - 3999");
		int input = sc.nextInt() % 4000;
		int storedValue = input % 4000;
		
		int[] letter = {0,0,0,0}; // {M,C,X,I}
		char[] charletter1 = {'M','C','X','I'}; //base 10 charletter1
		char[] charletter5 = {' ','D','L','V'}; //corresponding charletter5
		//    array location   0   1   2   3
		int mult = 1000;
		for (int count = 0; count < 4; count ++) {
			while (input / mult > 0) { // %10 
				input = input - mult;
				letter[count] ++;
			}
			mult = mult / 10;
		}
		
		System.out.print("\n" + storedValue + " = ");
		for (int count = 0; count < 4; count ++) {
			//System.out.println("\ncount " + count);
			//System.out.println("case " + letter[count]);
			switch (letter[count]) {
			case 0:
			case 1:
			case 2:
			case 3: //print as normal
				for (int j = 0; j < letter[count]; j ++) System.out.print(charletter1[count]); 
				break;
			case 4: //print 1 charletter1 followed by its corresponding charletter5
				System.out.print(charletter1[count] + "" + charletter5[count]);
				break;
			case 5:
			case 6:
			case 7:
			case 8: //print corresponding charletter5, followed by the amount of charletter1 - 5
				System.out.print(charletter5[count]);
				for (int j = 0; j < letter[count] - 5; j ++) System.out.print(charletter1[count]);
				break;
			case 9: //print 1 charletter1 followed by the previous charletter1
				System.out.print(charletter1[count] + "" + charletter1[count - 1]);
				break;
			
			default: System.out.println("\nerror");
			}
		}
	}
}
