package edu.greenriver.it.runnablesandobservables;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView numDisplay;
    EditText editText;
    Button button;

    ChangeTextRunnable changeText;

    RandomNumberRunnable randomNumberRunnable;

    boolean isRunning;

    Runnable tbd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numDisplay = findViewById(R.id.randNumDisplay);

        Handler handler = new Handler();

        button = findViewById(R.id.toggleCycle);


        randomNumberRunnable = new RandomNumberRunnable(numDisplay, handler);



        randomNumberRunnable.run();
        isRunning = true;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isRunning) {
                    randomNumberRunnable.stop();
                } else {
                    randomNumberRunnable.start();
                }
            }
        });






/*        message = findViewById(R.id.message);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);



        changeText = new ChangeTextRunnable(message, editText, handler);

        handler.post(changeText);*/

        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeText.run();
            }
        });*/
    }

/*    @Override
    protected void onStop() {
        super.onStop();

        changeText.stopRunnable();
    }*/
}
