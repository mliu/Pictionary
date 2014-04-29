package com.example.pictionary;

import android.os.Parcel;

import android.os.Parcelable;

import android.view.MotionEvent;

// -------------------------------------------------------------------------
/**
 * Object that stores data about user drawing at a certain point.
 *
 * @author Pictionary Team (Chris Deisher, Edward McEnrue, Michael Liu)
 * @version Apr 16, 2014
 */
public class DrawObject implements Parcelable
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
     * Create a new DrawObject object from a parcel.
     * @param in the parcelable drawobject to create from
     */
    public DrawObject(Parcel in) {
        readFromParcel(in);
    }

    // ----------------------------------------------------------
    /**
     * Instantiates this object from a parcel
     * @param in the parcelable object to instantiate from
     */
    private void readFromParcel(Parcel in) {
        this.color = in.readInt();
        this.x = in.readFloat();
        this.y = in.readFloat();
        this.event = in.readInt();
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


    public int describeContents() {
        return 0;
    }


    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(color);
        dest.writeFloat(x);
        dest.writeFloat(y);
        dest.writeInt(event);
    }

    public static final Creator<DrawObject> CREATOR = new Creator<DrawObject>(){
        public DrawObject createFromParcel(Parcel source) {
            return new DrawObject(source);
        }

        public DrawObject[] newArray(int size) {
            return new DrawObject[size];
        }
    };
}
