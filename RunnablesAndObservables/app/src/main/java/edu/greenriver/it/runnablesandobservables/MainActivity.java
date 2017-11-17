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

    TextView message;
    EditText editText;
    Button button;

    Runnable changeText;

    Runnable tbd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = findViewById(R.id.message);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        Handler handler = new Handler();

        changeText = new ChangeTextRunnable(message, editText, handler);

        handler.post(changeText);

        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeText.run();
            }
        });*/
    }
}
