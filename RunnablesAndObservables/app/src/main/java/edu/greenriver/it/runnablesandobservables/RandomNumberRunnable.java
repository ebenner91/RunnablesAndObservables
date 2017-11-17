package edu.greenriver.it.runnablesandobservables;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by ebenn on 11/16/2017.
 */

public class RandomNumberRunnable implements Runnable {

    private final long DELAY_TIME = 100;

    Random random;
    TextView numDisplay;
    Handler handler;
    boolean shouldRun = true;

    public RandomNumberRunnable(TextView numDisplay, Handler handler) {
        this.numDisplay = numDisplay;
        this.random = new Random();
        this.handler = handler;
    }

    @Override
    public void run() {
        if(numDisplay != null || shouldRun) {
            int randomNum = random.nextInt(100);

            numDisplay.setText(String.valueOf(randomNum));

            handler.postDelayed(this, DELAY_TIME);
        }

    }

    public void start() {
        shouldRun = true;
    }

    public void stop() {
        shouldRun = false;
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
