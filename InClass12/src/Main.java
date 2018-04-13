import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Tests the heap and node class
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class Main {

	public static void main(String[] args) {
		File file = new File("file.txt");
		Heap h = new Heap();
		try{
			Scanner fileScan = new Scanner(file);
			while (fileScan.hasNextLine()){
				String w = fileScan.nextLine();
				Node n = new Node(w);
				h.addNode(n);
			}
			fileScan.close();
		} catch (FileNotFoundException fnf){
			System.out.println("File was not found.");
		}
		h.printOrderedHeap();
	}
}