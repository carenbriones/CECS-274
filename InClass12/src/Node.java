/**
 * Class that allows you to create, modify, and access a node and
 * its data members
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class Node {
	/** String value of the node */
	private String word;
	
	/**
	 * Constructs a Node object with a String data member
	 * @param s String stored in the node
	 */
	public Node(String s){
		word = s;
	}
	
	/**
	 * Returns the string value of a node
	 * @return string stored in the node
	 */
	public String getData(){
		return word;
	}
	
	/**
	 * Changes the string value stored in a word to the string
	 * in the parameters
	 * @param s string value to be changed to
	 */
	public void setData(String s){
		word = s;
	}
}
