package com.example.pictionary;

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
    private int x;
    private int y;


    // ----------------------------------------------------------
    /**
     * Create a new DrawObject object.
     * 
     * @param color
     *            color of the draw point
     * @param posX
     *            x position of the object
     * @param posY
     *            y position of the object
     */
    public DrawObject(int initColor, int posX, int posY)
    {
        color = initColor;
        x = posX;
        y = posY;
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
     * @return int of x-coordinate
     */
    public int getX()
    {
        return x;
    }


    // ----------------------------------------------------------
    /**
     * Accessor method of the y coordinate
     * 
     * @return int of y-coordinate
     */
    public int getY()
    {
        return y;
    }
}
