package shape.twodshapes;
import shape.Shape;
import shape.ShapesNames;

/**
 * <p>
 *  Class for the implementation of the circle shape
 *  </p>
 *
 *  <p>
 *  The class contains the necessary methods for:
 *  <ul>
 *  <li> Initialise a circle with a given radius </li>
 *  <li> Get the area of the circle </li>
 *  <li> Obtain the perimeter of the circle </li>
 *  <li> Get the radius of the circle </li>
 *  <li> Set the radius of the circle </li>
 *  <li> Get name of the figure </li>
 *  <li> Get all the information from the figure </li>
 *  </ul>
 *  </p>
 *
 *  @since 10/10/21
 *  @version 1.0
 */

public class Circle extends Shape
{
  // 
  private ShapesNames shapeName = ShapesNames.CIRCLE;
  private double radius = 1.0;

  /**
   * Parameterised builder
   * @param radius radius of the circle
   */
  public Circle(double radius)
  {
    this.radius = radius;
  }

  /**
   * Returns area of circle
   * @return area of circle
   */
  @Override
  public double calculateArea()
  {
    return Math.PI * (this.radius * this.radius);
  }

  /**
   * Returns perimeter of circle
   * @return perimeter of circle
   */
  @Override
  public double calculatePerimeter()
  {
    return 2 * Math.PI * this.radius;
  }

  /**
   * Get the radius of the circle
   * @return radius of the circle
   */
  public double getRadius()
  {
    return this.radius;
  }

  /**
   * Set the radius of the circle
   * @param radius radio del círculo
   */
  public void setRadius(double radius)
  {
    this.radius = radius;
  }

  /**
   * Get name of the shape
   * @return name of the shape
   */
  @Override
  public ShapesNames getShapeName()
  {
    return shapeName;
  }

  /**
   * Returns Shape Name + Sides + Perimeter + Area
   * @return Shape name + Sides + Perimeter + Area
   */
  @Override
  public String toString()
  {
    return shapeName + ": " + "\nRadius is: " + radius
            + "\nCircumference is: " + calculatePerimeter()
            + "\nArea is: " + calculateArea() + "\n";
  }
}