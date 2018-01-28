
package Freightos24Ass;

/**
 *
 * @author duhash
 */
public class Box {
    private float volume;
    private float weight;
    private int truck;

    
    public Box() {
    }
    
    
    
    public Box(float volume, float weight) {
        this.volume = volume;
        this.weight = weight;
        this.truck = -1;
    }
    
    public int getTruck() {
        return truck;
    }

    public void setTruck(int truck) {
        this.truck = truck;
    }

    @Override
    public String toString() {
        return "Box{" + "volume=" + volume + ", weight=" + weight + ", truck=" + truck + '}';
    }
    
}
