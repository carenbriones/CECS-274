public class Recursion2 {
	public static void main(String[] args) {
		int [] array = {46, 22, 7, 58, 91, 55, 31, 84, 12, 78};
		if(findMax(array) == 91) {
			System.out.println("findMax is correct!");
		}
		if(reverseStr("Hello").equals("olleH")) {
			System.out.println("reverseString is correct!");
		}
		if(charFrequency("antidisestablishmentarianism", 'i') == 5){
			System.out.println("charFrequency is correct!");
		}
		if(findMin(array) == 7){
			System.out.println("findMin is correct!");
		}
		if(reverseStr("pupils").equals("slipup")){
			System.out.println("reverseString is correct!");
		}
		if(charFrequency("antidisestablishmentarianism", 'a') == 4){
			System.out.println("charFrequency is correct!");
		}
	}
	
	/**
	 * Finds the maximum value in an array
	 * @param array array of values (sorted or unsorted)
	 * @param i iterator
	 * @param max maximum value found so far
	 * @return maximum value
	 */
	public static int maxArray(int [] array, int i, int max) {
		if (i == array.length - 1){
			return max;
		}
		else{
			i++;
			if (array[i] > max){
				max = array[i];
			}
			return maxArray(array, i, max);
		}
	}
	
	/**
	 * Finds the maximum value of an array
	 * @param array array of values
	 * @return maximum value
	 */
	public static int findMax(int [] array){
		return maxArray(array, 0, 0);
	}
	
	/**
	 * Finds the minimum value of an array
	 * @param array array of values (sorted or unsorted)
	 * @param i iterator
	 * @param min minimum value found so far
	 * @return minimum value
	 */
	public static int minArray(int [] array, int i, int min){
		if (i == array.length - 1){
			return min;
		}
		else{
			i++;
			if (array[i] < min){
				min = array[i];
			}
			return minArray(array, i, min);
		}
	}
	
	/**
	 * Finds the minimum value of an array
	 * @param array array of values
	 * @return minimum value
	 */
	public static int findMin(int [] array){
		return minArray(array, 0, array[0]);
	}
	
	/** 
	 * Reverses a string
	 * @param s the string to reverse
	 * @return the reversed string
	 */
	public static String reverseStr(String s) {
		if (s.length() == 1){
			return s;
		}
		else{
			return reverseStr(s.substring(1)) + s.charAt(0);
		}
	}
	
	/** 
	 * Returns the number of times c appears in the string str
	 * @param str string to test
	 * @param c character to find
	 * @return number of times the character appeared in the string
	 */
	public static int charFrequency(String str, char c) {
		if (str.length() == 0){
			return 0;
		}
		else if (str.charAt(0) == c){
			return 1 + charFrequency(str.substring(1), c);
		}
		else{
			return charFrequency(str.substring(1), c);
		}
	}
}