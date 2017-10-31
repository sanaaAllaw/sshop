package com.example.project.popshop;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class PointItems extends AppCompatActivity {
    TextView compName;
   static String compNames;
    static String imgFilter;
    String searchVar, categorieVar;

    String country;
    String myJSON;
    private static final String TAG_RESULTS = "result";
    private static final String TAG_NAME = "name";
    private static final String TAG_CAT = "categorie";
    private static final String TAG_PRC = "price";
    private static final String TAG_QTY = "qty";
    private static final String TAG_IMG = "Strength";
    ProgressDialog pdLoading;
    JSONArray peoples = null;
    String[] names;
    String[] categ;
    String[] prices;
    String[] qtys;

    Spinner scategories;
    GridView grid;
    String[] web;
    String[] imageId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_items);
        compName = (TextView) findViewById(R.id.userview);
        Intent intComp = getIntent();
        compNames = intComp.getStringExtra("nameWelcome");
        compName.setText(compNames);
        grid = (GridView) findViewById(R.id.grid);
        pdLoading = new ProgressDialog(PointItems.this);
        pdLoading.setMessage("\tLoading...");
        pdLoading.setCancelable(false);
        pdLoading.show();


        getData();
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Toast.makeText(PointItems.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
                Intent pointsbef = new Intent(PointItems.this, beforeCart.class);
                pointsbef.putExtra("name", web[position]);
                pointsbef.putExtra("price", prices[position]);
                pointsbef.putExtra("desc", categ[position + 1]);
                pointsbef.putExtra("qty", qtys[position]);
                imgFilter = imageId[position];
                startActivity(pointsbef);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        setTitle("Items");
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_menu, menu);


        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.action_search).getActionView();
        final EditText searchEditText = (EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);

        searchEditText.setHint("Search");

        searchEditText.setHintTextColor(getResources().getColor(R.color.AliceBlue));
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        searchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    //run query to the server
                    searchVar = searchEditText.getText().toString().trim();
                    getData1();

                }
                return false;
            }
        });


        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }


    public void getData() {
        class GetDataJSON extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params) {

                String result = null;
                try {
                    String link = "http://" + functions.ipaddress + "/OnlineShopService/selectItems.php";
                    String data = URLEncoder.encode("q1", "UTF-8") + "=" + URLEncoder.encode(compNames, "UTF-8");


                    URL url = new URL(link);
                    URLConnection conn = url.openConnection();

                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                    wr.write(data);
                    wr.flush();

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
            names = new String[peoples.length()];
            categ = new String[peoples.length() + 1];
            prices = new String[peoples.length()];
            qtys = new String[peoples.length()];
            imageId = new String[peoples.length()];
            web = new String[peoples.length()];
            categ[0] = "All";
            for (int i = 0; i < peoples.length(); i++) {
                JSONObject c = peoples.getJSONObject(i);

                categ[i + 1] = c.getString(TAG_CAT);
                web[i] = c.getString(TAG_NAME);
                imageId[i] = c.getString(TAG_IMG);
                prices[i] = c.getString(TAG_PRC);
                qtys[i] = c.getString(TAG_QTY);
                // HashMap<String, String> persons = new HashMap<String, String>();


                //persons.put(TAG_NAME, name);
                // persons.put(TAG_TEL, telephone);
                // persons.put(TAG_STA, status);
                //WorldPopulation wp = new WorldPopulation(names[i]);
                // arraylist.add(wp);

            }
            pdLoading.dismiss();

            CustomGrid adapter1 = new CustomGrid(PointItems.this, web, imageId, prices);

            grid.setAdapter(adapter1);


        } catch (JSONException e) {
            Toast.makeText(PointItems.this, "no internet connection",
                    Toast.LENGTH_LONG).show();
        }

    }

    public void getData1() {
        class GetDataJSON extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params) {

                String result = null;
                try {
                    String link = "http://" + functions.ipaddress + "/OnlineShopService/selectfilter.php";
                    String data = URLEncoder.encode("q2", "UTF-8") + "=" + URLEncoder.encode(searchVar, "UTF-8");


                    URL url = new URL(link);
                    URLConnection conn = url.openConnection();

                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                    wr.write(data);
                    wr.flush();

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
                showList1();
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute();
    }

    protected void showList1() {
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(TAG_RESULTS);
            names = new String[peoples.length()];
            categ = new String[peoples.length()];
            prices = new String[peoples.length()];
            qtys = new String[peoples.length()];
            imageId = new String[peoples.length()];
            web = new String[peoples.length()];
            for (int i = 0; i < peoples.length(); i++) {
                JSONObject c = peoples.getJSONObject(i);

                categ[i] = c.getString(TAG_CAT);
                web[i] = c.getString(TAG_NAME);
                imageId[i] = c.getString(TAG_IMG);
                prices[i] = c.getString(TAG_PRC);
                qtys[i] = c.getString(TAG_QTY);
                // HashMap<String, String> persons = new HashMap<String, String>();


                //persons.put(TAG_NAME, name);
                // persons.put(TAG_TEL, telephone);
                // persons.put(TAG_STA, status);
                //WorldPopulation wp = new WorldPopulation(names[i]);
                // arraylist.add(wp);

            }
            pdLoading.dismiss();

            CustomGrid adapter1 = new CustomGrid(PointItems.this, web, imageId, prices);

            grid.setAdapter(adapter1);


        } catch (JSONException e) {
            Toast.makeText(PointItems.this, "no internet connection",
                    Toast.LENGTH_LONG).show();
        }

    }

    public void getData2() {
        class GetDataJSON extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params) {

                String result = null;
                try {
                    String link = "http://192.168.0.109/OnlineShopService/selectcat.php";
                    String data = URLEncoder.encode("q3", "UTF-8") + "=" + URLEncoder.encode(categorieVar, "UTF-8");


                    URL url = new URL(link);
                    URLConnection conn = url.openConnection();

                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                    wr.write(data);
                    wr.flush();

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
                showList1();
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute();
    }

    protected void showList2() {
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(TAG_RESULTS);
            names = new String[peoples.length()];
            categ = new String[peoples.length()];
            prices = new String[peoples.length()];
            qtys = new String[peoples.length()];
            imageId = new String[peoples.length()];
            web = new String[peoples.length()];
            for (int i = 0; i < peoples.length(); i++) {
                JSONObject c = peoples.getJSONObject(i);

                categ[i] = c.getString(TAG_CAT);
                web[i] = c.getString(TAG_NAME);
                imageId[i] = c.getString(TAG_IMG);
                prices[i] = c.getString(TAG_PRC);
                qtys[i] = c.getString(TAG_QTY);
                // HashMap<String, String> persons = new HashMap<String, String>();


                //persons.put(TAG_NAME, name);
                // persons.put(TAG_TEL, telephone);
                // persons.put(TAG_STA, status);
                //WorldPopulation wp = new WorldPopulation(names[i]);
                // arraylist.add(wp);

            }
            pdLoading.dismiss();

            CustomGrid adapter1 = new CustomGrid(PointItems.this, web, imageId, prices);

            grid.setAdapter(adapter1);


        } catch (JSONException e) {
            Toast.makeText(PointItems.this, "no internet connection",
                    Toast.LENGTH_LONG).show();
        }

    }
}

