/**
 * Creates and allows you to modify a circle object
 * with data members x-coordinate, y-coordinate, and radius length.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class Circle {

	//data members
	/** x-coordinate of the center of the Circle */
	private int x;  		
	/** y-coordinate of the center of the Circle */
	private int y;
	/** length of the radius of the Circle */
	private int radius;		

	/**
	 * Constructs a Circle object with an x and y value, and a radius length
	 * @param xVal x coordinate
	 * @param yVal y coordinate
	 * @param r radius length
	 */
	public Circle(int xVal, int yVal, int r){
		x = xVal;
		y = yVal;
		radius = r;
	}

	/**
	 * Returns the x coordinate of the Circle
	 * @return x coordinate
	 */
	public int getX(){
		return x;
	}

	/**
	 * Returns the y coordinate of the Circle
	 * @return y coordinate
	 */
	public int getY(){
		return y;
	}

	/**
	 * Returns the radius length of the Circle
	 * @return radius length
	 */
	public int getRadius(){
		return radius;
	}

	/**
	 * Converts a Circle object to a string
	 * @return string the object is converted to
	 */
	@Override
	public String toString(){
		String s = "(" + x + ", " + y + ", " + radius + ") ";
		return s;
	}
}
