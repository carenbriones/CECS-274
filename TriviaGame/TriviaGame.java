import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TriviaGame {

	public static void main(String[] args) throws FileNotFoundException {
	//modify question (displays list of questions, user can select one
	//and the user can choose a part to modify)
		Scanner choiceScanner = new Scanner(System.in);
		int choice = 0;
		boolean flag = true;
		do{
			System.out.println("1.  Take quiz.");
			System.out.println("2.  Add question.");
			System.out.println("3.  Modify question.");
			System.out.println("4.  Quit.");
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

			while (choice < 1 || choice > 5){
				System.out.println("Please enter \"1\", \"2\", \"3\", or \"4\".);");
				choice = choiceScanner.nextInt();
			}
			switch(choice){
			case 1:
				System.out.println("Which category would you like to be quizzed on?");
				System.out.println("1.  Adventure Time");
				System.out.println("2.  Harry Potter");
				System.out.println("3.  Star Wars");
				int categoryChoice = choiceScanner.nextInt();
				if (categoryChoice == 1){
					Category adventureTime = new Category("Adventure Time", AdventureTime.txt);
					takeQuiz(adventureTime.getQuestions());
				}
				else if (categoryChoice == 2){
					Category harryPotter = new Category("Harry Potter", HarryPotter.txt);
					takeQuiz(harryPotter.getQuestions());
				}
				else if (categoryChoice == 3){
					Category starWars = new Category("Star Wars", StarWars.txt);
					takeQuiz(starWars.getQuestions());
				}
				else{
					System.out.println("Please enter \"1\", \"2\", or \"3\".");
				}
				break;

			case 2:
				
				
				break;

			case 3:
				
				break;

			case 4:
				flag = false;
				break;
				
			default:
				System.out.println("Input is invalid.");
			}
		}while (flag != false);
	}
	
	//take quiz, questions are randomized, should have counter for when the user gets the answer correct
	public static void takeQuiz(ArrayList<Question> questions){
		int correctAnswers = 0;
		Random randGenerator = new Random();
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < 10; i ++){
			int randQuestion = randGenerator.nextInt(questions.size());
			System.out.println(questions.get(randQuestion));
			//removes question from array so it won't be accessed again; is not permanent
			questions.remove(randQuestion);
			int userAnswer = input.nextInt();
			if (userAnswer == questions.get(randQuestion).getSolution()){
				correctAnswers++;
			}
		}
		System.out.println("You got " + correctAnswers + " out of 10 questions correct.");
	}
}
