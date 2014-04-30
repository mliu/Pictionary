package com.example.pictionary;

// TESTING NOTES:: Make sure sophia-suppport is an added library -
// Properties-Android-Library (you might need to download one of the project
// phase 2's to get it added to your workspace), also I edited the manifest, if
// yours resets yell at me to fix it
import student.TestCase;

/**
 * // -------------------------------------------------------------------------
 * /** The test case for the game controller, tests directly tests all methods
 * in the class
 * 
 * @author chris_000
 * @version Apr 30, 2014
 */

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
        game.nextPlayer();

        assertEquals(game.getCurrentPlayer(), 4);

        // test get num player
        assertEquals(game.getNumPlayers(), 5);

        // test score
        assertEquals(game.getScore(2), 0);
        game.addToScore(5, 50);
        assertEquals(game.getScore(5), 50);

    }


    public void testgetScoreList()
    {
        // Check at beginning of game
        String list =
            "ScoreList:\nPlayer 1: 0 points (The guesser)\nPlayer 2: 0 points\nPlayer 3: 0 points\nPlayer 4: 0 points\nPlayer 5: 0 points (The artist)\n";
        assertEquals(game.getScoreList(), list);

        // fake some game happening, then see if score list still outputs
// correctly
        game.addToScore(1, 20);
        game.nextPlayer();
        game.nextPlayer();
        game.addToScore(game.getCurrentPlayer(), 50);
        game.nextPlayer();
        game.setCurrentPlayer(3);
        game.addToScore(game.getCurrentPlayer(), 40);
        game.setCurrentPlayer(0);

        list =
            "ScoreList:\nPlayer 1: 20 points (The guesser)\nPlayer 2: 90 points\nPlayer 3: 90 points\nPlayer 4: 0 points\nPlayer 5: 20 points (The artist)\n";
        assertEquals(game.getScoreList(), list);

    }


    public void testisWon()
    {
        // game is not won
        assertEquals(game.isWon(), -1);
        // have some game happen
        game.nextPlayer();
        game.addToScore(game.getCurrentPlayer(), 20);
        game.nextPlayer();
        game.addToScore(game.getCurrentPlayer(), 30);

        // game is still not won
        assertEquals(game.isWon(), -1);

        // win game
        game.setCurrentPlayer(5);
        game.addToScore(game.getCurrentPlayer(), 200);
        game.nextPlayer();
        game.addToScore(game.getCurrentPlayer(), 15);

        // player 5 should have won
        assertEquals(game.isWon(), 5);
    }

}
