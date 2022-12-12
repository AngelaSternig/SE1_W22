//Angela Sternig
//Matrikelnummer: 12003325
package at.aau.serg.exercises.ringbuffer;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnitPlatform.class)
@SelectClasses( {BaseTest.class, FullCoverageTest.class, FullMutationScoreTest.class})
public class RingBufferTest {
    @Test
    public void testConstructor(){
        RingBuffer Buffer1 = new RingBuffer(3);
        RingBuffer Buffer2 = new RingBuffer(3);
        RingBuffer Buffer3 = new RingBuffer(4);

        Buffer1.push(2);
        Buffer2.push(2);
        Buffer3.push(5);

        Assert.assertNotEquals(Buffer1, Buffer2);
        Assert.assertNotEquals(Buffer2, Buffer1);
        Assert.assertNotEquals(Buffer1, Buffer3);
    }

    @Test
    public void testIsEmpty(){
        RingBuffer Buffer4 = new RingBuffer(5);

        Assert.assertTrue(Buffer4.isEmpty());
        Buffer4.push(3);
        Assert.assertFalse(Buffer4.isEmpty());
        Buffer4.pop();
        Assert.assertTrue(Buffer4.isEmpty());
    }

    @Test
    public void testExceptions(){
        RingBuffer Buffer5 = new RingBuffer(6);
        Buffer5.push(7);
        Buffer5.pop();

        Assert.assertThrows(RuntimeException.class, () ->{
            Buffer5.pop();
        });

        Assert.assertThrows(NegativeArraySizeException.class, () ->{
            new RingBuffer<>(-25);
        });
    }

    @Test
    public void testPushAndPop(){
        RingBuffer Buffer6 = new RingBuffer(6);
        RingBuffer Buffer7 = new RingBuffer(6);


        Buffer6.push(7);
        Buffer6.push(8);

        Buffer7.push(7);
        Buffer7.push(8);

        Assert.assertEquals(Buffer6.size(), Buffer7.size());
        Assert.assertEquals(Buffer7.size(), Buffer6.size());

        Buffer7.push(9);
        Assert.assertNotEquals(Buffer6.size(), Buffer7.size());
        Assert.assertNotEquals(Buffer7.size(), Buffer6.size());

        Buffer6.push(9);
        Assert.assertEquals(Buffer6.size(), Buffer7.size());
        Assert.assertEquals(Buffer7.size(), Buffer6.size());

        Assert.assertEquals(Buffer6.pop(), 7);
        Assert.assertEquals(Buffer6.pop(), 8);
        Assert.assertNotEquals(Buffer7.pop(), 9);
        Assert.assertNotEquals(Buffer6.pop(), Buffer7.pop());
        Buffer7.pop();
        Assert.assertEquals(Buffer6.size(), Buffer7.size());
    }

    @Test
    public void testIterator(){
        RingBuffer Buffer8 = new RingBuffer(2);
        RingBuffer Buffer9 = new RingBuffer(2);

        assertNotEquals(new RingBuffer(2).iterator(), new RingBuffer(2));
        assertFalse(Buffer8.iterator().hasNext());
        Buffer8.push(3);
        assertTrue(Buffer8.iterator().hasNext());

        assertThrows(UnsupportedOperationException.class,
                () -> {
                    Buffer8.iterator().remove();
                });

        Buffer8.pop();
        assertThrows(NoSuchElementException.class,
                () -> {
                    Buffer8.iterator().next();
                });

        Buffer9.push(2);
        Buffer9.push(6);
        Buffer9.iterator().next();
        assertEquals(2, Buffer9.iterator().next());
    }
}