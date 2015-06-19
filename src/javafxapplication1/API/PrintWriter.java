package javafxapplication1.API;

/**
 *
 * @author Philipp
 */
public class PrintWriter {
    
    public String toString(double[] array) {
        
        String string = "(";
        for(int i=0; i<array.length; i++) {
            if(i>0) {
                string += ",";
            }
            string += array[i];
        }
        string += ")";
        return string;
    }
    
}
