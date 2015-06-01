
package projectiles;

/**
 *
 * @author Philipp
 */
public class Bullet_Pistol extends Bullet{
        
    public Bullet_Pistol(double caliber, double velocity, double range, double[] pos, double[] target) {
        setCaliber(caliber);
        setVelocity(velocity);
        setRange(range);
        setPos(pos);
        double[] vector = getProjectilePhysics().getNormalizedVector(pos, target);
        double[] vecNotNormalized = getVecMath().multiplyVec(vector, velocity);
        setVector(vector);
        setVecNotNormalized(vecNotNormalized);
        
        initializeBoxes();
    }
    
}
