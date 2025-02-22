package edu.northeastern.csye6200;

public class LAB4P2 {
    public static void main(String[] args) {
        // Create two points as specified
        MyDataPoint point1 = new MyDataPoint(); // (0,0,0)
        MyDataPoint point2 = new MyDataPoint(10, 27.83, 40.18);
        
        // Display the points
        System.out.printf("The first data point is (%.3f, %.3f, %.3f)%n",
            point1.getX(), point1.getY(), point1.getZ());
        System.out.printf("The second data point is (%.3f, %.3f, %.3f)%n",
            point2.getX(), point2.getY(), point2.getZ());
        
        // Calculate and display distances using both approaches
        System.out.printf("The distance uses one point's distance method is %.3f%n",
            point1.distance(point2));
        System.out.printf("The distance uses MyDataPoint class's distance method is %.3f%n",
            point1.distance(point2.getX(), point2.getY(), point2.getZ()));
    }
}

class MyDataPoint {
    // Private fields for coordinates
    private final double x;
    private final double y;
    private final double z;
    
    
    public MyDataPoint() {
        this(0, 0, 0);
    }
    
    
    public MyDataPoint(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    // Getter methods
    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }
    
    
    public double distance(MyDataPoint point) {
        return distance(point.x, point.y, point.z);
    }
    
    public double distance(double x, double y, double z) {
        double dx = this.x - x;
        double dy = this.y - y;
        double dz = this.z - z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}