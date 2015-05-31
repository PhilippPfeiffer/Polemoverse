/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        double[] vector = projectilePhysics.getNormalizedVector(pos, target);
        setVector(vector);
        
        initializeBoxes();
    }
    
}