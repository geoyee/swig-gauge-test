/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.2.0
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */


public class Coordinate {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected Coordinate(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Coordinate obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected static long swigRelease(Coordinate obj) {
    long ptr = 0;
    if (obj != null) {
      if (!obj.swigCMemOwn)
        throw new RuntimeException("Cannot release ownership as memory is not owned");
      ptr = obj.swigCPtr;
      obj.swigCMemOwn = false;
      obj.delete();
    }
    return ptr;
  }

  @SuppressWarnings({"deprecation", "removal"})
  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        jvcoordinateJNI.delete_Coordinate(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public Coordinate() {
    this(jvcoordinateJNI.new_Coordinate__SWIG_0(), true);
  }

  public Coordinate(double x, double y) {
    this(jvcoordinateJNI.new_Coordinate__SWIG_1(x, y), true);
  }

  public Coordinate(Coordinate coordinate) {
    this(jvcoordinateJNI.new_Coordinate__SWIG_2(Coordinate.getCPtr(coordinate), coordinate), true);
  }

  public double x() {
    return jvcoordinateJNI.Coordinate_x__SWIG_0(swigCPtr, this);
  }

  public double y() {
    return jvcoordinateJNI.Coordinate_y__SWIG_0(swigCPtr, this);
  }

  public boolean isValid() {
    return jvcoordinateJNI.Coordinate_isValid(swigCPtr, this);
  }

  public static double calcDistance(Coordinate coordinate1, Coordinate coordinate2) {
    return jvcoordinateJNI.Coordinate_calcDistance(Coordinate.getCPtr(coordinate1), coordinate1, Coordinate.getCPtr(coordinate2), coordinate2);
  }

  public static double calcBearing(Coordinate origin, Coordinate destination) {
    return jvcoordinateJNI.Coordinate_calcBearing(Coordinate.getCPtr(origin), origin, Coordinate.getCPtr(destination), destination);
  }

  public static Coordinate calcDestination(Coordinate coordinate, double distance, double bearing) {
    return new Coordinate(jvcoordinateJNI.Coordinate_calcDestination(Coordinate.getCPtr(coordinate), coordinate, distance, bearing), true);
  }

}
