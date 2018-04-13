
public class Counting2 {

	public static void main(String[] args) {
		countForwards(5);
	}
	public static void countForwards( int num ) {
		if( num > 0 ) {
			countForwards(num--);
		}
		System.out.print(num + " ");
	}

}
