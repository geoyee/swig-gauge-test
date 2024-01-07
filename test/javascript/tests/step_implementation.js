/* globals gauge*/

"use strict";

var jscoordinate = require("gauge_test/test/javascript/libs/build/Release/jscoordinate");
// console.log(jscoordinate);
var assert = require("assert");

step("创建一个x为<x>，y为<y>的坐标<name>", function (x, y, name) {
  var c = new jscoordinate.Coordinate(Number(x), Number(y));
  gauge.dataStore.scenarioStore.put(name, c);
  assert.equal(c.x(), x);
  assert.equal(c.y(), y);
});

step("<name1>和<name2>的距离为<distance>", function (name1, name2, distance) {
  var c1 = gauge.dataStore.scenarioStore.get(name1);
  var c2 = gauge.dataStore.scenarioStore.get(name2);
  var _distance = jscoordinate.Coordinate.calcDistance(c1, c2);
  gauge.message("距离为" + _distance);
  assert.equal(_distance, Number(distance));
});

step("<name1>和<name2>的方位角为<angle>度", function (name1, name2, angle) {
  var c1 = gauge.dataStore.scenarioStore.get(name1);
  var c2 = gauge.dataStore.scenarioStore.get(name2);
  var _bearing = jscoordinate.Coordinate.calcBearing(c1, c2);
  gauge.message("方位角为" + _bearing);
  assert.equal(_bearing, Number(angle));
});

step(
  "<name>的<angle>度方向，距离为<distance>的坐标为(<x>, <y>)",
  function (name, angle, distance, x, y) {
    var c1 = gauge.dataStore.scenarioStore.get(name);
    var c2 = jscoordinate.Coordinate.calcDestination(
      c1,
      Number(distance),
      Number(angle)
    );
    gauge.message("终点坐标为(" + c2.x() + ", " + c2.y() + ")");
    assert.equal(c2.x(), x);
    assert.equal(c2.y(), y);
  }
);
