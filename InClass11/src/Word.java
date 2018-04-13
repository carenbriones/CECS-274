/**
 * Class that allows you to create, modify, and access data members
 * of a Word object that consists of a String value of the word, and
 * the integer value indicating how many times the word occurs in a list. 
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class Word {
	
	//data members
	/** String value of the word */
	private String word;
	/** Number of times the word occurs in the BST */
	private int frequency;
	
	/**
	 * Constructs a word object starting off with a frequency of 1
	 * @param w String value of the Word object
	 */
	public Word(String w){
		word = w;
		frequency = 1;
	}
	
	/**
	 * Returns the String value of the Word object
	 * @return String value of the Word
	 */
	public String getString(){
		return word;
	}
	
	/**
	 * Returns the number of times the Word occurs
	 * @return number of occurrences of the Word
	 */
	public int getFrequency(){
		return frequency;
	}
	
	/**
	 * Increments the number of times the Word occurs
	 */
	public void addFrequency(){
		frequency++;
	}
	
	/**
	 * Compares two words using the compareTo method of the String class
	 * to determine which word comes first lexicographically
	 * @param w word to compare this word to
	 * @return integer indicating which word comes first
	 */
	public int compareTo(Word w){
		if(w.getString().compareTo(word) > 0){
			return 1;
		} else if(w.getString().compareTo(word) < 0){
			return -1;
		} else{
			return 0;
		}
	}
	
	/**
	 * Returns a String value of a Word object
	 * @return the String value of the Word object
	 */
	@Override
	public String toString(){
		String s = "";
		if (getString().length() < 8){
			s = getString() + "\t\tfrequency = " + getFrequency();
		} else{
			s = getString() + "\tfrequency = " + getFrequency();
		}
		return s;
	}
	
}
