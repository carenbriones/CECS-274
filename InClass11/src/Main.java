import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class that allows a user to print out a list of words and their
 * frequencies in the text, or search for a particular word from
 * the text.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 *
 */
public class Main {

	public static void main(String[] args) {
		File file = new File("words.txt");
		BST tree = new BST();
		try{
			Scanner fileScan = new Scanner(file);
			while (fileScan.hasNextLine()){
				String w = fileScan.nextLine();
				Word word = new Word(w);
				tree.add(word);
			}
			fileScan.close();
		} catch (FileNotFoundException fnf){
			System.out.println("File was not found.");
		}

		Scanner input = new Scanner(System.in);
		int choice = 0;
		boolean flag = true;
		do{
			System.out.println("Choose an option: ");
			System.out.println("1.  Print out the list of words");
			System.out.println("2.  Search for a word");
			System.out.println("3.  Quit");
			
			boolean testInput = true;
			while(testInput){
				try
				{
					choice = input.nextInt();
					testInput = false;
				}
				catch (InputMismatchException im){
					input.next();
					System.out.println("Please enter \"1\", \"2\", or \"3\".");
					System.out.println();
				}
			}

			while (choice < 1 || choice > 3){
				System.out.println("Please enter \"1\", \"2\", or \"3\".");
				choice = input.nextInt();
			}
			
			switch(choice){
			case 1:
				tree.printBST();
				System.out.println();
				break;
			case 2:
				System.out.println("Enter the word you are searching for: ");
				String s = input.next();
				Word w = new Word(s);
				if (tree.search(w) != null){
					System.out.println("frequency = " + tree.search(w).getWord().getFrequency());
				}
				System.out.println();
				break;
			case 3:
				flag = false;
				break;

			default:
				System.out.println("Input is invalid");
				System.out.println();
			}
		} while (flag != false);
	}
}