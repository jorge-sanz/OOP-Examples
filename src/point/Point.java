package point;

/**
 * Point is a class which represents a point in 2 dimensions.
 *
 * @author Jorge Sanz Perez
 */
public class Point {
	private double x, y;
	
	/**
	 * Initializes a point with the specified values of x and y coordinates.
	 * 
	 * @param x		x coordinate
	 * @param y		y coordinate
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Returns the x coordinate.
	 * 
	 * @return x	x coordinate
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Sets the x coordinate.
	 * 
	 * @param x		x coordinate
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * Returns the y coordinate.
	 * 
	 * @return y	y coordinate
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * Sets the y coordinate.
	 * 
	 * @param y		y coordinate
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * Moves the point to another position.
	 * 
	 * @param x
	 * @param y
	 */
	public void move(double x, double y) {
		setX(getX() + x);
		setY(getY() + y);
	}
	
	/**
	 * Returns true if the second point is equal to (this)
	 * 
	 * @param secondPoint	point to compare
	 * @return return true 
	 */
	public boolean equals(Point secondPoint) {
		boolean isEqual = false;
		
		if (getX() == secondPoint.getX() && getY() == secondPoint.getY()) {
			isEqual = true;
		}
		
		return isEqual;
	}
	
	/**
	 * Returns the distance between (this) and the second point.
	 * 
	 * @param secondPoint
	 */
	public double distanceTo(Point secondPoint) {
		double distance;
		
		distance = Math.sqrt(Math.pow(secondPoint.getX() - getX(), 2)
				+ Math.pow(secondPoint.getY() - getY(), 2));
		
		return distance;
	}
}
