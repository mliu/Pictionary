package com.example.pictionary;

import android.view.MotionEvent;

// -------------------------------------------------------------------------
/**
 * Object that stores data about user drawing at a certain point.
 *
 * @author Pictionary Team (Chris Deisher, Edward McEnrue, Michael Liu)
 * @version Apr 16, 2014
 */
public class DrawObject
{
    private int color;
    private float x;
    private float y;
    private int event;


    // ----------------------------------------------------------
    /**
     * Create a new DrawObject object.
     *
     * @param initColor
     *            color of the draw point
     * @param posX
     *            x position of the object
     * @param posY
     *            y position of the object
     * @param initEvent
     *            type of motion event in integer form
     */
    public DrawObject(int initColor, float posX, float posY, int initEvent)
    {
        color = initColor;
        x = posX;
        y = posY;
        event = initEvent;
    }


    // ----------------------------------------------------------
    /**
     * Accessor method of the color
     *
     * @return int color of the drawpoint
     */
    public int getColor()
    {
        return color;
    }


    // ----------------------------------------------------------
    /**
     * Accessor method of the x-coordinate
     *
     * @return float of  x-coordinate
     */
    public float getX()
    {
        return x;
    }


    // ----------------------------------------------------------
    /**
     * Accessor method of the y coordinate
     *
     * @return float of y-coordinate
     */
    public float getY()
    {
        return y;
    }

    // ----------------------------------------------------------
    /**
     * Accessor method of the MotionEvent
     * @return event type of this drawobject
     */
    public int getEvent()
    {
        return event;
    }
}
