import java.awt.Point;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		char array[][] = new char[5][5];
		
		//fills array with periods
		for (int i = 0; i < 5; i++){
			for (int j = 0; j < 5; j++){
				array[i][j] = '.';
			}
		}
		
		LinkedStack stack = new LinkedStack();
		
		//adds each coordinate to the stack
		stack.push(getCoordinate(1));
		stack.push(getCoordinate(2));
		stack.push(getCoordinate(3));
		stack.push(getCoordinate(4));
		stack.push(getCoordinate(5));
		
		//pops stack and modifies the array
		addPoints(array, stack, '5');
		addPoints(array, stack, '4');
		addPoints(array, stack, '3');
		addPoints(array, stack, '2');
		addPoints(array, stack, '1');
		
		//prints out final array
		printArray(array);
		
	}
	
	/**
	 * Gets the Point from the user, only taking in the numbers 0-4
	 * for both the x and y coordinates
	 * @param i the number coordinate it is out of the 5
	 * @return the point given by the user
	 */
	public static Point getCoordinate(int i){
		Scanner scan = new Scanner(System.in);
		int x = 0;
		int y = 0;
		boolean testInput = true;
		while (testInput){
			System.out.println("X value #" + i);
			try{
				x = scan.nextInt();
				testInput = false;
			} catch(InputMismatchException im){
				scan.next();
				System.out.println("Invalid input. Enter a new number");
				System.out.println();
			}
		}
		while(x < 0 || x > 4){
			System.out.println("Enter a number from 0 to 4: ");
			x = scan.nextInt();
		}
		testInput = true;
		while (testInput){
			System.out.println("Y value #" + i);
			try{
				y = scan.nextInt();
				testInput = false;
			} catch(InputMismatchException im){
				scan.next();
				System.out.println("Invalid input. Enter a new number");
				System.out.println();
			}
		}
		while(y < 0 || y > 4){
			System.out.println("Enter a number from 0 to 4: ");
			y = scan.nextInt();
		}
		return new Point(x,y);
	}
	
	/**
	 * Returns the modified array, changing the point in the array
	 * along with the neighboring spots (if possible) to a
	 * corresponding number
	 * @param array 2d array to modify
	 * @param stack LinkedStack object to obtain and remove points from
	 * @param num number to fill in the array with
	 * @return the new modified array
	 */
	public static char[][] addPoints(char[][] array, LinkedStack stack, char num){
		Point p = stack.pop();
		int x = (int) p.getX();
		int y = (int) p.getY();
		array[y][x] = num;
		if (x - 1 >= 0){
			array[y][x - 1] = num;
		}
		if (x + 1 <= 4){
			array[y][x + 1] = num;
		}
		if (y - 1 >= 0){
			array[y - 1][x] = num;
		}
		if (y + 1 <= 4){
			array[y + 1][x] = num;
		}
		return array;
	}
	
	/**
	 * Prints a 2d array
	 * @param array array to print
	 */
	public static void printArray(char[][] array){
		for (int i = 0; i < 5; i++){
			for (int j = 0; j < 5; j++){
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
}
