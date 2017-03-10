package com.example.bablu.btnclick;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.FragmentManager;
//import android.support.v4.widget.SearchViewCompatIcs;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.SecureRandom;

public class MainActivity extends AppCompatActivity {
    Button btn_slap;
    //EditText UsernameET;
    TextView UsernameTV;
    Typeface FONT_BOLD, FONT_REGULAR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_slap = (Button) findViewById(R.id.btnSlap);
        //UsernameET = (EditText) findViewById(R.id.etUsername);
        UsernameTV = (TextView)findViewById(R.id.tvUsername);
        //FONT_BOLD = Typeface.createFromAsset(getApplicationContext().getAssets(), UtilsConsts.Custom_Font_bold);
       // UsernameTV.setTypeface(FONT_BOLD);
        Intent intent = getIntent();
        String name = intent.getStringExtra("username");
        //Toast.makeText(getApplicationContext(), name.toString(), Toast.LENGTH_SHORT).show();
        //UsernameET.setText(getIntent().getExtras().getString("Username"));
        UsernameTV.setText(getIntent().getExtras().getString("Username"));
        //showDialog();

    }

    protected void SlapMe(View view){

        String type="btnSlapClick";
        String Username = UsernameTV.getText().toString();
        String uniqueID="TestSlap";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,Username,uniqueID);
    }
    protected void KissMe(View view){
        String type="btnKissClick";
        String Username = UsernameTV.getText().toString();
        String uniqueID="TestKiss";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type,Username,uniqueID);
    }
    public void showDialog(){
        android.app.FragmentManager manager=getFragmentManager();
        myDialog myDialog = new myDialog();
        myDialog.show(manager, "MyDialog");

    }

}
