import java.util.ArrayList;
import java.util.*;
import java.util.Random;


public class RandomIntegers {

	public static void main(String[] args) {

		//Creates a new ArrayList with random integers from 1-100
		ArrayList <Integer> numberList = new ArrayList <Integer>();
		Random randomGenerator = new Random();
		for (int i = 0; i <= 9; i++){
			int randomNumber = (randomGenerator.nextInt(100)) + 1;
			numberList.add(i, randomNumber);
		}

		System.out.println(numberList);

		Scanner choiceScanner = new Scanner(System.in);

		boolean flag = true;

		do{
			//Creates menu for the user
			System.out.println();
			System.out.println("Enter a command:");
			System.out.println("1. Compute sum");
			System.out.println("2. Maximum value");
			System.out.println("3. Find matching value");
			System.out.println("4. Exit");
			int choice = 0;

			//Tests user input
			boolean testInput = true;
			while(testInput){
				try
				{
					choice = choiceScanner.nextInt();
					testInput = false;
				}
				catch (InputMismatchException im){
					choiceScanner.next();
					System.out.println("Invalid Input");
				}
			}
			System.out.println();

			while (choice < 1 || choice > 4){
				System.out.println("Please enter \"1\", \"2\", \"3\", or \"4\".);");
				choice = choiceScanner.nextInt();
			}
			switch(choice){
			case 1:
				System.out.println(computeSum(numberList));
				break;
				
			case 2:
				System.out.println(maximumValue(numberList));
				break;
				
			case 3:
				testInput = true;
				int match = 0;
				System.out.println("Enter the number that you want to find:");
				
				//Tests user input
				while(testInput){
					try{
						match = choiceScanner.nextInt();
						testInput = false;
					}
					catch (InputMismatchException im){
						choiceScanner.next();
						System.out.println("Invalid input");
					}
				}
				System.out.println(matchingValue(numberList, match));
				break;
				
			case 4:
				flag = false;
				break;
				
			default:
				System.out.println("Input is invalid.");
			}
		}while (flag != false);
		choiceScanner.close();
	}

	/**
	 * Takes an ArrayList of integers and sorts the numbers from lowest to highest
	 * 
	 * @param numbers ArrayList that will be sorted
	 */
	public static ArrayList<Integer> sort(ArrayList<Integer> numbers){
		for(int i = 0; i < numbers.size(); i++) {
			int lowest = i;
			for(int j = i + 1; j < numbers.size(); j++){
				if(numbers.get(j) < numbers.get(lowest)){
					lowest = j;
				}
			}
			int swap = numbers.get(i);
			numbers.set(i, numbers.get(lowest));
			numbers.set(lowest, swap);
		}
		return numbers;
	}

	/**
	 * Takes an ArrayList and adds all of its values together to obtain a sum
	 * 
	 * @param numbers ArrayList where the numbers will be added up to get a sum
	 * @return the sum of the numbers in the array list
	 */
	public static int computeSum(ArrayList<Integer> numbers){
		int sum = 0;
		for(int i = 0; i < numbers.size(); i++){
			sum += numbers.get(i);
		}
		return sum;
	}

	/**
	 * Sorts through an ArrayList and returns the highest value amongst all
	 * of its numbers
	 * 
	 * @param numbers ArrayList that will be sorted through
	 * @return the maximum value in the ArrayList
	 */
	public static int maximumValue(ArrayList<Integer> numbers){
		int maximum = numbers.get(0);
		for (int i = 1; i < numbers.size(); i++){
			if (numbers.get(i) > maximum){
				maximum = numbers.get(i);
			}
		}
		return maximum;
	}

	/**
	 * Sorts through an ArrayList and returns either the index of the value
	 * the user enters if it is present in the ArrayList, or the value
	 * that the user enters if it is absent from the ArrayList
	 * 
	 * @param numbers ArrayList that will be sorted through
	 * @param match number that is searched for in the ArrayList
	 * @return either the index of the number entered, or the number entered
	 */
	public static int matchingValue(ArrayList<Integer> numbers, int match)
	{
		int matchingIndex = match;
		for (int i = 0; i < numbers.size(); i++){
			if (numbers.get(i) == match){
				matchingIndex = i;
			}
			else
			{
				System.out.println("The number you entered was not found.");
				System.out.println("This is the number that you entered:");
			}
		}
		return matchingIndex;
	}
}

