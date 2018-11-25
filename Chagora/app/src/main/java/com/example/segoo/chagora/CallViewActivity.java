package com.example.segoo.chagora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CallViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_view);

        Button msgActivity = (Button) findViewById(R.id.text);
        Button callActivity = (Button) findViewById(R.id.call);
        Button settingsActivity = (Button) findViewById(R.id.settings);
        Button backActivity = (Button) findViewById(R.id.backButton);
        Button voiceActivity = (Button) findViewById(R.id.voiceCallButton);
        Button videoActivity = (Button) findViewById(R.id.videoCallButton);

        callActivity.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent callIntent = new Intent( getApplicationContext(), CallActivity.class );

                startActivity( callIntent );
            }
        });

        settingsActivity.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent settingsIntent = new Intent( getApplicationContext(), SettingsActivity.class );

                startActivity( settingsIntent );
            }
        });

        backActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent backIntent = new Intent( getApplicationContext(), CallActivity.class );

                startActivity( backIntent );
            }
        });
        msgActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent msgIntent = new Intent( getApplicationContext(), TextActivity.class );

                startActivity( msgIntent );
            }
        });

        if( getIntent().hasExtra("com.example.segoo.chagora.NAME") )
        {
            TextView firstnameView = (TextView) findViewById(R.id.nameTextView);

            String firstname = getIntent().getExtras().getString("com.example.segoo.chagora.NAME");

            firstnameView.setText( firstname );
        }
        if( getIntent().hasExtra("com.example.segoo.chagora.PHONENUMBER") )
        {
            TextView phoneView = (TextView) findViewById(R.id.phoneTextView);

            String phoneNumber = getIntent().getExtras().getString("com.example.segoo.chagora.PHONENUMBER");

            phoneView.setText( phoneNumber );
        }
    }
}


