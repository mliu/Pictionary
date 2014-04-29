package com.example.pictionary;


import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import com.example.pictionary.R;
import android.os.Bundle;
import android.app.Activity;

/**
 * // -------------------------------------------------------------------------
 * /** The StartGuessDialog Activity is used to relay the drawingView's data
 * to the StartGuessDialog class, because our team could not figure out how
 * to use an actual dialog fragment. It's sole purpose is to allow the player
 * to give the android device to the next player, so that they can start
 * the recording at their leisure and continue the game.
 *
 * @author Pictionary Team (Chris Deisher, Edward McEnrue, Michael Liu)
 * @version Apr 16, 2014
 */
public class StartGuessDialog
    extends Activity
{


    // The key value pair to send the recorded drawing to the dialog activity
    public final static String DRAWING_TRANSFER_RECORD =
                                                  "com.Pictionary.StartGuessDialog.DRAWINGNAME";


    private GameController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_guess_dialog);

        // TODO Get the recorded drawing data from the incoming intent key
        // value pair to be relayed to the GuessActivity.
        // Or possibly just send the same intent to the next one and just make
        // a private intent for that function.
        Intent drawingIntent = getIntent();

        //controller = (GameController)drawingIntent.getSerializableExtra(MainActivity.GAME_CONTROLLER);



    }



    // Getting the button to start the ScoreUpdateActivity activity and
    // pass the win/loss data below:

    /**
     * Listens for the startGuessing button click, wherein it is assumed
     * player 2 is now in control and wants to begin guessing, so the
     * GuessActivity is called with an intent
     *
     * @param view
     *            The button view named "startGuessing"
     */
    public void startGuessing(View view)
    {
        // Build an intent and the key value pair in response to the button.
        Intent relayDrawingIntent = new Intent(this, GuessActivity.class);


        EditText drawingName = (EditText)findViewById(R.id.drawingName);

        // TODO pass in the drawing name to be used.
        relayDrawingIntent.putExtra(DRAWING_TRANSFER_RECORD, drawingName.getText().toString());


        //drawingIntent.putExtra(DRAWING_RECORD, controller);

        //relayDrawingIntent.putExtra("ControllerTransferTest", controller);




        startActivity(relayDrawingIntent);
    }



}
