
package javafxapplication1.physics;

import projectiles.Projectile;

/**
 *
 * @author Philipp
 */
public class ProjectilePhysics {
    
    private final VecMath vecMath = new VecMath();
    
    public double[] move(Projectile projectile) {
        
        fall(projectile);
        
        double[] pos = projectile.getPos();
        double[] vector = projectile.getVector();
        double[] vecNotNormalized = projectile.getVecNotNormalized();
        double velocity = projectile.getVelocity();
        
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
}
