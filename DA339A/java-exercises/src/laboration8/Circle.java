package laboration8;

public class Circle {
    private double radius;
    private Point position;

    public Circle( double inRadius, Point inPosition ) {
        this.radius = inRadius;
        this.position = inPosition.copy();
    }
    
    public void setPosition( Point inPosition ) {
        this.position = inPosition;
    }

    public double getRadius() {
        return this.radius;
    }

    public Point getPosition() {
        return position.copy();
    }

    public int getX() {
        return this.position.getX();
    }

    public int getY() {
        return this.position.getY();
    }

    public String toString() {
        return "CIRCLE, radius = " + this.radius + ", position = " + position.toString();
    }
}
