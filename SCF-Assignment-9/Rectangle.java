package shapeOfObject;

import java.util.Date;
import java.util.List;

/**
 * Rectangle contains properties of circle and it calculates the area,
 * perimeter, and checks if some point is enclosed by Rectangle.
 * 
 * @author Arjita
 *
 */
public class Rectangle implements Shape {
	private Point point;// origin point
	private double length, width;// length and width of rectangle
	private Date timestamp;// timestamp will store time when the object will be
							// created
	private ShapeType type;// type of shape

	/**
	 * constructor to initialise the private members
	 * 
	 * @param point
	 *            origin point of shape
	 * @param parameters
	 *            list of parameters which will contain length and width of
	 *            rectangle
	 */
	Rectangle(Point point, List<Double> parameters) {
		this.point = point;
		this.timestamp = new Date();
		this.type = ShapeType.RECTANGLE;
		this.length = parameters.get(0);
		this.width = parameters.get(1);
	}

	@Override
	public ShapeType getType() {
		return type;
	}

	@Override
	public Date getTimestamp() {
		return timestamp;
	}

	@Override
	public double getArea() {
		return length * width;
	}

	@Override
	public double getPerimeter() {
		return 2 * (length + width);
	}

	@Override
	public Point getOrigin() {
		return point;
	}

	@Override
	public boolean isPointEnclosed(Point pointCheck) {
		double xCheck, yCheck, xCoord, yCoord;
		xCheck = pointCheck.getxCoordinate();
		yCheck = pointCheck.getyCoordinate();
		xCoord = point.getxCoordinate();
		yCoord = point.getyCoordinate();
		if ((xCoord + length) > xCheck && xCheck > xCoord
				&& (yCoord + width) > yCheck && yCheck > yCoord) {
			return true;
		}
		return false;
	}

	@Override
	public double getDistance() {
		double dist = point.getxCoordinate() * point.getxCoordinate()
				+ point.getyCoordinate() * point.getyCoordinate();
		return Math.sqrt(dist);
	}

}
