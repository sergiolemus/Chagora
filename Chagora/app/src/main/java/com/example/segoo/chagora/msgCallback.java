package com.example.segoo.chagora;

import android.util.Log;

import java.util.ArrayList;

import io.agora.IAgoraAPI.ICallBack;

public class msgCallback implements ICallBack
{
    private ArrayList<String> fromList;
    private ArrayList<String> messages;
    private msgAdapter messagesController;

    public msgCallback( ){}

    @Override
    public void onReconnecting(int i) {}

    @Override
    public void onReconnected(int i) {}

    @Override
    public void onLoginSuccess( int i, int i1 )
    {
        Log.d("MSG","LOGIN SUCCESSFUL!");
    }

    @Override
    public void onLogout(int i)
    {
//        Log.d("MSG","LOGOUT SUCCESSFUL!");
    }

    @Override
    public void onLoginFailed(int i)
    {
        Log.d("MSG","LOGIN FAILED!");
    }

    @Override
    public void onChannelJoined(String s) {}

    @Override
    public void onChannelJoinFailed(String s, int i) {}

    @Override
    public void onChannelLeaved(String s, int i) {}

    @Override
    public void onChannelUserJoined(String s, int i) {}

    @Override
    public void onChannelUserLeaved(String s, int i) {}

    @Override
    public void onChannelUserList(String[] strings, int[] ints) {}

    @Override
    public void onChannelQueryUserNumResult(String s, int i, int i1) {}

    @Override
    public void onChannelQueryUserIsIn(String s, String s1, int i) {}

    @Override
    public void onChannelAttrUpdated(String s, String s1, String s2, String s3) {}

    @Override
    public void onInviteReceived(String s, String s1, int i, String s2) {}

    @Override
    public void onInviteReceivedByPeer(String s, String s1, int i) {}

    @Override
    public void onInviteAcceptedByPeer(String s, String s1, int i, String s2) {}

    @Override
    public void onInviteRefusedByPeer(String s, String s1, int i, String s2) {}

    @Override
    public void onInviteFailed(String s, String s1, int i, int i1, String s2) {}

    @Override
    public void onInviteEndByPeer(String s, String s1, int i, String s2) {}

    @Override
    public void onInviteEndByMyself(String s, String s1, int i) {}

    @Override
    public void onInviteMsg(String s, String s1, int i, String s2, String s3, String s4) {}

    @Override
    public void onMessageSendError(String s, int i) {}

    @Override
    public void onMessageSendProgress(String s, String s1, String s2, String s3) {}

    @Override
    public void onMessageSendSuccess(String s)
    {
//        this.messagesController.notifyDataSetChanged();
    }

    @Override
    public void onMessageAppReceived(String s) {}

    @Override
    public void onMessageInstantReceive( String from, int uid, String msg )
    {
        Log.d("MSG", from + ": " + msg );
//        this.fromList.add( from );
//        this.messages.add( msg );
//        this.messagesController.notifyDataSetChanged();
    }

    @Override
    public void onMessageChannelReceive(String s, String s1, int i, String s2) {}

    @Override
    public void onLog(String s) {}

    @Override
    public void onInvokeRet(String s, String s1, String s2) {}

    @Override
    public void onMsg(String s, String s1, String s2) {}

    @Override
    public void onUserAttrResult(String s, String s1, String s2) {}

    @Override
    public void onUserAttrAllResult(String s, String s1) {}

    @Override
    public void onError(String s, int i, String s1) {}

    @Override
    public void onQueryUserStatusResult(String s, String s1) {}

    @Override
    public void onDbg(String s, byte[] bytes) {}

    @Override
    public void onBCCall_result(String s, String s1, String s2) {}
}
