/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.Collections;

import java.util.ArrayList;
import java.util.HashMap;
import projectiles.Projectile;

/**
 *
 * @author Philipp
 */
public class Projectiles {
    
    private final HashMap<String, ArrayList<Projectile>> allProjectiles;
    private final ArrayList<Projectile> allProjectilesList;
    
    public Projectiles() {
        allProjectiles = new HashMap<>();
        allProjectiles.put("Bullets", new ArrayList<>());
        allProjectiles.put("Grenades", new ArrayList<>());
        allProjectiles.put("Bombs", new ArrayList<>());
        allProjectilesList = new ArrayList<>();
    }
    
    public HashMap<String, ArrayList<Projectile>> getAllProjectiles() {
        return allProjectiles;
    }
    
    public ArrayList<Projectile> getAllProjectilesList() {
        return allProjectilesList;
    }
    
    public void addProjectile(Projectile projectile) {
        String type = projectile.getType();
        switch(type) {
            case "Bullet":
                allProjectiles.get("Bullets").add(projectile);
                break;
            case "Grenades":
                allProjectiles.get("Grenades").add(projectile);
                break;
            case "Bombs":
                allProjectiles.get("Bombs").add(projectile);
                break;
        }
        allProjectilesList.add(projectile);
    }
    
    public void moveAllProjectiles(double deltaX, double deltaY) {
        for(Projectile projectile : allProjectilesList) {
            projectile.move(deltaX, deltaY);
        }
    }
    
}
