/**
 * Class that allows you to create, modify, access data members, and
 * search through a binary search tree that takes in Word objects.
 * @author Caren Briones <carenpbriones@gmail.com>
 *
 */
public class BST {

	//Data members
	/** Root node of the binary search tree */
	private Node root;

	/**
	 * Constructs a binary search tree with a null root node
	 */
	public BST() {
		root = null;
	}

	/**
	 * Returns whether the binary search tree is empty or not
	 * @return boolean whether the binary search tree is empty or not
	 */
	public boolean isEmpty(){
		return root == null;
	}

	/**
	 * Adds a new node to the tree
	 * @param w word of the node to add
	 */
	public void add(Word w) {
		root = add(w, root);
	}
	/**
	 * Helper function that determines where to add the node to
	 * @param w word of the node
	 * @param tree binary search tree
	 * @return the altered tree
	 */
	private Node add(Word w, Node tree) {
		if(tree == null){
			return new Node(w);
		}else{
			if( tree.getWord().compareTo(w) < 0){
				tree.setLeft(add(w, tree.getLeft()));
			}else if(tree.getWord().compareTo(w) > 0){
				tree.setRight(add(w, tree.getRight()));
			}else{
				tree.getWord().addFrequency();
			}
		}
		return tree;
	}

	/**
	 * Searches for a Word in the tree
	 * @param w word being searched for
	 */
	public Node search(Word w) {
		if (root == null) {
			System.out.println("No items to search");
			return null;
		} else {
			return search(w, root);
		}
	}
	/**
	 * Helper function to determine whether to search to the right or
	 * left of the current node
	 * @param w word being searched for
	 * @param tree current node being examined
	 */
	private Node search(Word w, Node n) {
		if (w.getString() == n.getWord().getString()) {
			return n;
		}
		if (n.getWord().compareTo(w) < 0) {
			if (n.getLeft() == null) {
				System.out.println("Item Not Found");
				return null;
			} else {
				return search(w, n.getLeft());
			}
		} else if (n.getWord().compareTo(w) > 0) {
			if (n.getRight() == null) {
				System.out.println("Item Not Found");
				return null;
			} else {
				return search(w, n.getRight());
			}
		} else{
			return n;
		}
	}

	/**
	 * Prints the tree in order
	 */
	public void printBST() {
		if (isEmpty()) {
			System.out.println("No items to print");
		} else {
			printBST(root);
		}
	}
	/**
	 * Helper function that prints the tree out in the correct order
	 * @param n node being printed
	 */
	private void printBST(Node n) {
		//go down left tree
		if (n.getLeft() != null) {
			printBST(n.getLeft());
		}
		//go down right tree
		System.out.print(n.getWord() + " ");
		System.out.println();
		if (n.getRight() != null) {
			printBST(n.getRight());
		}
	}
}
