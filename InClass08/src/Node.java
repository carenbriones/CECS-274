/**
 * Class that creates, accesses, and modifies information in a node,
 * which consists of a string value and the node after it.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class Node {
	
	//data members
	/** String stored in the Node */
	private String value;
	/** Next Node object */
	private Node next;
	
	/**
	 * Constructs a node consisting of the string value in the parameter
	 * and a null next node
	 * @param v string data member of the node
	 */
	public Node(String v){
		value = v;
		next = null;
	}
	
	/**
	 * Constructs a node consisting of the string value and the
	 * node in the parameter
	 * @param v string data member of the node
	 * @param n the following node
	 */
	public Node(String v, Node n){
		value = v;
		next = n;
	}
	
	/**
	 * Returns the next node
	 * @return next node
	 */
	public Node getNext(){
		return next;
	}
	
	/**
	 * Changes the next node to the node in the parameters
	 * @param n next node
	 */
	public void setNext(Node n){
		next = n;
	}
	
	/**
	 * Returns the string value in the node
	 * @return string value
	 */
	public String getValue(){
		return value;
	}
	
	/**
	 * Changes the string value in a node to the string in the parameters
	 * @param v string value
	 */
	public void setValue(String v){
		value = v;
	}
}
