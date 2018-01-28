
package Freightos24Ass;

/**
 *
 * @author duhash
 */
public class Box {
    private int volume;
    private int weight;
    private int truck;

    public Box() {
    }
    
    
    
    public Box(int volume, int weight) {
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
