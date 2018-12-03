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

    msgAPI API;
    String firstname;
    msgAdapter msgDisplay;

    ArrayList<String> messages;
    ArrayList<String> fromList;
    ListView msgListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg_view);

        Button backActivity = (Button) findViewById(R.id.backBttn);

        Button sendAction = (Button) findViewById(R.id.sendBttn);

        messages = new ArrayList<String>();
        fromList = new ArrayList<String>();
        msgListView = (ListView) findViewById(R.id.msgListView);

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

        backActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent backIntent = new Intent( getApplicationContext(), TextActivity.class );

                startActivity( backIntent );
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
