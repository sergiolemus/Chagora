package com.example.segoo.chagora;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button callActivity = (Button) findViewById(R.id.callBttn);
        Button msgActivity = (Button) findViewById(R.id.msgBttn);
        Button updateAction = (Button) findViewById(R.id.updateBttn);

        callActivity.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent callIntent = new Intent( getApplicationContext(), CallActivity.class );

                startActivity( callIntent );
            }
        });

        msgActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent msgIntent = new Intent( getApplicationContext(), TextActivity.class );

                startActivity( msgIntent );
            }
        });

        updateAction.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                TextView usernameTextView = (TextView) findViewById(R.id.usernameTextView);
                String username = usernameTextView.getText().toString();

                usernameTextView.setText( null );

                ((BackgroundSignaling) getApplication( )).setUsername( username );
            }
        });

    }
}
