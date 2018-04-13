/**
 * Creates fraction objects along with multiple methods to
 * simulate different math functions involving fractions.
 * 
 * @author Caren Briones <carenpbriones@gmail.com>
 */
public class Fraction {
	/** numerator - top of fraction */
	private int num;
	/** denominator - bottom of fraction */
	private int den;
	
	/** Constructor
	 * @param n numerator
	 * @param d denominator
	 */
	public Fraction (int n, int d){
		num = n;
		den = d;
	}
	/**
	 * Displays a fraction
	 */
	public void printFraction(){
		System.out.print(num + "/" + den);
	}
	
	/**
	 * Adds the implicit fraction to the explicit fraction
	 * and returns the resulting fraction
	 * @param f fraction to add this fraction to
	 * @return result of adding the fractions together
	 */
	public Fraction add(Fraction f){
		int lowest;
		int divisor = 1;
		int n = 1;
		int d = 1;
		if (this.den == f.den){
			n = this.num + f.num;
			d = this.den;
		} else{
			n = this.num * f.den + f.num * this.den;
			d = this.den * f.den;
		}
		if (n < d){
			lowest = n;
		} else{
			lowest = d;
		}
		for(int i = 2; i <= lowest; i++){
			if (n % i == 0 && d % i == 0){
				divisor = i;
			}
		}
		n = n/divisor;
		d = d/divisor;
		Fraction res = new Fraction(n, d);
		return res;
	}
	
	/**
	 * Subtracts the implicit fraction from the explicit fraction
	 * and returns the resulting fraction
	 * @param f fraction to be subtracted from this fraction
	 * @return result of subtracting the fractions
	 */
	public Fraction subtract(Fraction f){
		int n = 1;
		int d = 1;
		int lowest;
		int divisor = 1;
		if (this.den == f.den){
			n = this.num - f.num;
			d = this.den;
		} else{
			n = this.num * f.den - f.num * this.den;
			d = this.den * f.den;
		}
		if (n < d){
			lowest = n;
		} else{
			lowest = d;
		}
		for(int i = 2; i <= lowest; i++){
			if (n % i == 0 && d % i == 0){
				divisor = i;
			}
		}
		n = n/divisor;
		d = d/divisor;
		Fraction res = new Fraction(n, d);
		return res;
	}
	
	/**
	 * Multiplies the implicit fraction and the explicit fraction
	 * and returns the resulting fraction
	 * @param f fraction to multiply with this fraction
	 * @return result of multiplying the fractions
	 */
	public Fraction multiply(Fraction f){
		int lowest;
		int divisor = 1;
		int n = this.num * f.num;
		int d = this.den * f.den;
		if (n < d){
			lowest = n;
		} else{
			lowest = d;
		}
		for(int i = 2; i <= lowest; i++){
			if (n % i == 0 && d % i == 0){
				divisor = i;
			}
		}
		n = n/divisor;
		d = d/divisor;
		Fraction res = new Fraction(n, d);
		
		return res;
	}
	
	/**
	 * Divides the explicit fraction from the implicit fraction
	 * and returns the resulting fraction
	 * @param f fraction to divide this fraction by
	 * @return result of dividing the fractions
	 */
	public Fraction divide (Fraction f){
		int lowest;
		int divisor = 1;
		int n = this.num * f.den;
		int d = this.den * f.num;
		if (n < d){
			lowest = n;
		} else{
			lowest = d;
		}
		for(int i = 1; i <= lowest; i++){
			if (n % i == 0 && d % i == 0){
				divisor = i;
			}
		}
		n = n/divisor;
		d = d/divisor;
		Fraction res = new Fraction(n, d);
		return res;
	}
	
	/** Returns a string of the fraction
	 */
	@Override
	public String toString(){
		String s = num + "/" + den;
		return s;
	}
	/**
	 * Compares two fractions and returns true if they are equal
	 * @param o explicit fraction to be compared
	 */
	@Override
	public boolean equals(Object o){
		if (o == this){
			return true;
		}
		if (!(o instanceof Fraction)){
			return false;
		}
		Fraction f = (Fraction) o;
		return this.num == f.num && this.den == f.den;
	}
}
