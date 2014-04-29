package com.example.pictionary;


import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;
import com.example.pictionary.R;
import android.os.Bundle;
import android.app.Activity;

/**
 * // -------------------------------------------------------------------------
 * /** The ScoreUpdateActivity is where the player is told their current score
 * for the round, and it is also where the player is to press the button in
 * order to begin their drawing turn.
 *
 * @author Pictionary Team (Chris Deisher, Edward McEnrue, Michael Liu)
 * @version Apr 16, 2014
 */
public class ScoreUpdateActivity
    extends Activity
{


    // The key value pair to send the recorded score to send for the new round's
    // DrawActivity.
    public final static String SCORE_RECORD =
                                                  "com.Pictionary.ScoreUpdateActivity.MESSAGE";

    //private TextView scoreDisplay = (TextView)findViewById(R.id.scoreDisplay);

    /**
     * Creates the new activity for ScoreUpdateActivity and unpacks the
     * intent from GuessActivity.
     *
     * @param savedInstanceState
     *            The state of the running application.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_update);




        // TODO Get the recorded drawing data from the incoming intent key
        // value pair relayed from the StartGuessDialog activity, and sent
        // from the DrawActivity activity.
        Intent guessIntent = getIntent();

        //scoreDisplay.setText(MainActivity.controller.getScoreList());
        //scoreDisplay.setText("bagger 849o5349");

        TextView scoreDisplay = (TextView)findViewById(R.id.scoreDisplay);

        GameController appState = ((GameController)getApplicationContext());
        appState.nextPlayer();
        appState.addToScore(appState.getCurrentPlayer(), 10);
        String state = "" + appState.getScore(appState.getCurrentPlayer());

        scoreDisplay.setText(""+ state);
    }




    // TODO I suppose a win game condition has to be eventually implemented.





    // Getting the button to start the next round's DrawActivity and pass relevant
    // win/loss rollover data below:


    // TODO update description once relevant behavior is known.
    /**
     * Listens for the beginNewRound button to be clicked, wherein this method
     * will start the DrawActivity again.
     *
     * @param view
     *            The button view named "beginNewRound"
     */
    public void beginNewRound(View view)
    {
        // Build an intent and the key value pair in response to the button.
        Intent newRoundIntent = new Intent(this, DrawActivity.class);

        // TODO Still need to gather and send the guess data to the
        // DrawActivity.
        newRoundIntent.putExtra(SCORE_RECORD, "");

        startActivity(newRoundIntent);

        // TODO probably will have to destroy the previous drawing somehow.
        // TODO ^^^^ How do you store data throughout the app?
    }




}
