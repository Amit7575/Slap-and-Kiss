package com.example.bablu.btnclick;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by bablu on 2/3/17.
 */

public class myDialog extends DialogFragment implements View.OnClickListener {
    Button ok ,close;
    ArrayList<String> al_city = new ArrayList<String>();
    TextView sp_city;
    String data_fields[] = {"Country"};
    int CLICKED_ID;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.dialog,null);
        ok = (Button) view.findViewById(R.id.ok);
        close=(Button) view.findViewById(R.id.close);
        setCancelable(false);
        ok.setOnClickListener(this);
        close.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.ok){
            Toast.makeText(getActivity(),"ok button is clicked",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getActivity(),"close button is clicked",Toast.LENGTH_SHORT).show();
        }
    }
}
