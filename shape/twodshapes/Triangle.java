package shape.twodshapes;
import shape.Shape;
import shape.ShapesNames;

/**
 * <p>
  *  Class for the implementation of the triangle shape
 *  </p>
 *
 *  <p>
 *  The class contains the necessary methods for:
 *  <ul>
 *  <li> Initialising a triangle with given sides </li>
 *  <li> Obtain the sides of the triangle </li>
 *  <li> Establish the sides of the triangle </li>
 *  <li> Obtain the area of the triangle </li>
 *  <li> Obtain the perimeter of the triangle </li>
 *  <li> Get name of the figure </li>
 *  <li> Get all the information from the figure </li>
 *  </ul>
 *  </p>
 *
 *  @since 10/10/21
 *  @version 1.0
 */


public class Triangle extends Shape
{
  // Attributes
  private ShapesNames shapeName = ShapesNames.TRIANGLE;
  private double sideA = 1.0;
  private double sideB = 1.0;
  private double sideC = 1.0;

  /**
   * Parameterised builder
   * @param sideA side A
   * @param sideB side B
   * @param sideC side C
   * @throws Exception Exception on the validity of the sides.
   */
  public Triangle(double sideA, double sideB, double sideC) throws Exception
  {
    if (!checkValidity(sideA, sideB, sideC))
      throw new Exception("Impossible lengths of the sides of the triangle.");

    this.sideA = sideA;
    this.sideB = sideB;
    this.sideC = sideC;
  }

  /**
   * Validating whether the sides of a triangle are possible
   * @param sideA side A
   * @param sideB side B
   * @param sideC side C
   * @return validity of side values
   */
  private boolean checkValidity(double sideA, double sideB, double sideC)
  {
    if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA)
      return false;
    else
      return true;
  }

  /**
   * Get side A
   * @return side A of the triangle
   */
  public double getSideA()
  {
    return this.sideA;
  }

  /**
   * Get side A
   * @return side B of the triangle
   */
  public double getSideB()
  {
    return this.sideB;
  }

  /**
   * Get side C
   * @return side C of the triangle
   */
  public double getSideC()
  {
    return this.sideC;
  }

  /**
   * Set side A
   * @param sideA side A of the triangle
   */
  public void setSideA(double sideA)
  {
    this.sideA = sideA;
  }

  /**
   * Set side B
   * @param sideB side B of the triangle
   */
  public void setSideB(double sideB)
  {
    this.sideB = sideB;
  }

  /**
   * Set side C
   * @param sideC side C of the triangle
   */
  public void setSideC(double sideC)
  {
    this.sideC = sideC;
  }

  /**
   * Obtain the area of the triangle
   * @return area of the triangle
   */
  @Override
  public double calculateArea()
  {
    double s = (sideA + sideB + sideC)/2.0; // Semiperimeter
    return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC)); // Heron area formula
  }

  /**
   * Obtain the perimeter of the triangle
   * @return perimeter of the triangle
   */
  @Override
  public double calculatePerimeter()
  {
    return sideA + sideB + sideC;
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
    return shapeName + ": " + "\nSideA is: " + sideA
            + "\nSideB is: " + sideB
            + "\nSideC is: " + sideC
            + "\nPerimeter is: " + calculatePerimeter()
            + "\nArea is: " + calculateArea() + "\n";
  }
}
