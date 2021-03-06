package com.example.seanmedlin.day1challenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    TextView mTextView;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        mTextView = findViewById(R.id.random_number_b_text_view);
        mButton = findViewById(R.id.activity_b_button);

        Intent intent = getIntent();
        Integer randomNumber = intent.getIntExtra("randomNumber", 0);
        mTextView.setText(randomNumber.toString());
    }

    private int generateRandomNumber() {
        int min = 0;
        int max = 10;
        int range = max - min + 1;
        int rand = (int) (Math.random() * range) + min;

        return rand;
    }

    public void startActivityA(android.view.View view) {
        int rand = generateRandomNumber();
        Intent intent = new Intent(ActivityB.this, ActivityA.class);
        intent.putExtra("randomNumber", rand);
        startActivity(intent);
    }

}
