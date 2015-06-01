
package weapons;

import java.util.ArrayList;
import javafxapplication1.API.API;
import javafxapplication1.physics.ProjectilePhysics;
import javafxapplication1.physics.VecMath;
import projectiles.Bullet_Pistol;
import projectiles.Projectile;

/**
 *
 * @author Philipp
 */
public abstract class InfantryWeapon implements Weapon {
    
    
    private int magazineSize = 0;
    private double reloadTime = 0.0;
    private double fireRate = 0.0;
    private double spread = 0.0;
    private int projectileNumber = 0;
    private double caliber = 0.0;
    private double firingVelocity = 0.0;
    private double range = 0.0;
    ProjectilePhysics projectilePhysics = new ProjectilePhysics();
    VecMath vecMath = new VecMath();
    boolean ready = false;
    ArrayList<Projectile> projectileTypes = new ArrayList<>();
    API api;

    @Override
    public int getMagazineSize() {
        return magazineSize;
    }

    @Override
    public void setMagazineSize(int magazineSize) {
        this.magazineSize = magazineSize;
    }

    @Override
    public double getReloadTime() {
        return reloadTime;
    }

    @Override
    public void setReloadTime(double reloadTime) {
        this.reloadTime = reloadTime;
    }

    @Override
    public double getFireRate() {
        return fireRate;
    }

    @Override
    public void setFireRate(double fireRate) {
        this.fireRate = fireRate;
    }

    @Override
    public double getSpread() {
        return spread;
    }

    @Override
    public void setSpread(double spread) {
        this.spread = spread;
    }

    @Override
    public int getProjectileNumber() {
        return projectileNumber;
    }

    @Override
    public void setProjectileNumber(int projectileNumber) {
        this.projectileNumber = projectileNumber;
    }

    @Override
    public double getCaliber() {
        return caliber;
    }

    @Override
    public void setCaliber(double caliber) {
        this.caliber = caliber;
    }

    @Override
    public double getFiringVelocity() {
        return firingVelocity;
    }

    @Override
    public void setFiringVelocity(double firingVelocity) {
        this.firingVelocity = firingVelocity;
    }

    @Override
    public double getRange() {
        return range;
    }

    @Override
    public void setRange(double range) {
        this.range = range;
    }

    @Override
    public ProjectilePhysics getProjectilePhysics() {
        return projectilePhysics;
    }

    @Override
    public void setProjectilePhysics(ProjectilePhysics projectilePhysics) {
        this.projectilePhysics = projectilePhysics;
    }
    
    @Override
    public boolean isReady() {
        return ready;
    }
    
    @Override
    public void setReady(boolean ready) {
        this.ready = ready;
    }
    
    @Override
    public void fire(double[] startPos, double[] targetPos) {
        if(ready) {
            double[] vector = vecMath.getVecToPoint(startPos, targetPos);
            vector = vecMath.rotateVec(vector, vecMath.randomizeAngle(getSpread()));
            double[] target1 = vecMath.addVec(startPos, vector);
            
            api.addProjectile(new Bullet_Pistol(getCaliber(), getFiringVelocity(), getRange(), startPos, target1));
        }
        
    }
    
    @Override
    public void reload() {
        //TODO
    }

    @Override
    public API getAPI() {
        return api;
    }

    @Override
    public void setAPI(API api) {
        this.api = api;
    }

    
}
