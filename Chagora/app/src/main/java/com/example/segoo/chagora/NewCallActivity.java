package com.example.segoo.chagora;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class NewCallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_call);

        Button msgActivity = (Button) findViewById(R.id.msgBttn);
        Button settingsActivity = (Button) findViewById(R.id.settingsBttn);
        Button cancelActivity = (Button) findViewById(R.id.cancelBttn);
        Button newContactActivity = (Button) findViewById(R.id.newContactBttn);

        msgActivity.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent msgIntent = new Intent( getApplicationContext(), TextActivity.class );

                startActivity( msgIntent );
            }
        });

        settingsActivity.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent settingsIntent = new Intent( getApplicationContext(), SettingsActivity.class );

                startActivity( settingsIntent );
            }
        });

        cancelActivity.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent cancelIntent = new Intent( getApplicationContext(), CallActivity.class );

                startActivity( cancelIntent );
            }
        });

        newContactActivity.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent newContactIntent = new Intent( getApplicationContext(), NewCallContactActivity.class );

                startActivity( newContactIntent );
            }
        });
    }
}
