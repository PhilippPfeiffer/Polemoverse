/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.physics;

import projectiles.Projectile;

/**
 *
 * @author Philipp
 */
public class ProjectilePhysics {
    
    private final VecMath vecMath = new VecMath();
    
    public double[] move(Projectile projectile) {
        
        double[] pos = projectile.getPos();
        double[] vector = projectile.getVector();
        double velocity = projectile.getVelocity();
        
        fall(projectile);
        
        return vecMath.addVec(pos, vecMath.multiplyVec(vector, velocity));
    }
    
    public double[] getNormalizedVector(double[] startPos, double[] endPos) {
        double[] vector = vecMath.getVecToPoint(startPos, endPos);
        return vecMath.normalize(vector);
    }
    
    public double[] getVector(double[] startPos, double[] endPos) {
        return vecMath.getVecToPoint(startPos, endPos);
    }
    
    public void fall(Projectile projectile) {
        if(projectile.getVelocity() > 0) {
            projectile.setVelocity(projectile.getVelocity()-0.5);
        }
    }
}
