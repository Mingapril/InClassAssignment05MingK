package com.example.android.inclassassignment05_mingk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent intent = getIntent();

        TextView textView = findViewById(R.id.new_message);
        textView.setText(intent.getStringExtra("MESSAGE"));
        setTitle(intent.getStringExtra("TITLE"));

    }
}
