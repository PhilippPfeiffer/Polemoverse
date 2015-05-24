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
        
        return vecMath.addVec(pos, vecMath.multiplyVec(vector, velocity));
    }
}
