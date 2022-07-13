package shape.twodshapes;
import shape.Shape;
import shape.ShapesNames;

/**
 * <p>
 *  Class for the implementation of the square shape
 *  </p>
 *
 *  <p>
 *  The class contains the necessary methods for:
 *  <ul>
 *  <li> Initialise a square with a given side </li>
 *  <li> Obtain the side of the square </li>
 *  <li> Set the side of the square </li>
 *  <li> Obtain the area of the square </li>
 *  <li> Obtain the perimeter of the square </li>
 *  <li> Get the name of the figure </li>
 *  <li> Get all the information from the figure </li>
 *  </ul>
 *  </p>
 *
 *  @since 10/10/21
 *  @version 1.0
 */

public class Square extends Shape
{
  // Attributes
  private ShapesNames shapeName = ShapesNames.SQUARE;
  private double side = 1.0;

  /**
   * Parameterised builder
   * @param side side of the square
   */
  public Square(double side)
  {
    this.side = side;
  }

  /**
   * Obtain the side of the square
   * @return side of the square
   */
  public double getSide()
  {
    return this.side;
  }

  /**
   * Set the side of the square
   * @param side side of the square
   */
  public void setSide(double side)
  {
    this.side = side;
  }

  /**
   * Obtain the area of the square
   * @return area of the square
   */
  @Override
  public double calculateArea()
  {
    return this.side * this.side;
  }

  /**
   * Obtain the perimeter of the square
   * @return perimeter of the square
   */
  @Override
  public double calculatePerimeter()
  {
    return 4 * this.side;
  }

  /**
   * Obtain the name of the shape
   * @return name of the shape
   */
  @Override
  public ShapesNames getShapeName()
  {
    return shapeName;
  }

  /**
   * Returns Shape Name + Sides + Perimeter + Area
   * @return Shape Name + Sides + Perimeter + Area
   */
  @Override
  public String toString()
  {
    return shapeName + ": " + "\nSide length is: " + side
            + "\nPerimeter is: " + calculatePerimeter()
            + "\nArea is: " + calculateArea() + "\n";
  }

}
