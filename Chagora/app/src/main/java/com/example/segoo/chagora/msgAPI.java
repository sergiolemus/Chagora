package com.example.segoo.chagora;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import io.agora.AgoraAPIOnlySignal;

public class msgAPI {

    private String appid = "41c860e5c1c847b996a2b8efd8274a2c";

    private AgoraAPIOnlySignal API;
    private msgCallback Callback;

    private ArrayList<String> fromList;
    private ArrayList<String> messages;
    private msgAdapter messagesController;

    public msgAPI( Context context )
    {
        this.API = AgoraAPIOnlySignal.getInstance( context, appid );

        this.Callback = new msgCallback( );
        this.API.callbackSet( Callback );
    }

    public void login( String user )
    {
        int uid = 0;

        String token = "_no_need_token";
        String deviceID = null;

        this.API.login( this.appid, user, token, uid, deviceID );

        Log.d("MSG","LOGGING IN: " + user );
    }

    public void sendMessage( String to, String msg )
    {
        int uid = 0;
        String msgID = "";

        this.API.messageInstantSend( to, uid, msg, msgID );

//        this.messages.add( msg );
//        this.fromList.add( username );

//        Log.d("MSG", "SELF: " + msg );
    }

    public void logout( )
    {
        this.API.logout( );
    }
}
