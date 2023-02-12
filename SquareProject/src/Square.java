/**
 * Class Square 
 * models a Geometric square
 * @author Misha R
 */
public class Square {
	// instant varibles .. a.k.a fields
	private double sideLength;

	// constructor
	public Square() {
		sideLength = 1.0;
	}

	public Square(double sideVal) {
		if (sideVal <= 0) {
			throw new IllegalArgumentException("side length must be positive!");
		} else
			sideLength = sideVal;
	}

	// accessor method
	public double getSideLength() {
		return sideLength;
	}

	// modifier method
	public void setSideLength(double sideVal) {
		sideLength = sideVal;
	} 
	
	public double getArea() { 
		return (sideLength*sideLength);
	} 
	
	public double getDiagonalLength() { 
		return (Math.sqrt(2)*sideLength);
	}
	
	public boolean isLarger(Square sq) {
		  return this.sideLength > sq.sideLength;

		}

	public String toString() {

		return "Square with side: " + sideLength;
	}
}
