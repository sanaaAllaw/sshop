package com.example.project.popshop;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Locale;

public class Restaurant extends AppCompatActivity {
    String myJSON;
    //private ArrayAdapter<String> adapter;

    private static final String TAG_RESULTS = "result";
    private static final String TAG_STA = "status";
    private static final String TAG_NAME = "name";
    private static final String TAG_TEL = "telephone";
    private static final String TAG_IMG = "logo";
    ProgressDialog pdLoading;
    JSONArray peoples = null;
    private ImageView imgStatus;
    ListViewAdapter3 adapter;
    //ArrayList<HashMap<String, String>> personList;
    String[] rank;
    String[] country;
    String[] population;
    String[] imgs;
    ArrayList<WorldPopulation> arraylist = new ArrayList<WorldPopulation>();
    ListView listComp;
    EditText inputSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        pdLoading = new ProgressDialog(Restaurant.this);
        pdLoading.setMessage("\tLoading...");
        pdLoading.setCancelable(false);
        pdLoading.show();
        listComp = (ListView) findViewById(R.id.listviewAfercart);
        inputSearch = (EditText) findViewById(R.id.searchid);
        //personList = new ArrayList<HashMap<String,String>>();
        listComp.setClickable(true);
        listComp.setTextFilterEnabled(true);
        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = inputSearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);

            }
        });
        getData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        setTitle("Point of sale");
        return true;
    }

    public void getData() {
        class GetDataJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected String doInBackground(Void... params) {
                String result = null;
                try {
                    String link = "http://"+functions.ipaddress+"/OnlineShopService/selectRestaurant.php";
                    //String data = URLEncoder.encode("q1", "UTF-8") + "=" + URLEncoder.encode("cinema", "UTF-8");


                    URL url = new URL(link);
                    URLConnection conn = url.openConnection();

                    //conn.setDoOutput(true);
                    // OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                    // wr.write(data);
                    // wr.flush();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    StringBuilder sb = new StringBuilder();
                    String line = null;

                    // Read Server Response
                    while ((line = reader.readLine()) != null) {
                        sb.append(line);

                    }
                    result = sb.toString();
                } catch (Exception e) {
                    return new String("Exception: " + e.getMessage());
                }
                return result;

            }

            @Override
            protected void onPostExecute(String result) {
                myJSON = result;
                showList();
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute();
    }

    protected void showList() {
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(TAG_RESULTS);
            rank = new String[peoples.length()];
            country = new String[peoples.length()];
            population = new String[peoples.length()];
            imgs = new String[peoples.length()];
            for (int i = 0; i < peoples.length(); i++) {
                JSONObject c = peoples.getJSONObject(i);

                rank[i] = c.getString(TAG_NAME);
                country[i] = c.getString(TAG_TEL);
                population[i] = c.getString(TAG_STA);
                imgs[i] = c.getString(TAG_IMG);
                // HashMap<String, String> persons = new HashMap<String, String>();


                //persons.put(TAG_NAME, name);
                // persons.put(TAG_TEL, telephone);
                // persons.put(TAG_STA, status);
                WorldPopulation wp = new WorldPopulation(country[i], rank[i],
                        population[i], imgs[i]);
                arraylist.add(wp);

            }
            adapter = new ListViewAdapter3(this, arraylist);
            pdLoading.dismiss();
            listComp.setAdapter(adapter);

        } catch (JSONException e) {
            Toast.makeText(Restaurant.this, "no internet connection",
                    Toast.LENGTH_LONG).show();
        }

    }
    @Override
    public void onBackPressed() {
        finish();
        Intent Homevar = new Intent(Restaurant.this, Home.class);
        startActivity(Homevar);

    }
}
