import javafx.scene.shape.Polygon;

public class Triangle {
    /**
     * contains only one static function that
     * creates the triangle (dice) 
     */

    public static Polygon createTriangle(double centerX, double centerY, double sideLength) {
        Polygon triangle = new Polygon();
        double halfHeightLen = sideLength * (Math.sqrt(3) / 4);
        double halfSideLen = sideLength / 2;

        triangle.getPoints().addAll(centerX, centerY + halfHeightLen,
                centerX - halfSideLen, centerY - halfHeightLen,
                centerX + halfSideLen, centerY - halfHeightLen);

        return triangle;
    }
}
