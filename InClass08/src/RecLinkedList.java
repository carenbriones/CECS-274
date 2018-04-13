/**
 * Class that creates a Linked List using recursive methods that
 * allow the user to add, remove, and access nodes in the list.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class RecLinkedList {
	
	//data members
	/** First Node */
	private Node first;

	/**
	 * Creates a new recursive linked list with a null first node
	 */
	public RecLinkedList(){
		first = null;
	}

	/**
	 * Returns whether the first Node is empty or not
	 * @return boolean whether the first Node is empty or not
	 */
	public boolean isEmpty(){
		return first == null;
	}

	/**
	 * Returns the size of the linked list
	 * @return size of the linked list
	 */
	public int size() {
		return size(first);
	}
	/**
	 * Helper function that iterates through the linked list to see
	 * if the nodes are filled until the next node is null
	 * @param list Node being checked
	 * @return size of the linked list
	 */
	private int size(Node list){
		if (list == null){
			return 0;
		} else{
			return size(list.getNext()) + 1;
		}
	}

	/**
	 * Returns the Node at the given index
	 * @param i index of the desired Node
	 * @return Node at the desired index
	 */
	public Node get(int i){
		return get(i, 0, first);
	}
	/**
	 * Helper function that iterates through the linked list until
	 * it is at the desired index to get the desired Node
	 * @param i index number
	 * @param count iterator
	 * @param list Node being checked
	 * @return Node at the desired index
	 */
	private Node get(int i, int count, Node list){
		if (list == null){
			return null;
		} else if (count == i){
			return list;
		} else{
			return get(i, count + 1, list.getNext());
		}
	}

	/**
	 * Removes a node from the index indicated by the parameter
	 * @param i index of the node to be removed
	 * @return the removed node
	 */
	public Node remove(int i){
		return remove(i, 0, first);
	}
	/**
	 * Helper function that iterates through the linked list until it
	 * hits a base case at either the end of the list or the
	 * node at the specified index
	 * @param i index of the node to be removed
	 * @param count iterator
	 * @param list node being iterated through
	 * @return the removed node or null if the index is out of bounds
	 */
	private Node remove(int i, int count, Node list){
		if (list == null){
			return null;
		} else if (i == 0){
			return list;
		} else if (count + 1 == i){
			Node n = list.getNext();
			if (list.getNext() != null){
				list.setNext(list.getNext().getNext());
			}
			return n;
		} else{
			return remove(i, count + 1, list.getNext());
		}
	}
	
	/**
	 * Removes a desired string from a linked list
	 * @param s string of node to be removed
	 * @return the removed node or null if the String is invalid
	 */
	public Node remove(String s){
		if (first == null){
			return null;
		} else {
			return remove(s, first, null);
		}
	}
	/**
	 * Helper function that iterates through the linked list,
	 * checks if the current Node's string value is equal to the
	 * desired string; if not, it continues to move through the linked
	 * list until it gets to the matching string, and removes that node
	 * @param s string of node to be removed
	 * @param n node being checked
	 * @param prev the node that referenced to the removed node
	 * @return the removed node
	 */
	private Node remove(String s, Node n, Node prev){
		if (s.equals(n.getValue())){
			if (prev == null){
				first = n.getNext();
			}
			prev.setNext(n.getNext());
			return n;
		} else if (n.getNext() == null){
			Node m = new Node(null);
			return m;
		} else{
			return remove(s, n.getNext(), n);
		}
	}

	/**
	 * Adds a string to the end of a linked list
	 * @param s string to be added to the list
	 */
	public void add (String s){
		first = add(s, first);
	}
	/**
	 * Helper function that iterates through a linked list to add
	 * a string at the very end
	 * @param s string to be added
	 * @param list node being iterated through
	 * @return the added Node
	 */
	private Node add(String s, Node list){
		if (list == null){
			return new Node(s);
		} else{
			list.setNext(add(s, list.getNext()));
			return list;
		}
	}

	/**
	 * Adds a string to the desired index indicated by the parameters
	 * @param s string to be added
	 * @param i index where the string will be added
	 */
	public void add(String s, int i){
		if (i < 0 || i > this.size()){
			System.out.println("Index out of bounds.");
		} else {
			add(s, i, first);
		}
	}
	/**
	 * Helper function that iterates through the linked list, and
	 * stops when it gets to the desired index, adding the desired
	 * string to that spot
	 * @param s string to be added
	 * @param i index where the string will be added
	 * @param n node being iterated through
	 */
	private void add(String s, int i, Node n){
		if (i == 1){
			n.setNext(new Node(s, n.getNext()));
		} else{
			add(s, i - 1, n.getNext());
		}
	}
	
	/**
	 * Converts a linked list to a string value to be printed out
	 * @return returns the String value for the linked list
	 */
	@Override
	public String toString(){
		String s = "";
		Node n = first;
		return toString(s, n);
	}
	/**
	 * Helper function that adds each node value to a string to be
	 * printed out
	 * @param s string to be added to
	 * @param n node to be added to the string
	 * @return the string of all of the node values in the list
	 */
	private String toString(String s, Node n){
		if (n == null){
			return s;
		}
		s = s + n.getValue();
		return toString(s, n.getNext());
	}
}