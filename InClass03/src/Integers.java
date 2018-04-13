import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Integers {

	public static void main(String[] args) throws FileNotFoundException {


		//Writes the numbers into a text file
		File randomNumbers = new File("numbers.txt");
		Scanner numberReader = new Scanner(randomNumbers);
		ArrayList <Integer> numberList = new ArrayList<Integer> ();
		do{
			numberList.add(numberReader.nextInt());
		}while (numberReader.hasNext());
		displayValues(numberList);
		System.out.println();
		displayValues(sort(numberList));
	}

	/**
	 * Displays the values in 10 lines with 10 values each, with a comma
	 * separating each value within the lines
	 * 
	 * @param numbers ArrayList where the values come from
	 */
	public static void displayValues(ArrayList <Integer> numbers){
		for (int i = 0; i < 100; i++){
			if ((i + 1) % 10 != 0 || i == 0){
				System.out.print(numbers.get(i) + ", ");
			}

			//else condition for the end of each line
			else
			{
				System.out.print(numbers.get(i));
				System.out.println();
			}
		}
	}

	/**
	 * Sorts numbers from lowest to highest
	 * 
	 * @param numbers arrayList to be sorted
	 * @return ArrayList of numbers
	 */
	public static ArrayList <Integer> sort(ArrayList<Integer> numbers){
		for (int i = 0; i < numbers.size(); i++){
			int lowest = i;
			for (int j = i + 1; j < numbers.size(); j++){
				if (numbers.get(j) < numbers.get(lowest)){
					lowest = j;
				}
			}
			int swap = numbers.get(i);
			numbers.set(i, numbers.get(lowest));
			numbers.set(lowest, swap);
		}
		return numbers;
	}
}
