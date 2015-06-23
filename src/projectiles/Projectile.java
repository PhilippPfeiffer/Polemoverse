
package projectiles;

import java.util.ArrayList;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafxapplication1.physics.PolygonLine;
import javafxapplication1.physics.ProjectilePhysics;
import javafxapplication1.physics.VecMath;

/**
 *
 * @author Philipp
 */
public interface Projectile {
    
    public void setCaliber(double caliber);
    public void setVelocity(double velocity);
    public void setRange(double range);
    public void setVector(double[] vector);
    public void setPosX(double posX);
    public void setPosY(double posY);
    public void setPos(double[] pos);
    public void setType(String type);
    public void setShapes(ArrayList<Shape> shapes);
    public void setProjectilePhysics(ProjectilePhysics projectilePhysics);
    public void setVecNotNormalized(double[] vecNotNormalized);
    public void setVecMath(VecMath vecMath);
    public void setLine(Line line);
    public void setLastLineHit(PolygonLine lastLineHit);
    public void setnVec1(double[] nVec1);
    public void setnVec2(double[] nVec2);
    
    public double getCaliber();
    public double getVelocity();
    public double getRange();
    public double[] getVector();
    public double getPosX();
    public double getPosY();
    public double[] getPos(); 
    public String getType();
    public ArrayList<Shape> getShapes();
    public ProjectilePhysics getProjectilePhysics();
    public double[] getVecNotNormalized();
    public VecMath getVecMath();
    public Line getLine();
    public PolygonLine getLastLineHit();
    public double[] getnVec1();
    public double[] getnVec2();
    
    public void move(double deltaX, double deltaY);
    
    public void addShape(Shape shape);
    
    public void initializeBoxes();
    
    public void updateShapePositions();
    
    public void updateLine(double[] oldPos, double[] newPos);
}
