package com.example.pictionary;

import android.widget.Toast;
import android.widget.EditText;
import android.content.Intent;
import android.view.View;
import com.example.pictionary.R;
import android.os.Bundle;
import android.app.Activity;

/**
 * // -------------------------------------------------------------------------
 * /** The main activity serves as the landing screen for the Pictionary app. It
 * requests the player to input how many players will be in the game, and it
 * also has a start button to begin the game and call the drawActivty.
 *
 * @author Pictionary Team (Chris Deisher, Edward McEnrue, Michael Liu)
 * @version Apr 16, 2014
 */

public class MainActivity
    extends Activity
{

    /**
     * onCreate is called to initialize all activities in Android. This activity
     * is the first.
     *
     * @param savedInstanceState
     *            The state of the app when re-opening it or booting up.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
     * Listens for the startDrawing button to be clicked, and if the editText
     * has information entered, then the DrawActivity activity will be called
     * with the player amount data passed through an intent.
     *
     * @param view
     *            The button view named "startDrawing."
     */
    public void startDrawing(View view)
    {

        EditText editTextPlayerCount =
            (EditText)findViewById(R.id.playerAmount);

        try
        {
            int playerCount =
                Integer.valueOf(editTextPlayerCount.getText().toString());

            if (playerCount < 3 && playerCount < 13)
            {
                Toast.makeText(
                    getApplicationContext(),
                    "Enter a valid number",
                    Toast.LENGTH_SHORT).show();
            }
            else
            {
                // Build an intent and the key value pairs in response to the
                // button.
                GameController gameState =
                    ((GameController)getApplicationContext());
                gameState.createScoreList(playerCount);

                Intent mainIntent = new Intent(this, DrawActivity.class);
                startActivity(mainIntent);
            }
        }
        catch (NumberFormatException e) // Ensures the editText isn't blank.
        {
            Toast.makeText(
                getApplicationContext(),
                "Enter a valid number",
                Toast.LENGTH_SHORT).show();
        }

    }
}
