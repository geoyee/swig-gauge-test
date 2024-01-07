#pragma once

#ifndef COORDINATE_H
#define COORDINATE_H

#include <iostream>
#include <limits>

const double DBL_NAN = std::numeric_limits<double>::quiet_NaN();

class Coordinate {
public:
  Coordinate();
  Coordinate(double x, double y);
  Coordinate(const Coordinate &coordinate);
  Coordinate(Coordinate &&coordinate);
  ~Coordinate();

  Coordinate &operator=(const Coordinate &coordinate);
  bool operator==(const Coordinate &coordinate) const;
  friend std::ostream &operator<<(std::ostream &out,
                                  const Coordinate &coordinate);

  double x() const;
  double y() const;
  double &x();
  double &y();
  bool isValid() const;

  static double calcDistance(const Coordinate &coordinate1,
                             const Coordinate &coordinate2);
  static double calcBearing(const Coordinate &origin,
                            const Coordinate &destination);
  static Coordinate calcDestination(const Coordinate &coordinate,
                                    double distance, double bearing);

private:
  double _x = DBL_NAN, _y = DBL_NAN;
};

#endif // COORDINATE_H