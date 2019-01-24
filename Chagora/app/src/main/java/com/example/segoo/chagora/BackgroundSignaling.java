package com.example.segoo.chagora;

import android.app.Application;

public class BackgroundSignaling extends Application
{
    private msgAPI messenger;
    private String username;

    @Override
    public void onCreate()
    {
        super.onCreate();
        messenger = new msgAPI( getBaseContext( ) );
        username = "SELF";

        messenger.login( username );
    }

    public void setUsername( String user )
    {
        if( username != null )
        {
            messenger.logout( );
            username = user;
            messenger.login( user );
        }
    }

    public String getUsername()
    {
        return username;
    }

    public msgAPI getMessenger( )
    {
        return messenger;
    }
}
