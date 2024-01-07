from getgauge.python import step, data_store, Messages

from libs.pycoordinate import Coordinate

@step("创建一个x为<x>，y为<y>的坐标<name>")
def create_coordinate(x: float, y: float, name: str):
    c = Coordinate(float(x), float(y))
    data_store.scenario[name] = c
    assert c.x() == float(x)
    assert c.y() == float(y)

@step("<name1>和<name2>的距离为<distance>")
def calc_distance(name1: str, name2: str, distance: float):
    c1 = data_store.scenario[name1]
    c2 = data_store.scenario[name2]
    _distance = Coordinate.calcDistance(c1, c2)
    Messages.write_message("距离为" + str(_distance))
    assert _distance == float(distance)

@step("<name1>和<name2>的方位角为<angle>度")
def calc_bearing(name1: str, name2: str, angle: float):
    c1 = data_store.scenario[name1]
    c2 = data_store.scenario[name2]
    _bearing = Coordinate.calcBearing(c1, c2)
    Messages.write_message("方位角为" + str(_bearing))
    assert _bearing == float(angle)

@step("<name>的<angle>度方向，距离为<distance>的坐标为(<x>, <y>)")
def calc_bearing(name: str, angle: float, distance: float, x: float, y: float):
    c1 = data_store.scenario[name]
    c2 = Coordinate.calcDestination(c1, float(distance), float(angle))
    Messages.write_message("终点坐标为(" + str(c2.x()) + ", " + str(c2.y()) + ")")
    assert c2.x() == float(x)
    assert c2.y() == float(y)