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
		Scanner input = new Scanner(System.in);
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
					choice = input.nextInt();
					testInput = false;
				}
				catch (InputMismatchException im){
					input.next();
					System.out.println("Invalid Input");
				}
			}
			System.out.println();

			while (choice < 1 || choice > 5){
				System.out.println("Please enter \"1\", \"2\", \"3\", or \"4\".);");
				choice = input.nextInt();
			}
			switch(choice){
			case 1:
				System.out.println("Which category would you like to be quizzed on?");
				System.out.println("1.  Adventure Time");
				System.out.println("2.  Harry Potter");
				System.out.println("3.  Star Wars");
				int categoryChoice = input.nextInt();
				if (categoryChoice == 1){
					String fileName = "AdventureTime.txt";
					File file = new File(fileName);
					Category adventureTime = new Category("Adventure Time", file);
					takeQuiz(adventureTime.getQuestions());
				}
				else if (categoryChoice == 2){
					String fileName = "HarryPotter.txt";
					File file = new File(fileName);
					Category harryPotter = new Category("Harry Potter", file);
					takeQuiz(harryPotter.getQuestions());
				}
				else if (categoryChoice == 3){
					String fileName = "StarWars.txt";
					File file = new File(fileName);
					Category starWars = new Category("Star Wars", file);
					takeQuiz(starWars.getQuestions());
				}
				else{
					System.out.println("Please enter \"1\", \"2\", or \"3\".");
				}
				break;

			case 2:
				System.out.println("Which category would you like to add a question to?");
				System.out.println("1.  Adventure Time");
				System.out.println("2.  Harry Potter");
				System.out.println("3.  Star Wars");
				//initializes the Category as the first category
				int catChoice = input.nextInt();
				String fileName = "AdventureTime.txt";
				File file = new File(fileName);
				Category addTo = new Category("Adventure Time", file);
				if (catChoice == 2){
					fileName = "HarryPotter.txt";
					file = new File(fileName);
					addTo = new Category("Harry Potter", file);
				}
				else if (catChoice == 3){
					fileName = "StarWars.txt";
					file = new File(fileName);
					addTo = new Category("Star Wars", file);
				}
				else if (catChoice != 1 && catChoice != 2 && catChoice != 3){
					System.out.println("Please enter \"1\", \"2\", or \"3\".");
				}
				System.out.println("Enter your question: ");
				String question = input.nextLine();
				System.out.println("Enter the first answer choice: ");
				String answer1 = input.nextLine();
				System.out.println("Enter the second answer choice: ");
				String answer2 = input.nextLine();
				System.out.println("Enter the third answer choice: ");
				String answer3 = input.nextLine();
				System.out.println("Enter the fourth answer choice: ");
				String answer4 = input.nextLine();
				System.out.println("Enter the number corresponding to the correct answer: ");
				int solution = input.nextInt();
				Question ques = new Question(question, answer1, answer2, answer3, answer4, solution);
				addTo.addQuestion(ques);
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
	
	/**
	 * Allows the user to take a quiz, getting a score out of 10 at the end
	 * @param questions ArrayList of questions the user will be asked
	 */
	public static void takeQuiz(ArrayList<Question> questions){
		int correctAnswers = 0;
		Random randGenerator = new Random();
		Scanner input = new Scanner(System.in);
		for (int i = 9; i > 0; i--){
			int randQuestion = randGenerator.nextInt(i);
			questions.get(randQuestion).getFullQuestion();
			int userAnswer = input.nextInt();
			if (userAnswer == questions.get(randQuestion).getSolution()){
				correctAnswers++;
			}
			//removes question from array so it won't be accessed again; is not permanent
			questions.remove(randQuestion);
		}
		questions.get(0).getFullQuestion();
		int userAnswer = input.nextInt();
		if (userAnswer == questions.get(0).getSolution()){
			correctAnswers++;
		}
		System.out.println("You got " + correctAnswers + " out of 10 questions correct.");
		System.out.println();
	}
}
