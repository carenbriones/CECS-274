/**
 * Testbench that tests the RecLinkedList class's methods
 */
public class RecursiveLinkedList {
	public static void main(String[] args) {
		RecLinkedList list = new RecLinkedList();
		list.add("A");
		list.add("B");
		list.add("D");
		list.add("C", 2);
		list.add("E", 4);
		list.add("G", 6);  //this should be invalid
		
		System.out.println(list);
		
		System.out.println(list.remove(1).getValue());
		System.out.println(list.remove("D").getValue());
		System.out.println(list.remove("G").getValue());
		
		System.out.println(list.size());
		System.out.println(list);
	}
}
