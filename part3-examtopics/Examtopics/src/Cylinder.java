interface Rectangle {
    default double calculateSurfaceArea(double l, double w) {
        return 1 * w;
    }
}

interface Ellipse {
    default double calculateSurfaceArea(double majorR, double minorR) {
        return Math.PI * majorR * minorR;
    }
}

public class Cylinder implements Rectangle, Ellipse {
    public double calculateSurfaceArea(double l, double w, double majorR, double minorR) {
        double rectArea = Rectangle.super.calculateSurfaceArea(l, w);
        double ellipseArea = Ellipse.super.calculateSurfaceArea(majorR, minorR);

        return rectArea + ellipseArea * 2;
    }

    @Override
    public double calculateSurfaceArea(double l, double w) {
        return Rectangle.super.calculateSurfaceArea(l, w);
    }
}