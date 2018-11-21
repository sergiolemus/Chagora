package com.example.segoo.chagora;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        Button callActivity = (Button) findViewById(R.id.callBttn);
        Button settingsActivity = (Button) findViewById(R.id.settingsBttn);
        Button cancelActivity = (Button) findViewById(R.id.cancelBttn);
        Button doneActivity = (Button) findViewById(R.id.doneBttn);

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

        cancelActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent cancelIntent = new Intent( getApplicationContext(), NewMsgActivity.class );

                startActivity( cancelIntent );
            }
        });

        doneActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                EditText firstname = (EditText) findViewById(R.id.firstnameEditText);
                Intent doneIntent = new Intent( getApplicationContext(), MsgViewActivity.class);

                doneIntent.putExtra("com.example.segoo.chagora.FIRSTNAME", firstname.getText().toString() );
                startActivity( doneIntent );
            }
        });
    }
}
