package com.example.segoo.chagora;

import android.content.Context;

import java.util.ArrayList;

import io.agora.AgoraAPIOnlySignal;

public class msgAPI {

    private String appid = "41c860e5c1c847b996a2b8efd8274a2c";

    private String username;
    private AgoraAPIOnlySignal API;
    private msgCallback Callback;

    private ArrayList<String> fromList;
    private ArrayList<String> messages;
    private msgAdapter messagesController;

    public msgAPI( Context context, ArrayList<String> currentFromList, ArrayList<String> currentMessages, msgAdapter controller )
    {
        this.fromList = currentFromList;
        this.messages = currentMessages;
        this.messagesController = controller;
        this.username = null;

        this.API = AgoraAPIOnlySignal.getInstance( context, appid );

        this.Callback = new msgCallback( fromList, messages, messagesController );
        this.API.callbackSet( Callback );
    }

    public void login( String user )
    {
        int uid = 0;

        String token = "_no_need_token";
        String deviceID = null;

        this.API.login( this.appid, user, token, uid, deviceID );

        this.username = user;
    }

    public void sendMessage( String to, String msg )
    {
        int uid = 0;
        String msgID = "";

        this.API.messageInstantSend( to, uid, msg, msgID );

        this.messages.add( msg );
        this.fromList.add( username );
    }
}
