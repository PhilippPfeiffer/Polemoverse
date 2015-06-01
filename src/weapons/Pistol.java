
package weapons;

import javafxapplication1.API.API;

/**
 *
 * @author Philipp
 */
public class Pistol extends InfantryWeapon {
    
    public Pistol(API api, int magazineSize, double reloadTime, double fireRate, 
                  double spread, int projectiles, double firingVelocity, 
                  double range, double caliber) {
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
    }
}
