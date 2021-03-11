package com.example.googlebooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView t;
    private TextView a;
    private EditText e;
    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e = (EditText) findViewById(R.id.search);
        t = (TextView) findViewById(R.id.title);
        a = (TextView) findViewById(R.id.author);
        b = (Button) findViewById(R.id.butt);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), ResultActivity.class);
                i.putExtra("key", e.getText().toString());
                startActivity(i);
               // new ResultActivity(e.getText().toString());
            }
        });
    }
}