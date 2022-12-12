//Angela Sternig
//Matrikelnummer: 12003325
package at.aau.serg.exercises.shapetesting;

public class Square extends AbstractRectangularShape {
    private final int sideLength;

    public Square(int sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("The side length of a square has to be greater than 0.");
        }
        this.sideLength = sideLength;
    }

    @Override
    public int getWidth() {
        return this.sideLength;
    }

    @Override
    public int getHeight() {
        return this.sideLength;
    }
}
