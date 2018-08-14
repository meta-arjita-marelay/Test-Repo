package shapeOfObject;

import java.util.List;

/**
 * factory class of shape class to create object according to type of shape
 * 
 * @author Arjita
 *
 */
public class ShapeFactory {
	public static Shape createShape(ShapeType type, Point point,
			List<Double> parameters) {
		Shape shape = null;
		switch (type) {
		case CIRCLE:
			shape = new Circle(point, parameters);
			break;
		case RECTANGLE:
			shape = new Rectangle(point, parameters);
			break;
		case SQUARE:
			shape = new Square(point, parameters);
			break;
		case TRIANGLE:
			shape = new Triangle(point, parameters);
			break;
		default:
			throw new AssertionError("invalid shape type");
		}
		return shape;
	}
}
