/**
 * Testbench for the LinkedList, Node, and Circle classes
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class LinkedListCircles {
	public static void main( String[] args ){
		LinkedList list = new LinkedList();

		//adds new circle to list
		Circle c1 = new Circle(3, 4, 2);
		list.add(c1);

		//adds new circle to list
		Circle c2 = new Circle(6, 3, 4);
		list.add(c2);

		//adds new circle to list
		Circle c3 = new Circle(0, 0, 3);
		list.add(c3);

		//tests out functions of the classes
		System.out.println(list);
		System.out.println(list.get(1).getValue());
		System.out.println(list.size());
	}
}
