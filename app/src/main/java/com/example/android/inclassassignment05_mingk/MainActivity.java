package com.example.android.inclassassignment05_mingk;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.android.inclassassignment05_mingk.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    EditText title = (EditText) findViewById(R.id.input_title);
    String mailTitle = title.getText().toString();

    EditText message = (EditText) findViewById(R.id.input_message);
    String mailMessage = message.getText().toString();

    CheckBox onlySendTitle = (CheckBox) findViewById(R.id.checkbox_send_title);
    boolean sendTitle = onlySendTitle.isChecked();

    public void sendEmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));

        if (sendTitle) {
            intent.putExtra(Intent.EXTRA_SUBJECT, mailTitle);
        } else {
            intent.putExtra(Intent.EXTRA_SUBJECT, mailTitle);
            intent.putExtra(Intent.EXTRA_TEXT, mailMessage);
        }


        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    public void launchActivity(View view) {
        Intent intent  = new Intent(this, NewActivity.class);

        if (sendTitle) {
            intent.putExtra(EXTRA_MESSAGE, mailMessage);
        } else {
            intent.putExtra(EXTRA_MESSAGE,mailTitle);
            intent.putExtra(EXTRA_MESSAGE, mailMessage);
        }



        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


        public void launchCamera(View view) {
            Intent launchCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                   if (launchCamera.resolveActivity(getPackageManager()) != null) {
                      startActivity(launchCamera);
                    }

        }

}
