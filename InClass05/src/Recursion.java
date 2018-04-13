/**
 * Class that has recursive methods that can compute the sums of digits in a number,
 * calculate Fibonacci numbers from the base case, and convert numbers from binary to decimal.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class Recursion {
	public static void main(String[] args) {
		if(addDigits(428) == 14){
			System.out.println("addDigits is correct!");
		}
		if(revFibonacci(0,1,1,5) == 5){
			System.out.println("revFib is correct!");
		}
		if(binToDec("1101100") == 108){
			System.out.println("binToDec is correct!");
		}
		if(addDigits(321) == 6){
			System.out.println("addDigits is correct!");
		}
		if(revFibonacci(0, 1, 1, 10) == 55){
			System.out.println("revFib is correct!");
		}
		if(binToDec("1011101") == 93){
			System.out.println("binToDec is correct!");
		}
	}
	/**Finds the Sum of the digits of num
	 * @param num value to find the sum of
	 * @return the sum of the digits
	 */
	public static int addDigits(int num){
		//gets last digit of the value
		int last = num % 10;
		
		//gets remaining first digits
	    int next = num / 10;
	    
	    //stops the recursion at the last digit
	    if (next == 0) {
	        return last;
	    }
	    
	    //adds last digit and calls method again
	    else{
	    return last + addDigits(next);
	    }
	}
	
	/**Finds the nth Fibonacci value
	 * @param f1 n-2 Fibonacci value
	 * @param f2 n-1 Fibonacci value
	 * @param c counter
	 * @param n the number c should count up to
	 * @return the nth Fibonacci value
	 */
	public static int revFibonacci(int f1, int f2, int c, int n){
		//stops recursion when the counter is the same as n
		if (c == n){
			return f2;
		}
		
		else{
			c++;
			int newF2 = f1 + f2;
			return revFibonacci(f2, newF2, c, n);
		}
	}
	
	/**Converts a binary string to decimal
	 * @param bin the binary string
	 * @return the decimal value
	 */
	public static int binToDec(String bin){
		int length = bin.length();
		
		//stops the recursion
		if (length == 0){
			return 0; 
		}
		
		String a = bin.substring(0,1); 
		String b = bin.substring(1);
		return Integer.parseInt(a)*(int)Math.pow(2, length-1) + binToDec(b);
	}
}
