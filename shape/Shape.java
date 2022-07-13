package shape;
import representation.Printable;

/**
 * <p>
 *  Abstract class for the representation of the object figure
 *  </p>
 *
 *  <p>
 *  The class contains the necessary methods for:
 *  <ul>
 *  <li> Calculate the area of a figure </li>
 *  <li> Calculate the perimeter of a figure </li>
 *  <li> Get the name of a figure </li>
 *  </ul>
 *  </p>
 *
 *  @since 10/10/21
 *  @version 1.0
 */

public abstract class Shape implements Printable
{
  /**
   * Calculate the area of a shape
   * @return area of a shape
   */
  abstract public double calculateArea();

  /**
   * Calculate the perimeter of a shape
   * @return perimeter of a shape
   */
  abstract public double calculatePerimeter();

  /**
   * Get the name of a shape
   * @return name of a shape
   */
  abstract public ShapesNames getShapeName();

  /**
   * Returns Shape Name + Sides + Perimeter + Area
   * @return Shape name + Sides + Perimeter + Area
   */
  @Override
  public String toString()
  {
    return this.toString();
  }

}
