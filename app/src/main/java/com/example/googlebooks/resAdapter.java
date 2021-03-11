package com.example.googlebooks;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class resAdapter extends ArrayAdapter<books> {
    public resAdapter(Activity context, ArrayList<books> b){
        super(context, 0, b);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemview = convertView;

        if(listitemview == null){
            listitemview = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        books current = getItem(position);

        TextView t = (TextView) listitemview.findViewById(R.id.titleid);
        t.setText(current.getT());



        TextView a = (TextView) listitemview.findViewById(R.id.authorid);
        a.setText(current.getA());

        return listitemview;
    }
}
