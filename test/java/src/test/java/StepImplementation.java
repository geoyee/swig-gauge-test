import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.ScenarioDataStore;
import com.thoughtworks.gauge.Gauge;

import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation {
    static {
        try {
            DllManager.addLibraryDir("gauge_test/test/java/libs");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.loadLibrary("jvcoordinate");
    }

    @Step("创建一个x为<x>，y为<y>的坐标<name>")
    public void createCoordinate(double x, double y, String name) {
        Coordinate c = new Coordinate(x, y);
        ScenarioDataStore.put(name, c);
        assertThat(c.x()).isEqualTo(x);
        assertThat(c.y()).isEqualTo(y);
    }

    @Step("<name1>和<name2>的距离为<distance>")
    public void calcDistance(String name1, String name2, double distance) {
        Coordinate c1 = (Coordinate) ScenarioDataStore.get(name1);
        Coordinate c2 = (Coordinate) ScenarioDataStore.get(name2);
        double _distance = Coordinate.calcDistance(c1, c2);
        Gauge.writeMessage("距离为%s", String.valueOf(_distance));
        assertThat(_distance).isEqualTo(distance);
    }

    @Step("<name1>和<name2>的方位角为<angle>度")
    public void calcBearing(String name1, String name2, double angle) {
        Coordinate c1 = (Coordinate) ScenarioDataStore.get(name1);
        Coordinate c2 = (Coordinate) ScenarioDataStore.get(name2);
        double _bearing = Coordinate.calcBearing(c1, c2);
        Gauge.writeMessage("方位角为%s", String.valueOf(_bearing));
        assertThat(_bearing).isEqualTo(angle);
    }

    @Step("<name>的<angle>度方向，距离为<distance>的坐标为(<x>, <y>)")
    public void calcDestination(String name, double angle, double distance, double x, double y) {
        Coordinate c1 = (Coordinate) ScenarioDataStore.get(name);
        Coordinate c2 = Coordinate.calcDestination(c1, distance, angle);
        Gauge.writeMessage("终点坐标为(%s, %s)", String.valueOf(c2.x()), String.valueOf(c2.y()));
        assertThat(c2.x()).isEqualTo(x);
        assertThat(c2.y()).isEqualTo(y);
    }
}
