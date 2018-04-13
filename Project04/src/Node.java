/**
 * Class that constructs, accesses, and modifies a Node object made
 * of a Song object and the following node.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 *
 */
public class Node {
	
	//data members
	/** Song object of the Node*/
	private Song track;
	/** Node object inside the Node */
	private Node next;
	
	/**
	 * Constructs a node consisting of a Song object
	 * and a null next node
	 * @param s song object of the node
	 */
	public Node(Song s){
		track = s;
		next = null;
	}
	
	/**
	 * Constructs a node with a consisting of a song object
	 * and a next node from the parameters
	 * @param v song object of the node
	 * @param n next node
	 */
	public Node(Song v, Node n){
		track = v;
		next = n;
	}
	
	/**
	 * Returns the next node in the LinkedList
	 * @return next node
	 */
	public Node getNext(){
		return next;
	}
	
	/**
	 * Sets the next node in the LinkedList
	 * @param n node to be set to
	 */
	public void setNext(Node n){
		next = n;
	}
	
	/**
	 * Returns the song inside of a node
	 * @return song inside the node
	 */
	public Song getValue(){
		return track;
	}
	
	/**
	 * Sets a song in the node
	 * @param v song to be set to
	 */
	public void setValue(Song s){
		track = s;
	}
}
