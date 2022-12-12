//Angela Sternig
//Matrikelnummer: 12003325
package at.aau.serg.exercises.tdd;


import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;


public class MyCollectionTest
{
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


            Assert.assertThrows(IllegalArgumentException.class, () ->
                    c.remove(null));
            Assert.assertThrows(IllegalArgumentException.class, () ->
                    c.remove("Hallo"));

            c.remove("1");
            assertEquals(2, c.size());
            assertNotEquals(c, c1);

            c1.remove("1");

            assertEquals(c, c1);

        }
}