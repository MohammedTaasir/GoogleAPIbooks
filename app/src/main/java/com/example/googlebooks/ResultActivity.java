package com.example.googlebooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {

    private resAdapter r;
    private String ch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        TextView not = (TextView) findViewById(R.id.non);
        ListView l = (ListView) findViewById(R.id.list);
        l.setEmptyView(not);

        r = new resAdapter(this, new ArrayList<books>());
        l.setAdapter(r);

        if(getIntent().getExtras() != null) {
            //editTextB.setText(getIntent().getExtras().getString("key");
            ch = getIntent().getExtras().getString("key");
        }

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                books bit = r.getItem(position);
                if(bit.getU() != null){
                    Uri uz = Uri.parse(bit.getU());
                    Intent in = new Intent(Intent.ACTION_VIEW, uz);
                    startActivity(in);
                }


            }
        });

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        // If the network is active and the search field is not empty, start a FetchBook AsyncTask.
        if (networkInfo != null && networkInfo.isConnected() && ch.length()!=0) {
            new resAsyncTask().execute(ch);
        }
        // Otherwise update the TextView to tell the user there is no connection or no search term.
        else {
            if (ch.length() == 0) {
                not.setText("enter name of the book");
            } else {
                not.setText("no network");
            }
        }



    }

    private class resAsyncTask extends AsyncTask<String, Void, List<books>>{



        /** private TextView t;
        private TextView a;
        private EditText s;

        public resAsyncTask(TextView text, TextView auth, EditText search){
            t = text;
            a = auth;
            s = search;
        }**/
        @Override
        protected List<books> doInBackground(String... strings) {
            if(strings[0]==null){
                return null;
            }
            List<books> a = Fetch.fetchbooks(strings[0]);
            return a;
        }

        @Override
        protected void onPostExecute(List<books> g) {
            r.clear();
            if(g != null){
                r.addAll(g);
            }
        }
    }

}