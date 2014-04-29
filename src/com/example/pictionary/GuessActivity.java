package com.example.pictionary;


import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import com.example.pictionary.R;
import android.os.Bundle;
import android.app.Activity;

/**
 * // -------------------------------------------------------------------------
 * /** The GuessActivity is where the next player assumes control and the
 * recorded drawing begins to be displayed. The activity allows the player
 * to enter text and make guesses. If the guess is correct, then the player
 * is awarded a certain amount of points, otherwise, they will continue to make
 * guesses until the time runs out, in which case, no points are awarded.
 *
 * @author Pictionary Team (Chris Deisher, Edward McEnrue, Michael Liu)
 * @version Apr 16, 2014
 */
public class GuessActivity
    extends Activity
{

    private String drawingName;
    private DrawQueue<DrawObject> queue;
    private RedrawingView redrawingView;
    private DrawController controller;

    // The key value pair to send the recorded drawing to the dialog activity
    public final static String GUESS_RECORD =
                                                  "com.Pictionary.GuessActivity.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);

        // TODO Get the recorded drawing data from the incoming intent key
        // value pair relayed from the StartGuessDialog activity, and sent
        // from the DrawActivity activity.
        Intent drawingIntent = getIntent();
        drawingName = drawingIntent.getStringExtra("com.Pictionary.StartGuessDialog.DRAWINGNAME");
        Bundle b = this.getIntent().getExtras();
        if (b != null) {
            queue = b.getParcelable("Drawing");
        }
        redrawingView = (RedrawingView) this.findViewById(R.id.redrawingView);
        System.out.println(redrawingView);
        controller = new DrawController(redrawingView);
        controller.setQueue(queue);
        controller.setWord(drawingName);

        while (controller.hasNext()) {
            controller.step();
        }

//        Thread thread1 = new Thread() {
//            public void run() {
//                if (controller.hasNext()) {
//                    try {
//                        sleep(500);
//                        controller.step();
//                    }
//                    catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//        thread1.start();
    }



    // Getting the button to start the ScoreUpdateActivity activity and
    // pass the win/loss data below:

    /**
     * Listens for the finishGuessing button to be clicked, wherein this
     * method will check if the guess in the guessBox view is the correct
     * name as the drawing's name. If it is, then the score will update with
     * a win and the score screen will activate.
     *
     * @param view
     *            The button view named "finishGuessing"
     */
    public void finishGuessing(View view)
    {

        EditText nameGuessBox = (EditText)findViewById(R.id.guessBox);
        if(nameGuessBox.getText().toString().equals(drawingName))
        {
            // Build an intent and the key value pair in response to the button.
            Intent guessIntent = new Intent(this, ScoreUpdateActivity.class);



            // TODO Still need to gather and send the guess data to the
            // ScoreUpdateActivity.
            guessIntent.putExtra(GUESS_RECORD, "");



            //MainActivity.controller.addToScore(MainActivity.controller.getCurrentPlayer(), 15);
            //MainActivity.controller.getScore(1);


            startActivity(guessIntent);
        }


    }

    // TODO The count-down stuff still needs to be implemented. I.E.
    // TODO There has to be a timer so that a lose condition happens if the
    // TODO player can't guess the drawing.



}
