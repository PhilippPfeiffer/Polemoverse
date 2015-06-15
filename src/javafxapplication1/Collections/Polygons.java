package javafxapplication1.Collections;

import java.util.ArrayList;
import javafxapplication1.physics.Polygon;

/**
 *
 * @author Philipp
 */
public class Polygons {
    
    private final ArrayList<Polygon> allPolygonsList;
    
    public Polygons() {
        allPolygonsList = new ArrayList<>();
    }
    
    public ArrayList<Polygon> getAllPolygonsList() {
        return allPolygonsList;
    }
    
    public void addPolygon(Polygon polygon) {
        allPolygonsList.add(polygon);
    }
    
    public Polygon getPolygon(int index) {
        return allPolygonsList.get(index);
    }
    
    public void moveAllPolygons(double deltaX, double deltaY) {
        allPolygonsList.stream().forEach((polygon) -> {
            polygon.move(deltaX, deltaY);
        });
    }
}
