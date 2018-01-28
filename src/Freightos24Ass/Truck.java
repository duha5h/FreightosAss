
package Freightos24Ass;

import java.util.LinkedList;

/**
 *
 * @author duhash
 */
public class Truck {
    
    private float totalVolume;
    private float totalWeight;
    private LinkedList boxes;

    public Truck() {
        this.totalVolume = 0;
        this.totalWeight = 0;
        this.boxes = new LinkedList();
    }

    public LinkedList getBoxes() {
        return boxes;
    }

    public float getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(float totalVolume) {
        this.totalVolume = totalVolume;
    }

    public float getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(float totalWeight) {
        this.totalWeight = totalWeight;
    }
    
    
    
}
