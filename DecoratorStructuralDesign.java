import java.util.Scanner;

// Component Interface
interface Shape {
    double calculateArea();
}

// Concrete Component
class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        return width * height;
    }
}

// Decorator
abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    public double calculateArea() {
        return decoratedShape.calculateArea();
    }
}

// Concrete Decorator - Measurement Unit
class MeasurementUnitDecorator extends ShapeDecorator {
    private String unit;

    public MeasurementUnitDecorator(Shape decoratedShape, String unit) {
        super(decoratedShape);
        this.unit = unit;

        if(unit == null){ 
            this.unit = "cm";
        }

    }

    public double calculateArea() {
        double area = decoratedShape.calculateArea();

        // Convert area to the desired unit
        if (unit.equals("m")) {
            area /= 10000.0; // Convert from cm^2 to m^2
        } else if (unit.equals("in")) {
            area /= 6.4516; // Convert from cm^2 to in^2
        }

        System.out.println("Area: " + area + " " + unit);
        return area;
    }
}

// Concrete Decorator - Display Format
class DisplayFormatDecorator extends ShapeDecorator {
    private String format;

    public DisplayFormatDecorator(Shape decoratedShape, String format) {
        super(decoratedShape);
        this.format = format;
    }

    public double calculateArea() {
        double area = decoratedShape.calculateArea();
        //System.out.printf("Area: %" + format + "f%n", area);m
        return area;
    }
}

// Usage
public class DecoratorStructuralDesign {
    public static void main(String[] args) {
        // Create a rectangle
        Scanner getXY = new Scanner(System.in);
        System.out.println("Enter X");
        double x = getXY.nextInt();
        System.out.println("Enter Y");
        double y = getXY.nextInt();
        Shape rectangle = new Rectangle(x, y);

        // Get the unit of measurement from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the unit of measurement (m or in): ");
        String unit = scanner.nextLine();

        // Decorate the rectangle with the user-selected unit and display format
        Shape decoratedRectangle = new MeasurementUnitDecorator(rectangle, unit);
        decoratedRectangle = new DisplayFormatDecorator(decoratedRectangle, ".2f");

        // Calculate and display the area
        double area = decoratedRectangle.calculateArea();
    }
}
