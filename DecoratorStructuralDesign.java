
interface Shape{
   void draw(); 
}

class Rectangle implements Shape {
    @Override
    public void draw(){
        System.out.println("Drawing plain rectangle");
    }
}

abstract class ShapeDecorator implements Shape {
    Shape decoShape;
    ShapeDecorator(Shape decoShape){
        this.decoShape = decoShape;
    }

    public void draw(){
        decoShape.draw();
     }
}

class RedRectangle extends ShapeDecorator {
    RedRectangle(Shape decoShape) {
        super(decoShape);
    }

    @Override
    public void draw(){
        System.out.println("Drawing a red triangle");
    }
}

public class DecoratorStructuralDesign {
    public static void main(String[] args) {

        Rectangle  NormalRect = new Rectangle();

        NormalRect.draw();

        RedRectangle RedRect = new RedRectangle(NormalRect);

        RedRect.draw();
    }
}
