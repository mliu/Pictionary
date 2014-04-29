package com.example.pictionary;

import android.view.MotionEvent;

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
    private DrawQueue<DrawObject> queue;
    private int size;
    private int currentPos;
    private RedrawingView view;
    /**
     * Constructor for the class, takes the attempted word
     *
     * @param redrawView the view of this drawing
     */
    public DrawController(RedrawingView redrawView)
    {
        guessWord = "";
        queue = new DrawQueue<DrawObject>();
        currentPos = 0;
        view = redrawView;
    }

    // ----------------------------------------------------------
    /**
     * Sets the guessWord for this drawing
     * @param word the string representing this drawing
     */
    public void setWord(String word) {
        guessWord = word;
    }

    // ----------------------------------------------------------
    /**
     * Calls on the redrawview to step through and redraw the user drawing
     */
    public void step() {
        DrawObject temp = queue.remove();
        view.step(temp);
    }

    // ----------------------------------------------------------
    /**
     * Tells if there is another step in the queue
     * @return true is queue is empty, else false
     */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    // ----------------------------------------------------------
    /**
     * Sets the queue in this controller
     * @param q queue to set this drawqueue to
     */
    public void setQueue(DrawQueue<DrawObject> q) {
        queue = q;
        size = queue.size();
    }

    // ----------------------------------------------------------
    /**
     * Accessor method for the drawqueue
     * @return the drawqueue
     */
    public DrawQueue<DrawObject> getQueue() {
        return queue;
    }

    // ----------------------------------------------------------
    /**
     * Called when user is drawing and clicks undo
     */
    public void undo() {
        queue.remove();
    }

    // ----------------------------------------------------------
    /**
     * Called when redrawing for user
     */
    public DrawObject pop() {
        currentPos++;
        return queue.remove();
    }

    // ----------------------------------------------------------
    /**
     * Gets score when user guesses correctly
     * @return int points earned
     */
    public int getScore() {
        if(queue.isEmpty()) {
            return 0;
        }
        return (int) (100 * ((size - currentPos)/size));
    }
}
