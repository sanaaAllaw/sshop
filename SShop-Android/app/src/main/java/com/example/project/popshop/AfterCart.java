package com.example.project.popshop;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;

public class AfterCart extends AppCompatActivity {
    ListView listVar;
    TextView totalVar;
    TextView uservar;
    EditText addres;
    String adresss;
    public static final int CONNECTION_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 15000;
    Button btnadd;
    String item, companys, qty, unit_price, id_agent, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_cart);
        listVar = (ListView) findViewById(R.id.listviewAfercart);
        totalVar = (TextView) findViewById(R.id.textViewvar);
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        String yourFormattedString = formatter.format(Points.totalPrice);
        totalVar.setText("Total Price: " + yourFormattedString + " L.L");
        final AftercartAdapter adapter = new AftercartAdapter
                (this, Points.itemsvar, Points.pricesvar);

        listVar.setAdapter(adapter);
        btnadd = (Button) findViewById(R.id.button7);
        addres = (EditText) findViewById(R.id.editText2);
        uservar = (TextView) findViewById(R.id.userview);
        uservar.setText(Login.stusername);
        id_agent = (String) uservar.getText();


        companys = Login.stcompany;

    }

    @Override
    public void onBackPressed() {
        finish();
        Intent indexvarReg = new Intent(AfterCart.this, Index.class);
        startActivity(indexvarReg);

    }

    private class AsyncSignUp extends AsyncTask<String, String, String> {
        ProgressDialog pdLoading = new ProgressDialog(AfterCart.this);
        HttpURLConnection conn;
        URL url = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //this method will be running on UI thread
            pdLoading.setMessage("\tLoading...");
            pdLoading.setCancelable(false);
            pdLoading.show();

        }

        @Override
        protected String doInBackground(String... params) {
            try {

                // Enter URL address where your php file resides
                url = new URL("http://" + functions.ipaddress + "/OnlineShopService/insert_Cart.php");

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return "exception";
            }
            try {
                // Setup HttpURLConnection class to send and receive data from php and mysql
                conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(READ_TIMEOUT);
                conn.setConnectTimeout(CONNECTION_TIMEOUT);
                conn.setRequestMethod("POST");

                // setDoInput and setDoOutput method depict handling of both send and receive
                conn.setDoInput(true);
                conn.setDoOutput(true);
                conn.setChunkedStreamingMode(0);
                // Append parameters to URL
                Uri.Builder builder = new Uri.Builder()
                        .appendQueryParameter("id_agent", params[0])
                        .appendQueryParameter("company", params[1])
                        .appendQueryParameter("item", params[2])
                        .appendQueryParameter("price", params[3])
                        .appendQueryParameter("address", params[4]);
                String query = builder.build().getEncodedQuery();

                // Open connection for sending data
                OutputStream os = new BufferedOutputStream(conn.getOutputStream());
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(query);
                writer.flush();
                writer.close();
                os.close();
                conn.connect();

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                return "exception";
            }

            try {

                int response_code = conn.getResponseCode();

                // Check if successful connection made
                if (response_code == HttpURLConnection.HTTP_OK) {

                    // Read data sent from server
                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }

                    // Pass data to onPostExecute method
                    return (result.toString());

                } else {

                    return ("unsuccessful");
                }

            } catch (IOException e) {
                e.printStackTrace();
                return "exception";
            } finally {
                conn.disconnect();
            }


        }

        @Override
        protected void onPostExecute(String result) {

            //this method will be running on UI thread

            pdLoading.dismiss();

            if (result.equalsIgnoreCase("true")) {
                /* Here launching another activity when login successful. If you persist login state
                use sharedPreferences of Android. and logout button to clear sharedPreferences.
                 */
                LayoutInflater inflater = getLayoutInflater();
                // Inflate the Layout
                View layout = inflater.inflate(R.layout.succes_toast,
                        (ViewGroup) findViewById(R.id.custom_toast_layout));

                TextView text = (TextView) layout.findViewById(R.id.textToShow);
                // Set the Text to show in TextView
                text.setText("Succes");

                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();

                Intent myIntent = new Intent(AfterCart.this, Login.class);
                startActivityForResult(myIntent, 0);
                finish();

            } else if (result.equalsIgnoreCase("false")) {

                // If username and password does not match display a error message
                LayoutInflater inflater = getLayoutInflater();
                // Inflate the Layout
                View layout = inflater.inflate(R.layout.falsetoast,
                        (ViewGroup) findViewById(R.id.custom_toast_layout));

                TextView text = (TextView) layout.findViewById(R.id.textToShow);
                // Set the Text to show in TextView
                text.setText("Invalid");

                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();


            } else if (result.equalsIgnoreCase("exception") || result.equalsIgnoreCase("error with internet connection")) {

                LayoutInflater inflater = getLayoutInflater();
                // Inflate the Layout
                View layout = inflater.inflate(R.layout.exceptiontoast,
                        (ViewGroup) findViewById(R.id.custom_toast_layout));

                TextView text = (TextView) layout.findViewById(R.id.textToShow);
                // Set the Text to show in TextView
                text.setText("Error in connection");

                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);
                toast.show();


            }
        }

    }

    public void checkinsert(View arg0) {

        // Get text from email and passord field
        final String agent = uservar.getText().toString();
        final String address = addres.getText().toString();
        final String company = companys;
        adresss = String.valueOf(addres.getText());

        for (int i = 0; i < Points.itemsvar.size(); i++) {
            new AsyncSignUp().execute(agent, company, Points.itemsvar.get(i), Points.pricesvar.get(i),  address);
        }

    }
}
