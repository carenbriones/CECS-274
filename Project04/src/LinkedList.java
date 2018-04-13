/**
 * Class that constructs, accesses, and modifies a linked list of nodes.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class LinkedList {

	//data members
	/** First node in the list */
	private Node first;
	/** Last node in the list */
	private Node last;

	/**
	 * Creates the linked list with a null first and last node
	 */
	public LinkedList(){
		first = null;
		last = null;
	}

	/**
	 * Returns whether the list is empty or not
	 * @return boolean whether the list is empty or not
	 */
	public boolean isEmpty(){
		return first == null;
	}

	/**
	 * Returns the size of the list
	 * @return size of the list
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
	 * Returns the node at the specified index
	 * @param i specified index
	 * @return node at the specified index
	 */
	public Node get(int i){
		Node prev = first;
		for (int j = 1; j <= i; j++){
			prev = prev.getNext();
		}
		return prev;
	}

	/**
	 * Returns the list as a string of all of the nodes inside of it
	 * @return the list as a string
	 */
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
	 * Adds a song at the end of the list
	 * @param s song to be added
	 */
	public void add(Song s){
		if (isEmpty()){
			first = new Node(s);
			last = first;
		} else{
			Node n = new Node(s);
			last.setNext(n);
			last = n;
		}
	}

	public void add(Song s, int i){
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
	private void add(Song s, int i, Node n){
		if (i == 1){
			n.setNext(new Node(s, n.getNext()));
		} else{
			add(s, i - 1, n.getNext());
		}
	}
	/**
	 * Searches for whether a song exists or not in the list by searching
	 * for the song by its title
	 * @param t song title
	 * @return song that was found or null
	 */
	public Song searchTitle(String t){
		Song r = null;
		Node n = first;
		while (n.getNext() != null){
			n = n.getNext();
			if (n.getValue().getTitle().equalsIgnoreCase(t)){
				r = n.getValue();
			} 
		}
		return r;
	}

	/**
	 * Searches through the list of songs for a song by the 
	 * artist from the parameters.
	 * @param a artist to search for
	 * @return song that was found or null
	 */
	public Song searchArtist(String a){
		Song r = null;
		Node n = first;
		while (n.getNext() != null){
			n = n.getNext();
			if (n.getValue().getArtist().equalsIgnoreCase(a)){
				r = n.getValue();
			} 
		}
		return r;
	}

	/**
	 * Prints out the song at the index from the parameters
	 * @param i index of the song
	 * @return song that was found or null
	 */
	public Song searchIndex(int i){
		Song r = null;
		Node n = first;
		int count = 0;
		if (i > size()){
			System.out.println("Index out of bounds");
		}
		while (n.getNext() != null){
			count++;
			n = n.getNext();
			if (count == i){
				r = n.getValue();
			}
		}
		return r;
	}

	/**
	 * Searches through a list of songs for a song from the
	 * album in the parameters
	 * @param a album to search for
	 * @return song that was found or null
	 */
	public Song searchAlbum(String a){
		Node n = first;
		Song r = null;
		while (n.getNext() != null){
			n = n.getNext();
			if (n.getValue().getAlbum().equalsIgnoreCase(a)){
				r = n.getValue();
			}
		}
		return r;
	}

	/**
	 * Removes a song by the title specified in the parameters
	 * @param t title of the song
	 */
	public void removeTitle(String t){
		Node beg = first;
		Node end = null;
		while (beg.getNext() != null){
			end = beg;
			beg = beg.getNext();
			if(beg.getValue().getTitle().equalsIgnoreCase(t)){
				end.setNext(beg.getNext());
				System.out.println("Song was deleted.");
			}
		}
	}

	/**
	 * Removes a song at the specified index
	 * @param i index of the song
	 */
	public void removeIndex(int i){
		Node beg = first;
		Node end = null;
		int counter = 0;
		if (i > size()){
			System.out.println("Index is out of bounds.");
		}
		while (beg.getNext() != null){
			counter++;
			end = beg;
			beg = beg.getNext();
			if (counter == i){
				end.setNext(beg.getNext());
			}
		}
	}

	/**
	 * Uses the bubble sort method to sort the list lexicographically
	 * by title.
	 */
	public void sortTitle(){
		boolean swapped = false;
		do{
			swapped = false;
			for (int i = 0; i < size() - 1; i++){
				if (this.get(i).getValue().getTitle().compareTo(this.get(i+1).getValue().getTitle()) > 0){
					Node swap = this.get(i);
					this.removeIndex(i);
					this.add(swap.getValue(), i+1);
					swapped = true;
				}
			}
		} while (swapped);
	}
	
	/**
	 * Uses the bubble sort method to sort the list lexicographically
	 * by album
	 */
	public void sortAlbum(){
		boolean swapped = false;
		do{
			swapped = false;
			for (int i = 0; i < size() - 1; i++){
				if (this.get(i).getValue().getAlbum().compareTo(this.get(i+1).getValue().getAlbum()) > 0){
					Node swap = this.get(i);
					this.removeIndex(i);
					this.add(swap.getValue(), i+1);
					swapped = true;
				}
			}
		} while (swapped);
	}
	
	/**
	 * Uses the bubble sort method to sort the list lexicographically
	 * by artist
	 */
	public void sortArtist(){
		boolean swapped = false;
		do{
			swapped = false;
			for (int i = 0; i < size() - 1; i++){
				if (this.get(i).getValue().getArtist().compareTo(this.get(i+1).getValue().getArtist()) > 0){
					Node swap = this.get(i);
					this.removeIndex(i);
					this.add(swap.getValue(), i+1);
					swapped = true;
				}
			}
		} while (swapped);
	}
}
