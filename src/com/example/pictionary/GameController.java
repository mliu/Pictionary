package com.example.pictionary;

import android.app.Application;
import java.util.ArrayList;
import java.io.Serializable; // Ability to pass objects between activities.

/**
 * // -------------------------------------------------------------------------
 * /** Controls all information that must stay consistent throughout a game. It
 * implements the Serializable interface in order to be shared between each
 * activity.
 *
 * @author (cdd5) Chris
 * @author Edward McEnrue
 * @author Michael Liu
 * @version Apr 16, 2014
 */
public class GameController extends Application{


    public ArrayList<Integer> scoreList;
    public int currentPlayer;
    public DrawController controller;


    public GameController()
    {
        currentPlayer = 1;
    }

    //this code is pointless
//    /**
//     * sets up our game controller with the correct number of players
//     */
//    public GameController(int numplayers) {
//        scorelist = new ArrayList<Integer>(numplayers);
//        currentPlayer = 1;
//    }


    public void onSuccessfulGuess() {
        // handles score and whatnot after successful guess
    }

    public void createScoreList(int numplayers)
    {
        scoreList = new ArrayList<Integer>();
        for(int i = 0; i < numplayers; i++)
        {
            scoreList.add(0);
        }
    }

    /**
     * gets number of players
     *
     * @return numplayers
     */
    public int getNumPlayers() {
        return scoreList.size();
    }

    /**
     * returns an ArrayList of everyones scores
     *
     * @param playernum
     *            is the player's number you want the score of;
     * @return score
     */
    public int getScore(int playernum) {
        return scoreList.get(playernum - 1);
    }

    /**
     * set the name for the player
     *
     * @return the number representation of the current player
     */
    public int nextPlayer() {
        currentPlayer += 1;
        if (currentPlayer > scoreList.size()) {
            currentPlayer = 1;
        }
        return currentPlayer;
    }

    public String getScoreList() {
        String endresult = "ScoreList:\n";

        for (int i = 1; i <= scoreList.size(); i++) {
            endresult = "Player " + i + ": " + scoreList.get(i - 1) + "\n";
        }

        return endresult;
    }

    /**
     * gets the current player
     *
     * @return the players numbers
     */
    public int getCurrentPlayer() {
        // return the current player number
        return currentPlayer;
    }

    /**
     * tells you if the round/game is won yet
     *
     * @return value
     */
    public int isWon() {
        int currentwinner = -1;
        for (int i = 0; i < scoreList.size(); i++) {
            if (scoreList.get(i) > 20) {
                if (currentwinner == -1) {
                    currentwinner = i;
                }
                else {
                    if (scoreList.get(i) > scoreList.get(currentwinner)) {
                        currentwinner = i;
                    }
                }
            }
        }
        return currentwinner + 1;
    }

    /**
     * sets the score
     *
     * @param playernum
     *            the players number
     * @param score
     *            the score to add
     */
    public void addToScore(int playernum, int score) {
        // TODO probs change based on time/percentage and how I get info
        scoreList.set(playernum - 1, scoreList.get(playernum - 1) + score);
    }
    //TODO change all these playernum -1 things to just add playernum+1 in the scorelist jesus fuck

}
