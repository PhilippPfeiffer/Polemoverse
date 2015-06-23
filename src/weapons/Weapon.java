
package weapons;

import javafxapplication1.API.API;
import javafxapplication1.physics.ProjectilePhysics;

/**
 *
 * @author Philipp
 */
public interface Weapon {

    void fire(double[] startPos, double[] targetpos);

    double getCaliber();

    double getFireRate();

    double getFiringVelocity();

    int getMagazineSize();

    int getProjectileNumber();

    ProjectilePhysics getProjectilePhysics();

    double getRange();

    double getReloadTime();

    double getSpread();

    boolean isReady();
    
    API getAPI();

    void reload();

    void setCaliber(double caliber);

    void setFireRate(double fireRate);

    void setFiringVelocity(double firingVelocity);

    void setMagazineSize(int magazineSize);

    void setProjectileNumber(int projectileNumber);

    void setProjectilePhysics(ProjectilePhysics projectilePhysics);

    void setRange(double range);

    void setReady(boolean ready);

    void setReloadTime(double reloadTime);

    void setSpread(double spread);
    
    void setAPI(API api);
    
}
