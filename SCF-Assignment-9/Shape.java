package shapeOfObject;

import java.util.Date;

public interface Shape {
	/**
	 * getArea will calculate the area of required shape
	 * 
	 * @return area of shape
	 */
	public double getArea();

	/**
	 * getPerimeter will calculate the perimeter of shape
	 * 
	 * @return perimeter of shape
	 */
	public double getPerimeter();

	/**
	 * getOrigin will return the leftmost point of shape
	 * 
	 * @return leftmost point of shape
	 */
	public Point getOrigin();

	/**
	 * isPointEnclosed will check the point if it is enclosed in shape
	 * 
	 * @param point
	 *            which is to be checked if it is enclosed by shape
	 * @return true if point is enclosed by shape otherwise false
	 */
	public boolean isPointEnclosed(Point point);

	/**
	 * getType will return the type of shape i.e., rectangle, square, triangle,
	 * circle.
	 * 
	 * @return type of shape
	 */
	public ShapeType getType();

	/**
	 * getDistance will calculate the distance between origin of screen and
	 * origin of shape
	 * 
	 * @return distance between origin of screen and shape
	 */
	public double getDistance();

	/**
	 * getTimestamp will return the time at which object of shape is created
	 * 
	 * @return time at which object of shape is created
	 */
	public Date getTimestamp();
}
