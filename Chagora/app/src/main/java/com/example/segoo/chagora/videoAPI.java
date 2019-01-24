package com.example.segoo.chagora;

import android.content.Context;
import android.util.Log;
import android.view.SurfaceView;
import android.widget.FrameLayout;

import io.agora.rtc.Constants;
import io.agora.rtc.IRtcEngineEventHandler;
import io.agora.rtc.RtcEngine;
import io.agora.rtc.video.VideoCanvas;
import io.agora.rtc.video.VideoEncoderConfiguration;

public class videoAPI
{
    private String appid = "41c860e5c1c847b996a2b8efd8274a2c";

    private RtcEngine API;

    private FrameLayout localStream;
    private FrameLayout remoteStream;

    private int remoteUID;

    public videoAPI( Context context, FrameLayout local, FrameLayout remote )
    {
        this.remoteUID = -1;

        IRtcEngineEventHandler callback = new IRtcEngineEventHandler()
        {
            @Override
            public void onUserJoined(int uid, int elapsed)
            {
                if (remoteUID == -1)
                {
                    remoteUID = uid;
                    Log.d("MSG", "REMOTE UID: " + uid );
                }
            }
        };

        try
        {
            this.API = RtcEngine.create(context, this.appid, callback);
        }
        catch (Exception e)
        {
            Log.d("MSG","FAILED!");
        }

        this.API.setChannelProfile( Constants.CHANNEL_PROFILE_COMMUNICATION );

        this.localStream = local;
        this.remoteStream = remote;

        Log.d("MSG", RtcEngine.getSdkVersion() );
    }

    public void joinChannel( String channelName )
    {
        this.API.joinChannel( null, channelName, null, 0 );
    }

    public void enableVideo( Context context )
    {
        this.API.enableVideo();

        VideoEncoderConfiguration.VideoDimensions dimensions = VideoEncoderConfiguration.VD_640x360;
        VideoEncoderConfiguration.FRAME_RATE frameRate = VideoEncoderConfiguration.FRAME_RATE.FRAME_RATE_FPS_30;
        VideoEncoderConfiguration.ORIENTATION_MODE orientation = VideoEncoderConfiguration.ORIENTATION_MODE.ORIENTATION_MODE_ADAPTIVE;

        int bitrate = VideoEncoderConfiguration.STANDARD_BITRATE;

        VideoEncoderConfiguration localStreamSetup = new VideoEncoderConfiguration( dimensions, frameRate, bitrate, orientation );

        this.API.setVideoEncoderConfiguration( localStreamSetup );

        SurfaceView local = this.API.CreateRendererView( context );
        local.setZOrderMediaOverlay( true );

        this.localStream.addView( local );
        this.API.setupLocalVideo( new VideoCanvas( local, VideoCanvas.RENDER_MODE_FIT, 0 ) );

        SurfaceView remote = this.API.CreateRendererView( context );

        Log.d("MSG","REMOTE UID VAR: " + this.remoteUID );

        this.remoteStream.addView( remote );
        this.API.setupRemoteVideo( new VideoCanvas( remote, VideoCanvas.RENDER_MODE_FIT, this.remoteUID ) );

        remote.setTag( this.remoteUID );
    }

    public void leaveChannel( )
    {
        this.API.leaveChannel( );
        this.API.destroy();
        this.API = null;
    }
}
