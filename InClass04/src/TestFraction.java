/**
 * Program that tests the methods of the Fraction class by comparing
 * the actual results to the expected results of each method.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class TestFraction {

	public static void main(String[] args) {
		Fraction f1 = new Fraction(1, 2);
		Fraction f2 = new Fraction(3, 4);
		Fraction f3 = new Fraction(3, 2);
		String add = new String("addition");
		String sub = new String("subtraction");
		String mult = new String("multiplication");
		String div = new String("division");
		
		
		//test both types of adding Fractions
		
		//Adding same denominators
		Fraction result1 = f1.add(f3);
		Fraction answer1 = new Fraction(2, 1);
		
		//print out resulting fraction to check
		checkFraction(f1, f3, result1, answer1, add);
		
		//Adding different denominators
		Fraction result2 = f1.add(f2);
		Fraction answer2 = new Fraction(5, 4);
		
		//print out resulting fractions to check
		checkFraction(f1, f2, result2, answer2, add);
		
		//Subtracting same denominators
		Fraction result3 = f3.subtract(f1);
		Fraction answer3 = new Fraction(1, 1);
		
		//print out resulting fraction to check
		checkFraction(f3, f1, result3, answer3, sub);
		
		//Subtracting different denominators
		Fraction result4 = f3.subtract(f2);
		Fraction answer4 = new Fraction(3, 4);
		
		//print out resulting fraction to check
		checkFraction(f3, f2, result4, answer4, sub);
		
		//Multiplying same denominators
		Fraction result5 = f1.multiply(f3);
		Fraction answer5 = new Fraction(3, 4);
		
		//print out resulting fraction to check
		checkFraction(f1, f3,  result5, answer5, mult);
		
		//Multiplying different denominators
		Fraction result6 = f2.multiply(f3);
		Fraction answer6 = new Fraction(9, 8);
		
		//print out resulting fraction to check
		checkFraction(f2, f3, result6, answer6, mult);
		
		//Dividing same denominators
		Fraction result7 = f1.divide(f3);
		Fraction answer7 = new Fraction(1, 3);
		
		//print out resulting fraction to check
		checkFraction(f1, f3, result7, answer7, div);
		
		//Dividing different denominators
		Fraction result8 = f2.divide(f3);
		Fraction answer8 = new Fraction(1, 2);
		
		//print put resulting fraction to check
		checkFraction(f2, f3, result8, answer8, div);
		
	}
	/**
	 * Checks and prints the results of the sum
	 * @param f1 first fraction in the sum
	 * @param f2 second fraction in the sum
	 * @param result resulting fraction of sum
	 * @param answer expected result of sum
	 */
	public static void checkFraction(Fraction f1, Fraction f2, Fraction result, Fraction answer, String function){
		if(result.equals(answer) && function.equals("addition")){
			System.out.print("Correct: ");
			System.out.println(f1 + " + " + f2 + " = " + answer);
		}else if (!result.equals(answer) && function.equals("addition")){
			System.out.print("Incorrect: ");
			System.out.println(f1 + " + " + f2 + " != " + answer);
		}else if(result.equals(answer) && function.equals("subtraction")){
			System.out.print("Correct: ");
			System.out.println(f1 + " - " + f2 + " = " + answer);
		}else if(!result.equals(answer) && function.equals("subtraction")){
			System.out.print("Incorrect: ");
			System.out.println(f1 + " - " + f2 + " != " + answer);
		}else if(result.equals(answer) && function.equals("multiplication")){
			System.out.print("Correct: ");
			System.out.println(f1 + " * " + f2 + " = " + answer);
		}else if(!result.equals(answer) && function.equals("multiplication")){
			System.out.print("Incorrect: ");
			System.out.println(f1 + " * " + f2 + " != " + answer);
		}else if(result.equals(answer) && function.equals("division")){
			System.out.print("Correct: ");
			System.out.println(f1 + " / " + f2 + " = " + answer);
		}else{
			System.out.print("Incorrect: ");
			System.out.println(f1 + " / " + f2 + " = " + answer);
		}
	}
}
