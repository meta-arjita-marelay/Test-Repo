package shapeOfObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Screen class contains function to perform different operation on shape object
 * like addition, deletion, sorting.
 * 
 * @author Arjita
 *
 */
public class Screen {
	private List<Shape> shapes = new CopyOnWriteArrayList<Shape>();
	// maximum limit of x-axis
	private final double XMAX = 100;
	// maximum limit of y-axis
	private final double YMAX = 100;

	/**
	 * constructor to initialise private members
	 * 
	 * @param type
	 *            shape type
	 * @param point
	 *            origin point of shape
	 * @param parameters
	 *            length of different parameters of shape
	 * @return shape object of respective type
	 */
	public Shape addShape(ShapeType type, Point point, List<Double> parameters) {
		if (point.getxCoordinate() < XMAX && point.getyCoordinate() < YMAX) {
			Shape shape = ShapeFactory.createShape(type, point, parameters);
			shapes.add(shape);
			return shape;
		} else {
			throw new AssertionError("origin out of range");
		}
	}

	/**
	 * deleteShape will delete the first shape of required type from the list
	 * 
	 * @param type
	 *            type of shape object which is to be deleted
	 * @return true if it can be deleted otherwise false
	 */
	public boolean deleteShape(ShapeType type) {
		for (Shape shape : shapes) {
			if (shape.getType() == type) {
				shapes.remove(shape);
				return true;
			}
		}
		return false;
	}

	/**
	 * deleteAllSpecificShape will delete the all shapes of specific type
	 * 
	 * @param type
	 *            type of shape object which is to be deleted
	 * @return true if they can be deleted otherwise false
	 */
	public boolean deleteAllSpecificShape(ShapeType type) {
		for (Shape shape : shapes) {
			if (shape.getType() == type) {
				shapes.remove(shape);
			}
		}
		for (Shape shape : shapes) {
			if (shape.getType() == type) {
				return false;
			}
		}
		return true;
	}

	/**
	 * sortByArea will sort the shapes in ascending order according to area
	 * 
	 * @return list of shapes sorted according to area
	 */
	public List<Shape> sortByArea() {
		List<Shape> areaList = new ArrayList<Shape>(shapes);

		int n = areaList.size();
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - i - 1; j++)
				if (areaList.get(j).getArea() > areaList.get(j + 1).getArea()) {
					Shape temp = areaList.get(j);
					areaList.set(j, areaList.get(j + 1));
					areaList.set(j + 1, temp);
				}
		return areaList;
	}

	/**
	 * sortByPerimeter will sort the shapes in ascending order according to
	 * Perimeter
	 * 
	 * @return list of shapes sorted according to Perimeter
	 */
	public List<Shape> sortByPerimeter() {
		List<Shape> perimeterList = new ArrayList<Shape>(shapes);

		int size = perimeterList.size();
		for (int i = 0; i < size - 1; i++)
			for (int j = 0; j < size - i - 1; j++)
				if (perimeterList.get(j).getPerimeter() > perimeterList.get(
						j + 1).getPerimeter()) {
					Shape tempShape = perimeterList.get(j);
					perimeterList.set(j, perimeterList.get(j + 1));
					perimeterList.set(j + 1, tempShape);
				}
		return perimeterList;
	}

	/**
	 * sortByDistance will sort the shapes in ascending order according to
	 * distance
	 * 
	 * @return list of shapes sorted according to distance
	 */
	public List<Shape> sortByDistance() {
		List<Shape> distanceList = new ArrayList<Shape>(shapes);

		int size = distanceList.size();
		for (int i = 0; i < size - 1; i++)
			for (int j = 0; j < size - i - 1; j++)
				if (distanceList.get(j).getDistance() > distanceList.get(j + 1)
						.getDistance()) {
					Shape tempShape = distanceList.get(j);
					distanceList.set(j, distanceList.get(j + 1));
					distanceList.set(j + 1, tempShape);
				}
		return distanceList;
	}

	/**
	 * sortByTime will sort the shapes in ascending order according to time
	 * 
	 * @return list of shapes sorted according to time
	 */
	public List<Shape> sortByTime() {
		List<Shape> timeList = new ArrayList<Shape>(shapes);

		int size = timeList.size();
		for (int i = 0; i < size - 1; i++)
			for (int j = 0; j < size - i - 1; j++)
				if (timeList.get(j).getTimestamp()
						.after(timeList.get(j + 1).getTimestamp())) {
					Shape tempShape = timeList.get(j);
					timeList.set(j, timeList.get(j + 1));
					timeList.set(j + 1, tempShape);
				}
		return timeList;
	}

	/**
	 * shapesEnclosingPoint will return list of shapes which enclose the given
	 * point
	 * 
	 * @param point
	 *            which is to be checked if it is enclosed by shapes list
	 * @return list of shape object which enclose the given point
	 */
	public List<Shape> shapesEnclosingPoint(Point point) {
		List<Shape> listForShapes = new ArrayList<Shape>();
		for (Shape shape : shapes) {
			if (shape.isPointEnclosed(point)) {
				listForShapes.add(shape);
			}
		}
		return listForShapes;
	}

}
