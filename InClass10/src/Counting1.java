
public class Counting1 {

	public static void main(String[] args) {
		countForwards(5);
	}
	public static void countForwards(int num){
		System.out.print(num + " ");
		if( num > 0){
			countForwards(num - 1);
		}
	}
}
