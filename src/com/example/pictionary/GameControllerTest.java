package com.example.pictionary;

import android.test.AndroidTestCase;

public class GameControllerTest
    extends student.TestCase
{
    private GameController game;


    public void setUp()
    {
        game = new GameController();
    }


    /**
     * a test test to see if this works
     */
    public void testOne()
    {
        assertEquals(game.getCurrentPlayer(), 1);
    }
}
