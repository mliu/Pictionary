package com.example.pictionary;

import android.os.Parcel;

import android.os.Bundle;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test class for the DrawObject
 *
 * @author Pictionary Team (Chris Deisher, Edward McEnrue, Michael Liu)
 * @version Apr 16, 2014
 */
public class DrawObjectTest extends TestCase {

    private DrawObject object;

    // ----------------------------------------------------------
    /**
     * Sets up the test case
     */
    public void setUp() {
        object = new DrawObject(0xFF000000, 10f, 10f, 1);
    }

    // ----------------------------------------------------------
    /**
     * Tests the getColor() method in DrawObject
     */
    public void testGetColor() {
        assertEquals(object.getColor(), 0xFF000000);
    }

    // ----------------------------------------------------------
    /**
     * Tests the getX() method in DrawObject
     */
    public void testGetX() {
        assertEquals(object.getX(), 10f, 0.001);
    }

    // ----------------------------------------------------------
    /**
     * Tests the getY() method in DrawObject
     */
    public void testGetY() {
        assertEquals(object.getY(), 10f, 0.001);
    }

    // ----------------------------------------------------------
    /**
     * Tests the getEvent() method in DrawObject
     */
    public void testGetEvent() {
        assertEquals(object.getEvent(), 1);
    }

    // ----------------------------------------------------------
    /**
     * Tests the describeContents() method in DrawObject
     */
    public void testDescribeContents() {
        assertEquals(object.describeContents(), 0);
    }

    // ----------------------------------------------------------
    /**
     * Tests placing DrawObject in a Parcel and extracting that data again
     */
    public void testParcel() {
        Bundle b = new Bundle();
        b.putParcelable("tag", object);
        Parcel parcel = Parcel.obtain();
        b.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        Bundle b2 = parcel.readBundle();
        b2.setClassLoader(DrawObject.class.getClassLoader());
        DrawObject temp = b2.getParcelable("tag");
        assertEquals(object.getColor(), temp.getColor());
        assertEquals(object.getX(), temp.getX(), 0.001);
        assertEquals(object.getY(), temp.getY(), 0.001);
        assertEquals(object.getEvent(), temp.getEvent());
    }
}
