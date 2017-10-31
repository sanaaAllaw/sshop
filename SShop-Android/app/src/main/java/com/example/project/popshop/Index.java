package com.example.project.popshop;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Index extends AppCompatActivity {
    ImageView imgtitle;
    ImageView imgShop;
    MediaPlayer player;
    BackgroundSound mBackgroundSound;
    Button loginbtn, registrebtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        mBackgroundSound = new BackgroundSound();

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        int height = metrics.heightPixels;
        int width = metrics.widthPixels;
        Animation rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate);
        Animation fadeInAnim = AnimationUtils.loadAnimation(this, R.anim.fadin);
        imgtitle = (ImageView) findViewById(R.id.imagetitle);
        imgtitle.setAnimation(rotateAnim);

        imgtitle = (ImageView) findViewById(R.id.imgshop);
        imgtitle.setAnimation(fadeInAnim);

        //Typeface btnfonts = Typeface.createFromAsset(getAssets(), "Caeldera.ttf");

        loginbtn = (Button) findViewById(R.id.loginbtn);
        //loginbtn.setTypeface(btnfonts);

        registrebtn = (Button) findViewById(R.id.registrebtn);
        //registrebtn.setTypeface(btnfonts);
        final NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                Intent loginvar = new Intent(Index.this, Login.class);
                startActivity(loginvar);


            }
        });
        registrebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent registrevar = new Intent(Index.this, Registre.class);
                startActivity(registrevar);

            }
        });
    }

    public class BackgroundSound extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {

            return null;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        setTitle("Shopping");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

}
