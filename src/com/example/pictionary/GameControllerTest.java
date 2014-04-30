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
 * @author Christopher Deisher
 * @version Apr 30, 2014
 */

public class GameControllerTest
    extends TestCase
{
    private GameController game;


    /**
     * Creates a game with five players
     */
    public void setUp()
    {
        game = new GameController();
        game.createScoreList(5);
    }


    /**
     * Tests the get and set methods (or roughly equivalent ones we have)
     */
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


    /**
     * tests the getScoreList() method, which returns a string representation of
     * scores for use as a score list.
     */
    public void testgetScoreList()
    {
        // Check at beginning of game
        // this also test the createScoreList() method called in setUp

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
        game.setCurrentPlayer(1);

        list =
            "ScoreList:\nPlayer 1: 20 points (The guesser)\nPlayer 2: 0 points\nPlayer 3: 90 points\nPlayer 4: 0 points\nPlayer 5: 0 points (The artist)\n";
        assertEquals(game.getScoreList(), list);

    }


    /**
     * Tests the isWon() method, which returns -1 if no winner and the player
     * number if there is a winner
     */
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
        game.addToScore(game.getCurrentPlayer(), 700);
        game.nextPlayer();
        game.addToScore(game.getCurrentPlayer(), 15);

        // player 5 should have won
        assertEquals(game.isWon(), 5);
    }


    /**
     * tests the receiveDrawScore() method
     */
    public void testreceiveDrawScore()
    {
        game.receiveDrawScore(50);

        String list =
            "ScoreList:\nPlayer 1: 50 points (The guesser)\nPlayer 2: 0 points\nPlayer 3: 0 points\nPlayer 4: 0 points\nPlayer 5: 50 points (The artist)\n";

        assertEquals(game.getScoreList(), list);

        game.nextPlayer();
        game.receiveDrawScore(60);
        list =
            "ScoreList:\nPlayer 1: 110 points (The artist)\nPlayer 2: 60 (The guesser)points\nPlayer 3: 0 points\nPlayer 4: 0 points\nPlayer 5: 50 points\n";

    }

}
