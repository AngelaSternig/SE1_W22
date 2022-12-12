//Angela Sternig
//Matrikelnummer: 12003325
package at.aau.serg.exercises.tdd;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitPlatform.class)
public class MyCollectionTest {
    private MyCollection c;

    @BeforeEach
    public void setup() {
        c = new MyCollection(5);
        c.add("1");
        c.add("2");
        c.add("3");
    }

    @Test
    public void testSizeSimple() {
        assertEquals(3,c.size());
    }

    @Test
    public void testRemove(){
        MyCollection c1 = new MyCollection(5);
        c1.add("1");
        c1.add("2");
        c1.add("3");

        c1.remove("1");
        assertEquals(2, c1.size());
        assertNotEquals(c, c1);

        c.remove("1");
        c.remove("2");

        assertEquals(1, c.size());

        MyCollection c2 = new MyCollection(2);
        c2.add("3");
        c2.add("4");
        Assert.assertThrows(IllegalArgumentException.class, () ->
                new MyCollection(2).remove("2"));
        Assert.assertThrows(IllegalArgumentException.class, () ->
                c2.remove("2"));
    }

    @Test
    public void testEmpty(){
        MyCollection c1 = new MyCollection(5);
        c1.add("1");
        c1.add("2");
        c1.add("3");

        c1.empty();
        assertEquals(0, c1.size());
        assertNotEquals(c, c1);

        c.empty();
        assertEquals(0, c.size());
    }
}