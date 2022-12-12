//Angela Sternig
//Matrikelnummer: 12003325
package at.aau.serg.exercises.shapetesting;

public class Rectangle extends AbstractRectangularShape {
    private final int width;
    private final int height;

    public Rectangle(int width, int height) {
        if (width <= 0) {
            throw new IllegalArgumentException("The width of a rectangle has to be greater than 0.");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("The height of a rectangle has to be greater than 0.");
        }

        this.width = width;
        this.height = height;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }
}
