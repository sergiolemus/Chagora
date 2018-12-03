package com.example.segoo.chagora;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class NewMsgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_msg);

        Button cancelActivity = (Button) findViewById(R.id.cancelBttn);
        Button newContactActivity = (Button) findViewById(R.id.newContactBttn);

        cancelActivity.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent cancelIntent = new Intent( getApplicationContext(), TextActivity.class );

                startActivity( cancelIntent );
            }
        });

        newContactActivity.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent newContactIntent = new Intent( getApplicationContext(), NewMsgContactActivity.class );

                startActivity( newContactIntent );
            }
        });
    }
}
