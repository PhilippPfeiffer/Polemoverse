
package javafxapplication1;

import javafxapplication1.Background.BackgroundObject;
import javafxapplication1.Background.Tile;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafxapplication1.API.API;
import javafxapplication1.controls.CommandHandler;
import javafxapplication1.entities.Player;
import javafxapplication1.physics.Polygon;
import javafxapplication1.physics.ProjectilePhysics;
import javafxapplication1.platforms.Floor_1;
import javafxapplication1.platforms.Platform;
import javafxapplication1.platforms.Wall_1;
import weapons.Pistol;

/**
 *
 * @author Philipp
 */
public class Game extends Application {
    
    final double minX = 0;
    final double maxX = 1280;
    final double minY = 0;
    final double maxY = 800;
    final double speed = 100;
    Player player = new Player(250, 400);
    Platform wall_1 = new Wall_1(0,0,50,500,0);
    Platform floor_1 = new Floor_1(0,maxY-50.0,500,50,0);
    BackgroundObject testTile1 = new Tile(300,100,1.0,100,100);
    BackgroundObject testTile2 = new Tile(300,200,1.0,100,100);
    BackgroundObject testTile3 = new Tile(300,300,1.0,100,100);
    
    

    
    final CommandHandler commandHandler = new CommandHandler();
    
    final DoubleProperty velocity = new SimpleDoubleProperty();
    final DoubleProperty verticalVelocity = new SimpleDoubleProperty();
    final LongProperty lastUpdateTime = new SimpleLongProperty();
    final API api = new API(new Pane());
    final ProjectilePhysics projectilePhysics = new ProjectilePhysics(api);
    
    @Override
    public void start(Stage primaryStage) {
       
        //Testing
        double[] pos1 = {500.0, 500.0};
        double[] pointA = {200.0, 200.0};
        double[] pointB = {0.0, 100.0};
        double[] pointC = {100.0, 0.0};
        double[] pointD = {100.0, 100.0};
        double[] pointE = {150.0, 250.0};
        Polygon polygon1 = new Polygon(pos1);
        polygon1.addLine(pointA, pointB);
        polygon1.addLine(pointB, pointD);
        polygon1.addLine(pointD, pointC);
        polygon1.addLine(pointC, pointA);
        polygon1.addLine(pointC, pointE);

               
        api.createBackgroundlayers(3);
        api.addFigure(player);
        //api.addPlatform(wall_1);
        api.addPlatform(floor_1);
        api.addBackgroundObjectToLayer(0, testTile1);
        api.addBackgroundObjectToLayer(1, testTile2);
        api.addBackgroundObjectToLayer(2, testTile3);
        
        api.addPolygon(polygon1);
            
        Pane root = api.addToPane();
        
        player.setAPI(api);
        player.addWeapon(new Pistol(getAPI(),10,5.0, 0.5,5.0,1,100.0,1000, 9.0, projectilePhysics));
        
        Scene scene = new Scene(root, maxX, maxY);
        
        AnimationTimer animation = new AnimationTimer() {
            @Override
            public void handle(long timestamp) {
                
                if(player.getMoving() == false) {
                    player.decreaseSpeed();
                } else if(player.getMoving() == true) {
                    player.increaseSpeed();
                }
                
                player.fall();
                
                player.checkbounds();
                
                velocity.set(player.getSpeed());
                verticalVelocity.set(player.getVerticalSpeed());
                if (lastUpdateTime.get() > 0) {
                    
                    final double elapsedSeconds = (timestamp - lastUpdateTime.get()) / 1_000_000_000.0 ;
                    final double deltaX = elapsedSeconds * velocity.get();
                    final double deltaY = elapsedSeconds * verticalVelocity.get();
                    final double oldX = player.getPositionX();
                    final double oldY = player.getPositionY();
                    final double newX = Math.max(minX, Math.min(maxX - player.getWidth(), oldX + deltaX));
                    final double newY = Math.max(minY, Math.min(maxY - player.getHeight(), oldY + deltaY));
                    api.moveEverything(-deltaX, 0);
                    player.setPosition(oldX, newY);
                }
                lastUpdateTime.set(timestamp);
            }
        };
        
        animation.start();
        
        scene = commandHandler.setEventHandlers(scene, player);
        
        primaryStage.setTitle("Box Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public API getAPI() {
        return api;
    }
    
}
