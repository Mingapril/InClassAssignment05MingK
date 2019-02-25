package com.example.android.inclassassignment05_mingk;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private EditText title;
    private EditText message;
    private CheckBox onlySendTitle;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (EditText) findViewById(R.id.input_title);
        message = (EditText) findViewById(R.id.input_message);
        onlySendTitle = (CheckBox) findViewById(R.id.checkbox_send_title);
    }

        public void sendEmail (View view){
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));

            if (onlySendTitle.isChecked()) {
                intent.putExtra(Intent.EXTRA_SUBJECT, title.getText().toString());
            } else {
                intent.putExtra(Intent.EXTRA_SUBJECT, title.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
            }


            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

        }

        public void launchActivity (View view){
            Intent intent = new Intent(this, NewActivity.class);
            intent.putExtra("TITLE", title.getText().toString());
            if (onlySendTitle.isChecked() == false) {
                intent.putExtra("MESSAGE", message.getText().toString());
            } else {
                intent.putExtra("MESSAGE", (String) null);

            }

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }


        public void launchCamera (View view){
            Intent launchCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            if (launchCamera.resolveActivity(getPackageManager()) != null) {
                startActivity(launchCamera);
            }

        }

}
