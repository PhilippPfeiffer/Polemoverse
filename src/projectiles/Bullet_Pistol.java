
package projectiles;

import javafxapplication1.physics.ProjectilePhysics;

/**
 *
 * @author Philipp
 */
public class Bullet_Pistol extends Bullet{
        
    public Bullet_Pistol(double caliber, double velocity, double range, double[] pos, double[] target, ProjectilePhysics projectilePhysics) {
        this.projectilePhysics = projectilePhysics;
        setCaliber(caliber);
        setVelocity(velocity);
        setRange(range);
        setPos(pos);
        double[] vector = getProjectilePhysics().getNormalizedVector(pos, target);
        double[] vecNotNormalized = getVecMath().multiplyVec(vector, velocity);
        setnVec1(getVecMath().getNormalVecLeft(vecNotNormalized));
        setnVec2(getVecMath().getNormalVecRight(vecNotNormalized));
        setVector(vector);
        setVecNotNormalized(vecNotNormalized);
        
        initializeBoxes();
    }
    
}
