/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (https://www.swig.org).
 * Version 4.2.0
 *
 * Do not make changes to this file unless you know what you are doing - modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */


public class jvcoordinateJNI {
  public final static native double DBL_NAN_get();
  public final static native long new_Coordinate__SWIG_0();
  public final static native long new_Coordinate__SWIG_1(double jarg1, double jarg2);
  public final static native long new_Coordinate__SWIG_2(long jarg1, Coordinate jarg1_);
  public final static native void delete_Coordinate(long jarg1);
  public final static native double Coordinate_x__SWIG_0(long jarg1, Coordinate jarg1_);
  public final static native double Coordinate_y__SWIG_0(long jarg1, Coordinate jarg1_);
  public final static native boolean Coordinate_isValid(long jarg1, Coordinate jarg1_);
  public final static native double Coordinate_calcDistance(long jarg1, Coordinate jarg1_, long jarg2, Coordinate jarg2_);
  public final static native double Coordinate_calcBearing(long jarg1, Coordinate jarg1_, long jarg2, Coordinate jarg2_);
  public final static native long Coordinate_calcDestination(long jarg1, Coordinate jarg1_, double jarg2, double jarg3);
}
