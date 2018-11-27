package com.example.segoo.chagora;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MsgViewActivity extends AppCompatActivity {

    msgAdapter msgDisplay;
    msgAPI API;
    String firstname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg_view);

        Button msgActivity = (Button) findViewById(R.id.msgBttn);
        Button callActivity = (Button) findViewById(R.id.callBttn);
        Button settingsActivity = (Button) findViewById(R.id.settingsBttn);
        Button backActivity = (Button) findViewById(R.id.backBttn);

        Button sendAction = (Button) findViewById(R.id.sendBttn);

        ArrayList<String> messages = new ArrayList<String>();
        ArrayList<String> fromList = new ArrayList<String>();
        ListView msgListView = (ListView) findViewById(R.id.msgListView);

        if( getIntent().hasExtra("com.example.segoo.chagora.FIRSTNAME") )
        {
            TextView firstnameView = (TextView) findViewById(R.id.firstnameTextView);
            firstname = getIntent().getExtras().getString("com.example.segoo.chagora.FIRSTNAME");
            firstnameView.setText( firstname );

            this.msgDisplay = new msgAdapter( this, firstname, fromList, messages );
            msgListView.setAdapter( this.msgDisplay );

            API = new msgAPI(this, fromList, messages, msgDisplay );
            API.login( "SELF" );
        }

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

                Intent backIntent = new Intent( getApplicationContext(), TextActivity.class );

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

        sendAction.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                TextView inputMsgTextView = (TextView) findViewById(R.id.inputMsgTextView);
                String inputMsg = inputMsgTextView.getText().toString();

                inputMsgTextView.setText( null );

                API.sendMessage( firstname, inputMsg );
            }
        });
    }
}
