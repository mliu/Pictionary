package com.example.pictionary;

import java.util.Queue;

import java.util.Iterator;


/**
 * // -------------------------------------------------------------------------
 * /** Write a one-sentence summary of your class here. Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 *
 * @author Pictionary Team (Chris Deisher, Edward McEnrue, Michael Liu)
 * @version Apr 16, 2014
 */
public class DrawController
{
    // Our fields
    private String guessWord;
    private DrawQueue<DrawObject> draw;
    private int currentPos;
    /**
     * Constructor for the class, takes the attempted word
     *
     * @param word
     */
    public DrawController(String word)
    {
        guessWord = word;
        draw = new DrawQueue<DrawObject>();
        currentPos = 0;
    }

    // ----------------------------------------------------------
    /**
     * Adds a new point for user drawing
     * @param color the color selected
     * @param x x-coordinate of point
     * @param y y-coordinate of point
     */
    public void addData(int color, int x, int y)
    {
        DrawObject temp = new DrawObject(color, x, y);
        draw.add(temp);
    }

    // ----------------------------------------------------------
    /**
     * Called when user is drawing and clicks undo
     */
    public void undo() {
        draw.remove();
    }

    // ----------------------------------------------------------
    /**
     * Called when redrawing for user
     */
    public DrawObject pop() {
        currentPos++;
        return draw.remove();
    }

    // ----------------------------------------------------------
    /**
     * Gets score when user guesses correctly
     * @return int points earned
     */
    public int getScore() {
        if(draw.size() == 0) {
            return 0;
        }
        return guessWord.length() * (int) ((draw.size() - currentPos)/draw.size());
    }
}
