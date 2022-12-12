//Angela Sternig
//Matrikelnummer: 12003325
package at.aau.serg.exercises.mccabe;

public class McCabe {
    public static int ggt(int zahl1, int zahl2) {
        while (zahl2 != 0) {
            if (zahl1 > zahl2) {
                zahl1 = zahl1 - zahl2;
            } else {
                zahl2 = zahl2 - zahl1;
            }
        }
        return zahl1;
    }
}
