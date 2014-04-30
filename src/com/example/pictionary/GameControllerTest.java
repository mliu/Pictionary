package com.example.pictionary;

import student.TestCase;

public class GameControllerTest
    extends TestCase
{
    private GameController game;


    public void setUp()
    {
        game = new GameController();
        game.createScoreList(5);
    }


    public void testGetAndSet()
    {
        // test constructor
        assertEquals(game.getCurrentPlayer(), 1);

        // test current player
        game.setCurrentPlayer(3);
        assertEquals(game.getCurrentPlayer(), 3);

        // test get num player
        assertEquals(game.getNumPlayers(), 5);

        // test score
        assertEquals(game.getScore(2), 0);
        game.addToScore(5, 50);
        assertEquals(game.getScore(5), 50);

    }
}
