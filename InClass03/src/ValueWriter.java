import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;


public class ValueWriter {

	public static void main(String[] args) {

		//Random generator to create 100 random integers
		Random integersGenerator = new Random();
		try {
			PrintWriter writer = new PrintWriter("numbers.txt");
			for (int i = 0; i < 100; i++){
				int number = integersGenerator.nextInt(101);
				writer.println(number);
			}
			writer.close();
		}catch(FileNotFoundException fnf){
			System.out.println("File was not found");
		}
	}
}
