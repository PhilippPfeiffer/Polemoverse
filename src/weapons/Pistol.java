
package weapons;

import javafxapplication1.API.API;
import javafxapplication1.physics.ProjectilePhysics;

/**
 *
 * @author Philipp
 */
public class Pistol extends InfantryWeapon {
    
    public Pistol(API api, int magazineSize, double reloadTime, double fireRate, 
                  double spread, int projectiles, double firingVelocity, 
                  double range, double caliber, ProjectilePhysics projectilePhysics) {
        setShotsInMagazine(magazineSize);
        setMagazineSize(magazineSize);
        setReloadTime(reloadTime);
        setFireRate(fireRate);
        setSpread(spread);
        setProjectileNumber(projectiles);
        setFiringVelocity(firingVelocity);
        setRange(range);
        setReady(true);
        setAPI(api);
        setCaliber(caliber);
        this.projectilePhysics = projectilePhysics;
    }
}
