package com.example.segoo.chagora;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class msgAdapter extends BaseAdapter {

    LayoutInflater mInflater;

    ArrayList<String> fromList;
    ArrayList<String> messages;

    public msgAdapter( Context context, ArrayList<String> currentFromList, ArrayList<String> currentMessages )
    {
        this.fromList = currentFromList;
        this.messages = currentMessages;
        this.mInflater = (LayoutInflater) context.getSystemService( context.LAYOUT_INFLATER_SERVICE );
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int position) {
        return messages.get( position );
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = this.mInflater.inflate(R.layout.msg_in_listview, null);

        TextView msgTextView = view.findViewById(R.id.msgTextView);
        TextView fromTextView = view.findViewById(R.id.fromTextView);

        String from = this.fromList.get( position );
        String msg = this.messages.get( position );

        fromTextView.setText( from );
        msgTextView.setText( msg );

        return view;
    }
}
