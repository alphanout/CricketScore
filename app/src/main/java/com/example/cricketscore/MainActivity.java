package com.example.cricketscore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int scorea = 0;
    int scoreb = 0;
    int outa = 0, outb;
    TextView ta, tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void p6a(View v) {
        scorea += 6;
        displayA();
    }

    public void p4a(View v) {
        scorea += 4;
        displayA();
    }


    public void p3a(View v) {
        scorea += 3;
        displayA();
    }

    public void p2a(View v) {
        scorea += 2;
        displayA();
    }

    public void pfa(View v) {
        scorea += 1;
        displayA();
    }

    public void p6b(View v) {
        scoreb += 6;
        displayB();
    }

    public void p4b(View v) {
        scoreb += 4;
        displayB();
    }

    public void p3b(View v) {
        scoreb += 3;
        displayB();
    }

    public void p2b(View v) {
        scoreb += 2;
        displayB();
    }

    public void pfb(View v) {
        scoreb += 1;
        displayB();
    }


    public void displayA() {
        ta = findViewById(R.id.teamA);
        ta.setText(String.valueOf(scorea));
    }

    public void displayB() {
        tb = findViewById(R.id.teamB);
        tb.setText(String.valueOf(scoreb));
    }

    public void displayoutA() {
        ta = findViewById(R.id.teamAout);
        ta.setText(String.valueOf(outa));
    }

    public void displayoutB() {
        tb = findViewById(R.id.teamBout);
        tb.setText(String.valueOf(outb));
    }

    public void reset(View v) {
        scorea = 0;
        scoreb = 0;
        outb = 0;
        outa = 0;
        displayA();
        displayB();
        displayoutB();
        displayoutA();
        toast("Scores reset", 176);
    }

    public void outa(View view) {
        outa++;
        if (outa == 10) {
            reset(null);
            if (scorea > scoreb && scoreb != scorea)
                toast("Math finish:A wins", 276);
            else if (scoreb == scorea) {
                if (outa > outb)
                    toast("Math finish:B wins", 276);
                else
                    toast("Math finish:A wins", 276);
            } else
                toast("Math finish:B wins", 276);
        }
        displayoutA();
    }

    public void outb(View v) {
        outb++;
        if (outb == 10) {
            reset(null);
            if (scorea > scoreb && scoreb != scorea)
                toast("Math finish:A wins", 276);
            else if (scoreb == scorea) {
                if (outa > outb)
                    toast("Math finish:B wins", 276);
                else
                    toast("Math finish:A wins", 276);
            } else
                toast("Math finish:B wins", 276);
        }

        displayoutB();
    }

    public void toast(String msg, int yOffset) {

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_container));

        TextView text = layout.findViewById(R.id.text);
        text.setText(msg);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_VERTICAL, 0, yOffset);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}
