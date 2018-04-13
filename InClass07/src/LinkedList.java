/**
 * Creates and allows you to modify and access data in
 * a Linked List of nodes.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class LinkedList {

	//data members
	/** First node of the Linked List */
	private Node first;
	/** Last node of the Linked List */
	private Node last;

	/**
	 * Constructs a Linked List with a null first and last node
	 */
	public LinkedList(){
		first = null;
		last = null;
	}

	/**
	 * Returns whether the node is empty
	 * @return whether the node is empty or not
	 */
	public boolean isEmpty(){
		return first == null;
	}

	/**
	 * Returns the size of the LinkedList
	 * @return size of the LinkedList
	 */
	public int size(){
		int count = 0;
		Node p = first;
		while (p != null){
			count++;
			p = p.getNext();
		}
		return count;
	}

	/**
	 * Returns the Node at the specified index
	 * @param i index of Node to get
	 * @return Node at the specified index
	 */
	public Node get(int i){
		Node prev = first;
		for (int j = 1; j <= i; j++){
			prev = prev.getNext();
		}
		return prev;
	}

	/**
	 * Converts a Node into a string
	 * @return Node converted to a string
	 */
	@Override
	public String toString(){
		String str = "";
		Node n = first;
		while (n != null){
			str = str + n.getValue();
			n = n.getNext();
		}
		return str;
	}

	/**
	 * Adds a Node to the end of the LinkedList
	 * @param s Circle to add
	 */
	public void add(Circle s){
		if (isEmpty()){
			first = new Node(s);
			last = first;
		} else{
			Node n = new Node(s);
			last.setNext(n);
			last = n;
		}
	}
}