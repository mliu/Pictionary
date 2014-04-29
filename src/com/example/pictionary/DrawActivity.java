package com.example.pictionary;

import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

/**
 * // -------------------------------------------------------------------------
 * /** The draw activity is used to create a canvas for the player to draw their
 * picture. This activity is called multiple times throughout the game, but it
 * is first called by the start screen, and it instantiates the game with a
 * player amount from the first MainActivity.
 *
 * @author Pictionary Team (Chris Deisher, Edward McEnrue, Michael Liu)
 * @version Apr 16, 2014
 */
public class DrawActivity
    extends Activity
{

    private DrawingView        drawView;
    private DrawController     controller;
    //private GameController controller;

    // The key value pair to send the recorded drawing to the dialog activity
    public final static String DRAWING_RECORD =
                                                  "com.Pictionary.DrawActivity.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        controller = new DrawController();
        drawView = (DrawingView) this.findViewById(R.id.drawView);
        drawView.setQueue(controller.getQueue());

        // Get the player amount from the incoming intent key value data.
        Intent mainIntent = getIntent();


//        Intent i = getIntent();
//        Deneme dene = (Deneme)i.getSerializableExtra("sampleObject");


        // TODO Make sure this isn't called a second time for 2nd round.
        //controller = (GameController)mainIntent.getSerializableExtra(MainActivity.GAME_CONTROLLER);

        // TODO Parse the player amount string to be used for the game mechanic
    }


    // Getting the button to start the StartGuessDialog activity and
    // pass the recorded drawing info below:

    /**
     * Listens for the finishDrawing button to be clicked, and if the
     * drawingview has information entered, then the StartGuessDialog activity
     * will be called with the drawn recording data passed through an intent.
     *
     * @param view
     *            The button view named "finishDrawing"
     */
    public void finishDrawing(View view)
    {
        // Build an intent and the key value pair in response to the button.
        Intent drawingIntent = new Intent(this, StartGuessDialog.class);

        // TODO Get the drawView's recorded drawing data and send it through
        // the intent below, to be relayed through the StartGuessDialog
        // Activity to be used for the GuessActivity activity.

<<<<<<< HEAD

        drawingIntent.putExtra(DRAWING_RECORD, ""); //The recorded drawing



        //drawingIntent.putExtra(DRAWING_RECORD, controller);
=======
        drawingIntent.putExtra(DRAWING_RECORD, "");
        drawingIntent.putExtra
>>>>>>> 10026cfca0affdd28a9078ddc0108fa44dff8545

        startActivity(drawingIntent);
    }

    // TODO Implement an if statement that enforces that the player has
    // drawed something. Use enables or something.
}
