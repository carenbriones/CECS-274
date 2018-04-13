import java.util.ArrayList;

/**
 * Class that allows you to create, modify, and access data inside
 * a heap
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class Heap {
	/** ArrayList of the nodes */
	private ArrayList<Node> heap;

	/**
	 * Constructs a new heap object as an ArrayList
	 */
	public Heap(){
		heap = new ArrayList <Node> ();
	}

	/**
	 * Returns the number of nodes in the heap
	 * @return size of the heap
	 */
	public int getSize(){
		return heap.size();
	}

	/**
	 * Returns a boolean stating whether the heap is empty or not
	 * @return whether the heap is empty or not
	 */
	public boolean isEmpty(){
		return heap.isEmpty();
	}

	/**
	 * Returns the parent location of the node at the index indicated
	 * by the integer in the parameter
	 * @param i index of the node
	 * @return location of the parent of the node
	 */
	public int getPLoc(int i){
		return (i - 1) / 2;
	}

	/**
	 * Returns the left child location of the node at the index
	 * indicated by the integer in the parameter
	 * @param i index of the node
	 * @return location of the left child of the node
	 */
	public int getLCLoc(int i){
		return 2 * i + 1;
	}

	/**
	 * Returns the right child location of the node at the index
	 * indicated by the integer in the parameter
	 * @param i index of the node
	 * @return location of the right child of the node
	 */
	public int getRCLoc(int i){
		return 2 * i + 2;
	}

	/**
	 * Returns the node at the index specified by the integer
	 * in the parameter
	 * @param i index of the node
	 * @return node at the index
	 */
	public Node getNodeAt(int i){
		if(heap.get(i) == null){
			System.out.println("Item does not exist.");
			return null;
		} else{
			return heap.get(i);
		}
	}

	/**
	 * Adds the node to the heap
	 * @param n Node being added to the heap
	 */
	public void addNode(Node n){
		heap.add(null);
		int index = heap.size() - 1;
		while (index > 0 && getNodeAt(getPLoc(index)).getData().compareToIgnoreCase(n.getData()) > 0){
			heap.set(index, getNodeAt(getPLoc(index)));
			index = getPLoc(index);
		}
		heap.set(index, n);
	}
	
	/**
	 * Returns and removes the node from the heap with the minimum value; in
	 * this case, returns the node that contains the String that
	 * comes first lexicographically
	 * @return the minimum node of the heap
	 */
	public Node removeMin(){
		Node min = heap.get(0);
		int index = heap.size() - 1;
		Node last = heap.remove(index);
		if (index > 0){
			heap.set(0, last);
			Node root = heap.get(0);
			int end = heap.size() - 1;
			index = 0;
			boolean done = false;
			while (!done){
				if (getLCLoc(index) <= end){
					//left exists
					Node child = getNodeAt(getLCLoc(index));
					int childLoc = getLCLoc(index);
					if(getRCLoc(index) <= end){
						//right exists
						if (getNodeAt(getRCLoc(index))
								.getData().compareToIgnoreCase(child.getData()) < 0){
							child = getNodeAt(getRCLoc(index));
							childLoc = getRCLoc(index);
						}
					}
					if (child.getData().compareToIgnoreCase(root.getData()) < 0){
						heap.set(index, child);
						index = childLoc;
					} else{
						done = true;
					}
				} else{
					//no children
					done = true;
				}
			}
			heap.set(index, root);
		}
		return min;
	}

	/**
	 * Prints the words in the heap
	 */
	public void printHeap(){
		for (int i = 0; i < heap.size(); i++){
			System.out.print(heap.get(i).getData() + " ");
		}
		System.out.println();
	}
	
	/**
	 * Prints the words in the heap from first to last lexicographically
	 */
	public void printOrderedHeap(){
		while (heap.size() != 0){
			System.out.print(removeMin().getData() + "\n");
		}
		System.out.println();
	}
}
