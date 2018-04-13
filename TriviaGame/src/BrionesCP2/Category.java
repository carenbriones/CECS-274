import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Category {

	private String categoryName;
	private ArrayList <Question> questions;

	//creates category
	public Category (String name, File fileName) throws FileNotFoundException{
		categoryName = name;
		String line;
		Scanner fileScanner = new Scanner(fileName);
		ArrayList <String> lines = new ArrayList<String>();
		while (fileScanner.hasNextLine()){
			line = fileScanner.nextLine();
			lines.add(line);
		}
		ArrayList <Question> quests = new ArrayList <Question>();
		for (int j = 0; j < lines.size(); j+= 6){
			String question = lines.get(j);
			String answer1 = lines.get(j + 1);
			String answer2 = lines.get(j + 2);
			String answer3 = lines.get(j + 3);
			String answer4 = lines.get(j + 4);
			int solution = Integer.parseInt(lines.get(j + 5));
			Question ques = new Question(question, answer1, answer2, answer3, answer4, solution);
			quests.add(ques);
		}
		questions = quests;
	}

	/**
	 * Returns the ArrayList of questions from the category object
	 * @return ArrayList of questions
	 */
	public ArrayList <Question> getQuestions(){
		return questions;
	}

	/**
	 * Changes a given question at a given index
	 * @param ques question to be changed to
	 * @param i index of question in Category
	 */
	public void modifyQuestion(String ques, int i){
		getQuestions().get(i).setQuestion(ques);
	}

	/**
	 * Adds a question object made by the user inputting the question, answers, and solution
	 * to the original ArrayList of questions.
	 * @param questions ArrayList where the question will be added.
	 */
	public ArrayList<Question> addQuestion(Question ques){
		questions.add(ques);
		return questions;
	}

	/**
	 * Write the modified ArrayList of questions to a new text file
	 * @param questions modified ArrayList to be written to the file
	 * @return file with modified ArrayList
	 */
	public static File writeList(ArrayList <Question> questions){
		try {
			PrintWriter writer = new PrintWriter("questions.txt");
			for (int i = 0; i < questions.size(); i++){
				writer.println(questions.get(i));
			}
			writer.close();
		}catch(FileNotFoundException fnf){
			System.out.println("File was not found");
		}
		File list = new File("questions.txt");
		return list;
	}
}
