import java.util.Scanner;

// Product Interface
interface Shape {
    void displayProperties();
}

// Concrete Products
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public void displayProperties() {
        System.out.println("Circle properties:");
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
        System.out.println();
    }

    private double calculateArea() {
        return Math.PI * radius * radius;
    }

    private double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void displayProperties() {
        System.out.println("Rectangle properties:");
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
        System.out.println();
    }

    private double calculateArea() {
        return width * height;
    }

    private double calculatePerimeter() {
        return 2 * (width + height);
    }
}

// Creator Interface
interface ShapeCreator {
    Shape createShape();
}

// Concrete Creators
class CircleCreator implements ShapeCreator {
    private Scanner scanner = new Scanner(System.in);

    public Shape createShape() {
        System.out.print("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();
        return new Circle(radius);
    }
}

class RectangleCreator implements ShapeCreator {
    private Scanner scanner = new Scanner(System.in);

    public Shape createShape() {
        System.out.print("Enter the width of the rectangle: ");
        double width = scanner.nextDouble();
        System.out.print("Enter the height of the rectangle: ");
        double height = scanner.nextDouble();
        return new Rectangle(width, height);
    }
}

// Usage
public class FactoryMethod {
    public static void main(String[] args) {
        // Create an array of shape creators
        ShapeCreator[] creators = { new CircleCreator(), new RectangleCreator() };

        // Get the shape type from the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a shape to generate (1 - Circle, 2 - Rectangle): ");
        int choice = scanner.nextInt();
        
        if (choice >= 1 && choice <= creators.length) {
            // Create the shape using the selected creator
            ShapeCreator creator = creators[choice - 1];
            Shape shape = creator.createShape();

            // Display the properties of the generated shape
            shape.displayProperties();
        } else {
            System.out.println("Invalid choice. Program exiting.");
        }
    }
}
