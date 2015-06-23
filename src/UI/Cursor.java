package UI;

/**
 *
 * @author Philipp
 */
public class Cursor {
    
    private double xPos = 0.0;
    private double yPos = 0.0;
    
    public Cursor() {
        
    }

    public double getxPos() {
        return xPos;
    }

    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    public double getyPos() {
        return yPos;
    }

    public void setyPos(double yPos) {
        this.yPos = yPos;
    }
    
    public double[] getPos() {
        double[] pos = {xPos, yPos};
        return pos;
    }
    
    public void setPos(double[] pos) {
        this.xPos = pos[0];
        this.yPos = pos[1];
    }   
}
