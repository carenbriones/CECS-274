
public class Question {

	private String question;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private int solution;

	//Question constructor
	public Question (String q, String ans1, String ans2, String ans3, String ans4, int sol){
		question = q;
		answer1 = ans1;
		answer2 = ans2;
		answer3 = ans3;
		answer4 = ans4;
		solution = sol;
	}

	/**
	 * Returns the question at the specified index
	 * @return question at index number
	 */
	public void getFullQuestion(){
		System.out.println(question);
		System.out.println(answer1);
		System.out.println(answer2);
		System.out.println(answer3);
		System.out.println(answer4);
	}
	
	/**
	 * Returns the question of a Question object
	 * @return question of a Question object
	 */
	public String getQuestion(){
		return question;
	}

	/**
	 * Returns the solution of the question
	 * @return the answer the user requests
	 */
	public int getSolution(){
		return solution;
	}

	/**
	 * Sets a Question object's question
	 */
	public void setQuestion(String ques){
		question = ques;
	}

	@Override
	public String toString(){
		String q = question;
		return q;
	}
}
