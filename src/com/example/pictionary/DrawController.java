package com.example.pictionary;

/**
 * // -------------------------------------------------------------------------
 * /** Write a one-sentence summary of your class here. Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 *
 * @author Pictionary Team (Chris Deisher, Edward McEnrue, Michael Liu)
 * @version Apr 16, 2014
 */
public class DrawController {
    // Our fields
    private String guessWord;
    private DrawQueue<DrawObject> queue;
    private int size;
    private int currentPos;

    /**
     * Constructor for the class, takes the attempted word
     *
     * @param redrawView
     *            the view of this drawing
     */
    public DrawController(DrawQueue<DrawObject> initQueue) {
        guessWord = "";
        queue = initQueue;
        currentPos = 0;
        size = initQueue.size();
    }

    // ----------------------------------------------------------
    /**
     * Sets the guessWord for this drawing
     *
     * @param word
     *            the string representing this drawing
     */
    public void setWord(String word) {
        guessWord = word;
    }

    // ----------------------------------------------------------
    /**
     * Gets the word of this drawController
     *
     * @return guessWord string representing this drawing
     */
    public String getWord() {
        return guessWord;
    }

    // ----------------------------------------------------------
    /**
     * Tells if there is another step in the queue
     *
     * @return true is queue is empty, else false
     */
    public boolean hasNext() {
        return !queue.isEmpty();
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
     *
     * @return int points earned
     */
    public int getScore() {
        if (queue.isEmpty()) {
            return 10;
        }
        return (int) (20 + (100 * (size - currentPos) / (float) size));
    }
}
