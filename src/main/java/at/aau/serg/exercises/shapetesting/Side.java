//Angela Sternig
//Matrikelnummer: 12003325
package at.aau.serg.exercises.shapetesting;

import java.util.Objects;

public class Side {
    private final int length;

    public Side(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("The length of a side has to be greater than 0.");
        }
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Side)) {
            return false;
        }
        Side side = (Side) obj;
        return this.length == side.length;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.length);
    }
}
