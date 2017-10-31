package com.example.project.popshop;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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

public class CinemaClick extends AppCompatActivity {
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
        setContentView(R.layout.activity_cinema_click);
        compName = (TextView) findViewById(R.id.userview);
        Intent intComp = getIntent();
        compNames = intComp.getStringExtra("nameWelcome");
        compName.setText(compNames);
        grid = (GridView) findViewById(R.id.grid);
        pdLoading = new ProgressDialog(CinemaClick.this);
        pdLoading.setMessage("\tLoading...");
        pdLoading.setCancelable(false);
        pdLoading.show();


        getData();
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Toast.makeText(PointItems.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
                Intent pointsbef = new Intent(CinemaClick.this, beforeCart.class);
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
        setTitle("cinema click");
       return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }


    public void getData() {
        class GetDataJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected String doInBackground(Void... params) {

                String result = null;
                try {
                    String link = "http://" + functions.ipaddress + "/OnlineShopService/selectcinemaclick.php";
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
            qtys = new String[peoples.length()];

           // categ[0] = "All";
            for (int i = 0; i < peoples.length(); i++) {
                JSONObject c = peoples.getJSONObject(i);

               // categ[i + 1] = c.getString(TAG_CAT);
                qtys[i] = c.getString(TAG_IMG);
                imageId = new String[Integer.parseInt(qtys[i])];
                for(int j=0;j<Integer.parseInt(qtys[i]);j++) {
                    imageId[j] = String.valueOf(j);
                }

                // HashMap<String, String> persons = new HashMap<String, String>();


                //persons.put(TAG_NAME, name);
                // persons.put(TAG_TEL, telephone);
                // persons.put(TAG_STA, status);
                //WorldPopulation wp = new WorldPopulation(names[i]);
                // arraylist.add(wp);

            }
            pdLoading.dismiss();

            CustomGrid1 adapter1 = new CustomGrid1(CinemaClick.this, imageId);

            grid.setAdapter(adapter1);


        } catch (JSONException e) {
            Toast.makeText(CinemaClick.this, "no internet connection",
                    Toast.LENGTH_LONG).show();
        }

    }


}


