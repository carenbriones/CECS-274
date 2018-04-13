/**
 * Creates and allows you to modify and access node objects
 * made up of circle objects.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class Node {

	//data members
	/** Circle object inside the Node */
	private Circle shape;
	/** Node object inside the Node */
	private Node next;

	/**
	 * Constructs a Node object consisting of the Circle object
	 * in the parameters and a null next Node
	 * @param s Circle data member
	 */
	public Node(Circle s){
		shape = s;
		next = null;
	}

	/**
	 * Constructs a Node object consisting of the Circle object
	 * and the Node in the parameters
	 * @param v Circle data member
	 * @param n Node data member
	 */
	public Node(Circle v, Node n){
		shape = v;
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
	 * Sets the next node
	 * @param n node the set the next node to
	 */
	public void setNext(Node n){
		next = n;
	}

	/**
	 * Returns the Circle object in a node
	 * @return Circle inside the node
	 */
	public Circle getValue(){
		return shape;
	}

	/**
	 * Sets the Circle data member in a node
	 * @param s Circle to set the node to
	 */
	public void setValue(Circle s){
		shape = s;
	}
}
