package com.example.segoo.chagora;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class CallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);


        Button settingsActivity = (Button) findViewById(R.id.settingsBttn);
        Button msgActivity = (Button) findViewById(R.id.msgBttn);
        Button newCallActivity = (Button) findViewById(R.id.newCallBttn);

        settingsActivity.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent settingsIntent = new Intent( getApplicationContext(), SettingsActivity.class );

                startActivity( settingsIntent );
            }
        });

        msgActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent msgIntent = new Intent( getApplicationContext(), TextActivity.class );

                startActivity( msgIntent );
            }
        });

        newCallActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent newCallIntent = new Intent( getApplicationContext(), NewCallActivity.class );

                startActivity( newCallIntent );
            }
        });
    }
}
