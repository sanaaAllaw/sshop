package com.example.project.popshop;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class AftercartAdapter extends BaseAdapter {
    private ArrayList<String> array1, array2, array3;
    private LayoutInflater inflater;

    public AftercartAdapter(Context context, ArrayList<String> a1, ArrayList<String> a2) {
        array1 = a1;
        array2 = a2;

        inflater =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return array1.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View currentView = convertView;

        if(currentView==null) {
            currentView = inflater.inflate(R.layout.order_list, parent, false);
        }

        TextView tView = (TextView)currentView.findViewById(R.id.firstLine);
        tView.setText(array1.get(position));

        tView = (TextView)currentView.findViewById(R.id.secondLine);
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        String yourFormattedString = formatter.format(Integer.parseInt(array2.get(position)));
        tView.setText(yourFormattedString+" L.L");


        return currentView;
    }
}