package com.example.segoo.chagora;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CallViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_view);

        Button endCallActivity = (Button) findViewById(R.id.endCallBttn);

        endCallActivity.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent endCallIntent = new Intent( getApplicationContext(), CallActivity.class );

                startActivity( endCallIntent );
            }
        });

        if( getIntent().hasExtra("com.example.segoo.chagora.FIRSTNAME") )
        {
            TextView firstnameView = (TextView) findViewById(R.id.firstnameTextView);

            String firstname = getIntent().getExtras().getString("com.example.segoo.chagora.FIRSTNAME");

            firstnameView.setText( firstname );
        }
    }
}
