import java.util.Scanner;   
// Interface declaring transformation operations
interface Transformations
{
    void translate(double tx, double ty);
    void scale(double sx, double sy);
    void rotate(double angle);
}
// Point class implementing the Transformations interface
class Point implements Transformations
{
    double x, y;   // Coordinates of the point
    // Constructor to initialize point coordinates
    Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    
// Translate the point by tx and ty
    public void translate(double tx, double ty)
    {
        x = x + tx;
        y = y + ty;
    }
    // Scale the point by sx and sy
    public void scale(double sx, double sy)
    {
        x = x * sx;
        y = y * sy;
    }
    // Rotate the point about origin by given angle
    public void rotate(double angle)
    {
        double rad = Math.toRadians(angle);   // Convert degree to radians
        double newX = x * Math.cos(rad) - y * Math.sin(rad); 
		double newY = x * Math.sin(rad) + y * Math.cos(rad); // Uses the original x
		x = newX;
		y = newY;
    }
    // Method to calculate distance between two points
    double calculate(Point p)
    {
        return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
    }
    // Method to display point coordinates
    void display()
    {
        System.out.printf("Point (%.2f, %.2f)\n", x, y);
    }
}
// Main class (Client Code)
public class Interface
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);   
        // Read number of points
        System.out.print("Enter number of points: ");
        int n = sc.nextInt();

        Point[] points = new Point[n];   // Array of Point objects

        // Create N point objects
        for(int i = 0; i < n; i++)
        {
            System.out.print("Enter x and y for point " + (i + 1) + ": ");
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            points[i] = new Point(x, y);
        }

        // Perform transformations on each point
        for(int i = 0; i < n; i++)
        {
            System.out.println("\nOriginal:");
            points[i].display();

           
 points[i].translate(2, 3);
            System.out.println("After Translation:");
            points[i].display();

            points[i].scale(2, 2);
            System.out.println("After Scaling:");
            points[i].display();

            points[i].rotate(45);
            System.out.println("After Rotation:");
            points[i].display();
        }
        // Calculate distance between first two points
        if(n >= 2)
        {
            double dist = points[0].calculate(points[1]);
            System.out.println("\nDistance between Point 1 and Point 2: " + dist);
        }
        sc.close();   // Close scanner
    }
} 
