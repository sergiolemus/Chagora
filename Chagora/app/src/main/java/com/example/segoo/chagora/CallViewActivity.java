package com.example.segoo.chagora;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class CallViewActivity extends AppCompatActivity {

    videoAPI API;

    private static final int PERMISSION_REQ_ID = 22;
    private static final String[] REQUESTED_PERMISSIONS = { Manifest.permission.RECORD_AUDIO, Manifest.permission.CAMERA };

    private boolean checkSelfPermission( String permission, int permission_id )
    {
        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED )
        {
            ActivityCompat.requestPermissions(this, REQUESTED_PERMISSIONS, permission_id );
            return false;
        }

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_view);

        Button endCallActivity = (Button) findViewById(R.id.endCallBttn);
        Button enableVideoBttn = (Button) findViewById(R.id.videoBttn);

        if( getIntent().hasExtra("com.example.segoo.chagora.FIRSTNAME") )
        {
            TextView firstnameView = (TextView) findViewById(R.id.firstnameTextView);

            String firstname = getIntent().getExtras().getString("com.example.segoo.chagora.FIRSTNAME");

            firstnameView.setText( firstname );

            FrameLayout localStream = (FrameLayout) findViewById(R.id.localStream);
            FrameLayout remoteStream = (FrameLayout) findViewById(R.id.remoteStream);

            if( checkSelfPermission( REQUESTED_PERMISSIONS[0], PERMISSION_REQ_ID ) &&
                    checkSelfPermission( REQUESTED_PERMISSIONS[1], PERMISSION_REQ_ID ) )
            {
                API = new videoAPI(getBaseContext(), localStream, remoteStream);
                API.joinChannel("basic");
            }
        }

        endCallActivity.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent endCallIntent = new Intent( getApplicationContext(), CallActivity.class );

                API.leaveChannel();
                startActivity( endCallIntent );
            }
        });

        enableVideoBttn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                API.enableVideo( getBaseContext() );
            }
        });

    }
}
