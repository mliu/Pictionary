package com.example.pictionary;

import java.util.NoSuchElementException;
import java.util.ArrayList;
import android.os.Parcel;
import student.TestCase;

/**
 * // -------------------------------------------------------------------------
 * /** Tests for the DrawQueue and methods
 *
 * @author Chris
 * @version Apr 30, 2014
 */
public class DrawQueueTest
    extends TestCase
{
    private DrawQueue queue;


    /**
     * Sets up everything
     */
    public void setUp()
    {
        queue = new DrawQueue<String>();
    }


    /**
     * private method to test the parcel queue
     */
    private void makeParcelQueue()
    {
        queue = new DrawQueue<DrawObject>(Parcel.obtain());
    }


    /**
     * Private method to add things to queue
     */
    private void addThings()
    {
        queue.add("ONE");
        queue.add("TWO");
        queue.add("THREE");
        queue.add("FOUR");

    }


    /**
     * tests the remove, add, and addAll methods
     */
    public void testAddandRemove()
    {
        queue.add("ONE");
        assertEquals(queue.remove(), "ONE");
        ArrayList<String> test = new ArrayList<String>();
        test.add("TWO");
        queue.addAll(test);
        assertEquals(queue.remove(), "TWO");
        test.add("THREE");
        queue.addAll(test);

        assertEquals(queue.remove(), "TWO");
        queue.removeAll(test);
        assertTrue(queue.isEmpty());
    }


    /**
     * tests clear and empty
     */
    public void testClearandEmpty()
    {
        this.addThings();
        assertFalse(queue.isEmpty());
        queue.clear();
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }


    /**
     * Tests the two contains method
     */
    public void testContains()
    {
        this.addThings();
        assertTrue(queue.contains("ONE"));
        ArrayList<String> test = new ArrayList<String>();
        test.add("ONE");
        test.add("TWO");
        assertTrue(queue.containsAll(test));
    }


    /**
     * Tests the retain method
     */
    public void testRetain()
    {
        this.addThings();
        this.addThings();
        ArrayList<String> test = new ArrayList<String>();
        test.add("ONE");
        queue.retainAll(test);
        assertEquals(queue.size(), 2);
        assertEquals("ONE", queue.remove());
    }


    /**
     * tests the size
     */
    public void testSize()
    {
        this.addThings();
        assertEquals(queue.size(), 4);
        this.addThings();
        assertEquals(queue.size(), 8);
        queue.clear();
        assertEquals(queue.size(), 0);

    }


    /**
     * tests the element method
     */
    public void testElement()
    {
        Exception ex = null;
        try
        {
            queue.element();
        }
        catch (Exception e)
        {
            ex = e;
        }
        assertNotNull(ex);
        assertTrue(ex instanceof NoSuchElementException);
        assertEquals(ex.getMessage(), "The Queue is Empty");

        this.addThings();
        assertEquals(queue.element(), "ONE");
    }


    /**
     * Tests offer and peek, and poll
     */
    public void testOfferandPeek()
    {
        assertNull(queue.poll());
        assertNull(queue.peek());
        queue.offer("ONE");
        assertEquals("ONE", queue.peek());
        assertEquals("ONE", queue.poll());
        assertEquals(0, queue.size());
    }


    /**
     * Tests the methods of the Parcelable Interface
     */
    public void testParcel()
    {
        this.makeParcelQueue();
        assertEquals(1, queue.describeContents());
        queue.writeToParcel(Parcel.obtain(), 1);

        assertEquals(1, queue.describeContents());

    }

}
