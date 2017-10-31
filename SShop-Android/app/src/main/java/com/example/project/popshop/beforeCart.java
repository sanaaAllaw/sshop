package com.example.project.popshop;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;

public class beforeCart extends AppCompatActivity {
    String name, price, description, qty;
    ImageView imgfilt;
    TextView t1, t2, t3, t4;
    EditText editqty;
    Button addcart;
    ProgressDialog pdLoading;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_cart);
        pdLoading = new ProgressDialog(beforeCart.this);
        pdLoading.setMessage("\tLoading...");
        pdLoading.setCancelable(false);
        pdLoading.show();
        Intent i = getIntent();
        name = i.getStringExtra("name");
        price = i.getStringExtra("price");
        description = i.getStringExtra("desc");
        qty = i.getStringExtra("qty");
        t1 = (TextView) findViewById(R.id.itemname);
        t2 = (TextView) findViewById(R.id.itemPrice);
        //t3 = (TextView) findViewById(R.id.txtdesc);
        t4 = (TextView) findViewById(R.id.itemqty);
        imgfilt = (ImageView) findViewById(R.id.circleImage);

        t1.setText(name);
        t2.setText(price + "L.L");
        // t3.setText(description);
        t4.setText("available qty :" + qty);
        addcart = (Button) findViewById(R.id.button);
        new DownLoadImageTask(imgfilt).execute(PointItems.imgFilter);
        pdLoading.dismiss();
        editqty = (EditText) findViewById(R.id.itemqtyedit);
        addcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editqty.getText().equals("")) {
                    String value = editqty.getText().toString();
                    int finalValue = Integer.parseInt(value);

                    if (finalValue < 1 || finalValue > Integer.parseInt(qty)) {
                        LayoutInflater inflater = getLayoutInflater();
                        // Inflate the Layout
                        View layout = inflater.inflate(R.layout.falsetoast,
                                (ViewGroup) findViewById(R.id.custom_toast_layout));

                        TextView text = (TextView) layout.findViewById(R.id.textToShow);
                        // Set the Text to show in TextView
                        text.setText("Invalid input or qty unavailable");

                        Toast toast = new Toast(getApplicationContext());
                        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                        toast.setDuration(Toast.LENGTH_LONG);
                        toast.setView(layout);
                        toast.show();
                    } else {
                        Points.itemsvar.add(name);
                        Points.pricesvar.add(price);
                        Points.qtyvar.add(String.valueOf(finalValue));
                        Time now=new Time();
                        now.setToNow();
                        Points.totalPrice=Points.totalPrice+(Double.parseDouble(price)*finalValue);

                        Points.DateVar.add(now.format("%K:%M:%S"));
                        finalValue=Integer.parseInt(qty)-finalValue;
                        t4.setText("available qty: "+finalValue);
                        editqty.setText("");
                        editqty.setFocusable(true);
                    }
                } else {

                }


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cart_menu, menu);
        return true;
    }


    private class DownLoadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

        public DownLoadImageTask(ImageView imageView) {
            this.imageView = imageView;
        }

        /*
            doInBackground(Params... params)
                Override this method to perform a computation on a background thread.
         */
        protected Bitmap doInBackground(String... urls) {
            String urlOfImage = urls[0];
            Bitmap logo = null;
            try {
                InputStream is = new URL(urlOfImage).openStream();
                /*
                    decodeStream(InputStream is)
                        Decode an input stream into a bitmap.
                 */
                logo = BitmapFactory.decodeStream(is);
            } catch (Exception e) { // Catch the download exception
                e.printStackTrace();
            }

            return logo;
        }

        /*
            onPostExecute(Result result)
                Runs on the UI thread after doInBackground(Params...).
         */

        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        Intent PointsVar = new Intent(beforeCart.this, Points.class);
        startActivity(PointsVar);

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cartIcon:
                Intent cartVar = new Intent(this, AfterCart.class);
                startActivity(cartVar);
                beforeCart.this.finish();
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }
}
