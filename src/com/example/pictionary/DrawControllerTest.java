package com.example.pictionary;

import junit.framework.TestCase;

/**
 * // -------------------------------------------------------------------------
 * /** Controls all information that must stay consistent throughout a game
 *
 * @author (cdd5) Chris
 * @author Edward McEnrue
 * @author Michael Liu
 * @version Apr 16, 2014
 */
public class DrawControllerTest
    extends TestCase
{
    DrawController draw;


    public void setup()
    {
        // does setup
    }


    public void testgetScore()
    {
        assertEquals(draw.getScore(), -1);
    }
}
