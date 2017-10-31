package com.example.project.popshop;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {
    static String POSNAME;

    // Declare Variables
    Context mContext;
    LayoutInflater inflater;
    private List<WorldPopulation> worldpopulationlist = null;
    private ArrayList<WorldPopulation> arraylist;

    public ListViewAdapter(Context context, List<WorldPopulation> worldpopulationlist) {
        mContext = context;
        this.worldpopulationlist = worldpopulationlist;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<WorldPopulation>();
        this.arraylist.addAll(worldpopulationlist);
    }


    public class ViewHolder {
        TextView rank;
        TextView country;
        TextView population;
        ImageView img;
    }

    @Override
    public int getCount() {
        return worldpopulationlist.size();
    }

    @Override
    public WorldPopulation getItem(int position) {
        return worldpopulationlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.company_style, null);
            // Locate the TextViews in listview_item.xml
            holder.rank = (TextView) view.findViewById(R.id.rank);
            holder.country = (TextView) view.findViewById(R.id.country);
            holder.population = (TextView) view.findViewById(R.id.population);

            holder.img = (ImageView) view.findViewById(R.id.imageView);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews


        holder.rank.setText(worldpopulationlist.get(position).getRank());
        holder.country.setText(worldpopulationlist.get(position).getCountry());
        holder.population.setText(worldpopulationlist.get(position).getPopulation());
        Login.stcompany=worldpopulationlist.get(position).getCountry();

        final String imgURL = "http://" + functions.ipaddress+"/client/"+worldpopulationlist.get(position).getImgS();

        new DownLoadImageTask(holder.img).execute(imgURL);

        // Listen for ListView Item Click
        view.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent pointItems = new Intent(mContext, PointItems.class);
                pointItems.putExtra("nameWelcome", worldpopulationlist.get(position).getCountry());
                mContext.startActivity(pointItems);


            }
        });

        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        worldpopulationlist.clear();
        if (charText.length() == 0) {
            worldpopulationlist.addAll(arraylist);
        } else {
            for (WorldPopulation wp : arraylist) {
                if (wp.getCountry().toLowerCase(Locale.getDefault()).contains(charText)) {
                    worldpopulationlist.add(wp);
                }
            }
        }
        notifyDataSetChanged();
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
            Bitmap bitmap = logo;
           /* Bitmap circleBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);

            BitmapShader shader = new BitmapShader(bitmap,  Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            Paint paint = new Paint();
            paint.setShader(shader);
            paint.setAntiAlias(true);
            Canvas c = new Canvas(circleBitmap);
            c.drawCircle(bitmap.getWidth()/2, bitmap.getHeight()/2, bitmap.getWidth()/2, paint);*/


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


}
