/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.Collections;

import java.util.ArrayList;
import java.util.HashMap;
import platforms.Platform;

/**
 *
 * @author Philipp
 */
public class Platforms {
    
    private final HashMap<String, ArrayList<Platform>> allPlatforms;
    
    public Platforms() {
        allPlatforms = new HashMap<>();
        allPlatforms.put("Walls", new ArrayList<>());
        allPlatforms.put("Floors", new ArrayList<>());
        allPlatforms.put("Slopes", new ArrayList<>());
        allPlatforms.put("Corners", new ArrayList<>());
        allPlatforms.put("Ceilings", new ArrayList<>());
    }
    
    public HashMap<String, ArrayList<Platform>> getAllPlatforms() {
        return allPlatforms;
    }
    
    public ArrayList<Platform> getAllPlatformsList() {
        ArrayList<Platform> tmpAllPlatforms = new ArrayList<>();
        tmpAllPlatforms.addAll(this.allPlatforms.get("Walls"));
        tmpAllPlatforms.addAll(this.allPlatforms.get("Floors"));
        tmpAllPlatforms.addAll(this.allPlatforms.get("Slopes"));
        tmpAllPlatforms.addAll(this.allPlatforms.get("Corners"));
        tmpAllPlatforms.addAll(this.allPlatforms.get("Ceilings"));
        return tmpAllPlatforms;
    }
    
    public void addPlatform(Platform platform) {
        String type = platform.getType();
        switch(type) {
            case "Wall":
                allPlatforms.get("Walls").add(platform);
                break;
            case "Floor":
                allPlatforms.get("Floors").add(platform);
                break;
            case "Slope":
                allPlatforms.get("Slopes").add(platform);
                break;
            case "Corner":
                allPlatforms.get("Corners").add(platform);
                break;
            case "Ceiling":
                allPlatforms.get("Ceilings").add(platform);
                break;
        }
    }

    
}
