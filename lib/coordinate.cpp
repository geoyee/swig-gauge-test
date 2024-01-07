#include "coordinate.h"
#include <cmath>
#include <iostream>

#define M_PI 3.14159265358979323846

Coordinate::Coordinate() : _x(DBL_NAN), _y(DBL_NAN) {}

Coordinate::Coordinate(double x, double y) : _x(x), _y(y) {}

Coordinate::Coordinate(const Coordinate &coordinate)
    : _x(coordinate._x), _y(coordinate._y) {}

Coordinate::Coordinate(Coordinate &&coordinate)
    : _x(std::move(coordinate._x)), _y(std::move(coordinate._y)) {}

Coordinate::~Coordinate() {}

Coordinate &Coordinate::operator=(const Coordinate &coordinate)
{
  _x = coordinate._x;
  _y = coordinate._y;
  return *this;
}

bool Coordinate::operator==(const Coordinate &coordinate) const
{
  return _x == coordinate._x && _y == coordinate._y;
}

std::ostream &operator<<(std::ostream &out, const Coordinate &coordinate)
{
  out << "(" << coordinate._x << ", " << coordinate._y << ")";
  return out;
}

double Coordinate::x() const { return _x; }

double Coordinate::y() const { return _y; }

double &Coordinate::x() { return _x; }

double &Coordinate::y() { return _y; }

bool Coordinate::isValid() const { return _x != DBL_NAN && _y != DBL_NAN; }

double Coordinate::calcDistance(const Coordinate &coordinate1,
                                const Coordinate &coordinate2)
{
  if (!coordinate1.isValid() || !coordinate2.isValid())
  {
    return DBL_NAN;
  }
  double distance = std::hypot(coordinate1._x - coordinate2._x,
                               coordinate1._y - coordinate2._y);
  return distance;
}

double Coordinate::calcBearing(const Coordinate &origin,
                               const Coordinate &destination)
{
  if (!origin.isValid() || !destination.isValid())
  {
    return DBL_NAN;
  }
  double angle = 0.0;
  double dx = destination._x - origin._x;
  double dy = destination._y - origin._y;
  if (dx == 0 && dy > 0)
  {
    angle = 0;
  }
  else if (dx == 0 && dy < 0)
  {
    angle = 180;
  }
  else if (dy == 0 && dx > 0)
  {
    angle = 90;
  }
  else if (dy == 0 && dx < 0)
  {
    angle = 270;
  }
  angle = atan2(dx, dy) * 180.0 / M_PI;
  if (dx > 0 && dy < 0)
  {
    angle = 180.0 - angle;
  }
  else if (dx < 0 && dy < 0)
  {
    angle = 180 + angle;
  }
  else if (dx < 0 && dy > 0)
  {
    angle = 360 - angle;
  }
  return angle;
}

Coordinate Coordinate::calcDestination(const Coordinate &coordinate,
                                       double distance, double bearing)
{
  if (!coordinate.isValid() || distance == DBL_NAN || bearing == DBL_NAN)
  {
    return Coordinate();
  }
  double angle = bearing * M_PI / 180.0;
  double dx = distance * sin(angle);
  double dy = distance * cos(angle);
  return Coordinate(coordinate._x + dx, coordinate._y + dy);
}
