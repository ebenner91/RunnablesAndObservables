package edu.greenriver.it.runnablesandobservables;

import android.os.Handler;
import android.widget.EditText;
import android.widget.TextView;



/**
 * Created by ebenn on 11/16/2017.
 *
 * This runnable is created to update a textview with the contents of an edittext
 * every 25ms
 */

public class ChangeTextRunnable implements Runnable {
    private final long DELAY_TIME = 25;

    TextView message;
    EditText userInput;
    Handler handler;

    boolean shouldRun = true;

    public ChangeTextRunnable(TextView message, EditText userInput, Handler handler) {
        this.message = message;
        this.userInput = userInput;
        this.handler = handler;
    }

    public void stopRunnable() {
        shouldRun = false;
    }

    @Override
    public void run() {
        if(message == null || !shouldRun) return;

        if(userInput != null) {
            message.setText(userInput.getText());
        } else {
            message.setText("Something went wrong!");
        }

        if(shouldRun) {
            handler.postDelayed(this, DELAY_TIME);
        }

    }
}
