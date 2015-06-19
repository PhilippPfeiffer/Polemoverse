
package javafxapplication1.physics;

import java.util.ArrayList;
import javafx.scene.shape.Line;
import javafxapplication1.API.API;
import javafxapplication1.API.PrintWriter;
import javafxapplication1.Collections.Polygons;
import projectiles.Projectile;

/**
 *
 * @author Philipp
 */
public class ProjectilePhysics {
    
    private final VecMath vecMath = new VecMath();
    private final API api;
    
    //PrintWriter
    PrintWriter printWriter = new PrintWriter();
    
    public ProjectilePhysics(API api) {
        this.api = api;
    }
    
    public double[] move(Projectile projectile) {
        
        fall(projectile);
        
        double[] pos = projectile.getPos();
        double[] vector = projectile.getVector();
        double[] vecNotNormalized = projectile.getVecNotNormalized();
        double velocity = projectile.getVelocity();
        
        double[] newPos = vecMath.addVec(pos, vecNotNormalized);
        
        projectile.updateLine(pos, newPos);
                
        checkCollision(projectile, pos, newPos);
        
        return vecMath.addVec(pos, vecNotNormalized);
    }
    
    public double[] getNormalizedVector(double[] startPos, double[] endPos) {
        double[] vector = vecMath.getVecToPoint(startPos, endPos);
        return vecMath.normalize(vector);
    }
    
    public double[] getVector(double[] startPos, double[] endPos) {
        return vecMath.getVecToPoint(startPos, endPos);
    }
    
    public void fall(Projectile projectile) {
        double[] movementVec = projectile.getVecNotNormalized();
        if(projectile.getVelocity() > 0) {
            if(movementVec[0] > 0.0) {
                movementVec[0] -= 0.1;
            } else {
                movementVec[0] += 0.1;
            }
        }
        movementVec[1] += 0.3;
        projectile.setVecNotNormalized(movementVec);
    }
    
    public void checkCollision(Projectile projectile, double[] oldPos, double[] newPos) {
        for(Polygon polygon : api.getPolygons().getAllPolygonsList()) {
            if(projectile.getLine().getBoundsInParent().intersects(polygon.getBoundingBox().getBoundsInParent())) {
                ArrayList<PolygonLine> polygonLines = polygon.getPolygonLines();
                ArrayList<double[]> intersections = new ArrayList<>();
                for(PolygonLine polygonLine : polygonLines) {
                    double[] point = vecMath.intersectLines(oldPos, newPos, polygonLine.getLine());
                    if(point != null) {
                        double angle = vecMath.getAngle(projectile.getVector(), vecMath.getVecToPoint(polygonLine.getPointA(), polygonLine.getPointB()));
                        System.out.println(angle);
                        api.drawDot(point, 5);
                    }
                }
            }
        }
        
    }
}
