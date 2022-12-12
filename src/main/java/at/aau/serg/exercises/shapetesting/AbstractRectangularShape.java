
package at.aau.serg.exercises.shapetesting;

import java.util.List;

public abstract class AbstractRectangularShape implements RectangularShape {
    @Override
    public boolean isEquilateral() {
        return this.getWidth() == this.getHeight();
    }

    @Override
    public List<Side> getSides() {
        return List.of(
            new Side(this.getHeight()),
            new Side(this.getWidth()),
            new Side(this.getHeight()),
            new Side(this.getWidth())
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RectangularShape)) {
            return false;
        }
        RectangularShape shape = (RectangularShape) obj;
        return this.getWidth() == shape.getWidth() && this.getHeight() == shape.getHeight();
    }
}
