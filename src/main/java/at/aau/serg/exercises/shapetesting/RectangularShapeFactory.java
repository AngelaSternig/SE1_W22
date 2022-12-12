//Angela Sternig
//Matrikelnummer: 12003325
package at.aau.serg.exercises.shapetesting;

public class RectangularShapeFactory {
    public RectangularShape create(int width, int height) {
        if (width == height) {
            return create(width);
        }
        return new Rectangle(width, height);
    }

    public RectangularShape create(int sideLength) {
        return new Square(sideLength);
    }
}
