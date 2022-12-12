//Angela Sternig
//Matrikelnummer: 12003325
package at.aau.serg.exercises.ringbuffer;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class BaseTest {
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

        Assert.assertEquals(7, Buffer6.pop());

        Assert.assertEquals(Buffer6.pop(), 8);
        Assert.assertNotEquals(Buffer7.pop(), 9);
        Assert.assertNotEquals(Buffer6.pop(), Buffer7.pop());
        Buffer7.pop();
        Assert.assertEquals(Buffer6.size(), Buffer7.size());
    }
}
