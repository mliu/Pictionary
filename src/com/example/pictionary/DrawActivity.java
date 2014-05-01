package com.example.pictionary;

import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

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

    /**
     * Creates the new activity for DrawActivity and unpacks the intent from
     * MainActivity.
     *
     * @param savedInstanceState
     *            The state of the running application.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        drawView = (DrawingView)this.findViewById(R.id.drawView);
        drawView.setQueue(new DrawQueue<DrawObject>());
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

    /**
     * Listens for the finishDrawing button to be clicked, and if the
     * drawingView has information entered, then the StartGuessDialog activity
     * will be called with the drawn recording data passed through an intent.
     *
     * @param view
     *            The button view named "finishDrawing"
     */
    public void finishDrawing(View view)
    {
        // Build an intent and the key value pair in response to the button.
        Intent drawingIntent = new Intent(this, StartGuessDialog.class);

        Bundle b = new Bundle();
        b.putParcelable("Drawing", drawView.getQueue());// The recorded drawing
        drawingIntent.putExtras(b);

        startActivity(drawingIntent);
    }
}
