package com.example.pictionary;

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
public class GameController implements Serializable {
    private ArrayList<Integer> scorelist;
    private int currentPlayer;
    private DrawController controller;

    /**
     * sets up our game controller with the correct number of players
     */
    public GameController(int numplayers) {
        scorelist = new ArrayList<Integer>(numplayers);
        currentPlayer = 1;
    }

    public void onSuccessfulGuess() {
        // handles score and whatnot after successful guess
    }

    /**
     * gets number of players
     *
     * @return numplayers
     */
    public int getNumPlayers() {
        return scorelist.size();
    }

    /**
     * returns an ArrayList of everyones scores
     *
     * @param playernum
     *            is the player's number you want the score of;
     * @return score
     */
    public int getScore(int playernum) {
        return scorelist.get(playernum - 1);
    }

    /**
     * set the name for the player
     *
     * @return the number representation of the current player
     */
    public int nextPlayer() {
        currentPlayer += 1;
        if (currentPlayer > scorelist.size()) {
            currentPlayer = 1;
        }
        return currentPlayer;
    }

    public String getScoreList() {
        String endresult = "ScoreList:\n";

        for (int i = 1; i <= scorelist.size(); i++) {
            endresult = "Player " + i + ": " + scorelist.get(i - 1) + "\n";
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
        for (int i = 0; i < scorelist.size(); i++) {
            if (scorelist.get(i) > 20) {
                if (currentwinner == -1) {
                    currentwinner = i;
                }
                else {
                    if (scorelist.get(i) > scorelist.get(currentwinner)) {
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
        scorelist.set(playernum, scorelist.get(playernum) + score);
    }

}
