package com.example.lifecyclebidirectionalapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

@SuppressWarnings("SpellCheckingInspection")
public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "LifecycleCallback";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView tvReceived = findViewById(R.id.tvReceived);
        final EditText etReply = findViewById(R.id.etReply);
        Button btnReply = findViewById(R.id.btnReply);

        String receivedData = getIntent().getStringExtra("EXTRA_FORWARD_DATA");
        if (receivedData != null && !receivedData.isEmpty()) {
            tvReceived.setText("Received Data: " + receivedData);
        }

        btnReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String replyMessage = etReply.getText().toString().trim();
                Intent returnIntent = new Intent();
                returnIntent.putExtra("EXTRA_REPLY_DATA", replyMessage);
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });

        Log.d(TAG, "SecondActivity: onCreate called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "SecondActivity: onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "SecondActivity: onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "SecondActivity: onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "SecondActivity: onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "SecondActivity: onDestroy called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "SecondActivity: onRestart called");
    }
}
