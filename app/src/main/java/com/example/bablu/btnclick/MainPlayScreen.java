package com.example.bablu.btnclick;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import java.security.SecureRandom;


public class MainPlayScreen extends AppCompatActivity {
    Button Btnplay, BtnTest;
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();
    public String name;
    ArrayList<String> al_Zodiac = new ArrayList <String>();
    TextView sp_Zodiac;
    String data_fields[] = {"Zodiac Signs"};
    int CLICKED_ID;
    LinearLayout ll = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_play_screen);
        Btnplay = (Button)findViewById(R.id.btnPlay);
        sp_Zodiac = (TextView) findViewById(R.id.sp_country);

        sp_Zodiac.setText(data_fields[0]);
        //al_Zodiac.add(data_fields[0]);
        al_Zodiac.add("Aries");
        al_Zodiac.add("Taurus");
        al_Zodiac.add("Gemini");
        al_Zodiac.add("Cancer");
        al_Zodiac.add("Leo");
        al_Zodiac.add("Virgo");
        al_Zodiac.add("Libra");
        al_Zodiac.add("Scorpio");
        al_Zodiac.add("Sagittarius");
        al_Zodiac.add("Capricorn");
        al_Zodiac.add("Aquarius");
        al_Zodiac.add("Pisces");

        sp_Zodiac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogSelect(al_Zodiac, sp_Zodiac);
            }
        });
    }

    public void dialogSelect(final ArrayList<String> al_Zodiac, final TextView btn_data) {
        CLICKED_ID = -1;
        final String type="btnOkClick";

        final BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        final Intent intent = new Intent(this, MainActivity.class);
        // add listener to button
        // Create custom dialog object
        final Dialog dialog = new Dialog(MainPlayScreen.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // Include dialog.xml file
        dialog.setContentView(R.layout.dialog);
        // Set dialog title
        dialog.setTitle("Custom Dialog");
        RadioGroup rgp = (RadioGroup) dialog.findViewById(R.id.radiogroup);
        RadioGroup.LayoutParams rprms;

        Button title = (Button) dialog.findViewById(R.id.title);
        //title.setTypeface(FONT_BOLD);
        if (ll != null)
            rgp.removeView(ll);
        ll = new LinearLayout(getApplicationContext());
        for (int i = 0; i < al_Zodiac.size(); i++) {
            final RadioButton rdbtn = new RadioButton(getApplicationContext());
            rdbtn.setTextColor(getResources().getColor(R.color.dark_ash));
            rdbtn.setButtonDrawable(getApplicationContext().getResources().getDrawable(R.drawable.custom_radio_button));
            rdbtn.setTextSize(16);
            //rdbtn.setTypeface(FONT_REGULAR);
            rdbtn.setPadding(15, 0, 0, 0);
            rprms = new RadioGroup.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
            rprms.setMargins(50, 10, 0, 10);
            rdbtn.setId(i);
            rdbtn.setText(al_Zodiac.get(i));
            rdbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), "" + rdbtn.getId(), Toast.LENGTH_SHORT).show();
                    //dialog.dismiss();
                    //name=rdbtn.getId();
                    CLICKED_ID = rdbtn.getId();
                }
            });
            rgp.addView(rdbtn, rprms);
        }

        Button ok = (Button) dialog.findViewById(R.id.ok);
        //ok.setTypeface(FONT_BOLD);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CLICKED_ID == -1) {
                    dialog.dismiss();
                } else {
                    btn_data.setText(al_Zodiac.get(CLICKED_ID).toString());
                    name=sp_Zodiac.getText().toString()+randomString();
                    Toast.makeText(getApplicationContext(),name, Toast.LENGTH_SHORT).show();
                    final String Username = name;
                    backgroundWorker.execute(type,Username);
                    //name = input_field.getText().toString();
                    dialog.dismiss();
                    intent.putExtra("Username",name);
                    startActivity(intent);
                }


            }
        });

        Button close = (Button) dialog.findViewById(R.id.close);
        //close.setTypeface(FONT_BOLD);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


        // rgp.addView(ll);
        dialog.show();
        //myDialog.show();
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);


        int height = metrics.heightPixels;
        int width = metrics.widthPixels;
        Window window = dialog.getWindow();
        window.setLayout(width - (width * 10 / 100), height - (height * 40 / 100));
    }

    protected void buttonPlay(View view){
        //request_user_name();
        dialogSelect(al_Zodiac, sp_Zodiac);

    }
    public void request_user_name() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter name:");

        final EditText input_field = new EditText(this);

        builder.setView(input_field);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //name = input_field.getText().toString();
                //String randomstring = randomString();
                //startActivity(new Intent(getApplicationContext(), MainActivity.class));
                //intent();

            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                request_user_name();
            }
        });
        builder.show();
    }
    String randomString(){
        StringBuilder sb = new StringBuilder( 4 );
        for( int i = 0; i < 4; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

}
