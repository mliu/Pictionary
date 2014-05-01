package com.example.pictionary;

import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import com.example.pictionary.R;
import android.os.Bundle;
import android.app.Activity;

/**
 * // -------------------------------------------------------------------------
 * /** The StartGuessDialog Activity is used to relay the drawingView's data to
 * the StartGuessDialog class, because our team could not figure out how to use
 * an actual dialog fragment. It's sole purpose is to allow the player to give
 * the android device to the next player, so that they can start the recording
 * at their leisure and continue the game.
 *
 * @author Pictionary Team (Chris Deisher, Edward McEnrue, Michael Liu)
 * @version Apr 16, 2014
 */
public class StartGuessDialog
    extends Activity
{
    private DrawQueue<DrawObject> queue;

    /**
     * Creates the new activity for StartGuessDialog and unpacks the intent from
     * DrawActivity.
     *
     * @param savedInstanceState
     *            The state of the running application.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_guess_dialog);

        Bundle b = this.getIntent().getExtras();
        if (b != null)
        {
            queue = b.getParcelable("Drawing");
        }
    }

    // ----------------------------------------------------------
    /**
     * Overrides the back button to direct to nothing
     */
    @Override
    public void onBackPressed()
    {
        //Left blank intentionally
    }


    // Getting the button to start the ScoreUpdateActivity activity and
    // pass the win/loss data below:

    /**
     * Listens for the startGuessing button click, wherein it is assumed player
     * 2 is now in control and wants to begin guessing, so the GuessActivity is
     * called with an intent
     *
     * @param view
     *            The button view named "startGuessing"
     */
    public void startGuessing(View view)
    {
        // Build an intent and the key value pair in response to the button.
        Intent relayDrawingIntent = new Intent(this, GuessActivity.class);

        EditText drawingName = (EditText)findViewById(R.id.drawingName);

        relayDrawingIntent.putExtra("drawing_name", drawingName
            .getText().toString()); // The players name for their drawing.
        // The recorded drawing queue is relayed to the GuessActivity
        Bundle b = new Bundle();
        b.putParcelable("Drawing", queue);
        relayDrawingIntent.putExtras(b);
        GameController gameState =
            ((GameController)getApplicationContext());
        gameState.nextPlayer(); // Set the guesser to be the current player.
        startActivity(relayDrawingIntent);
    }

}
