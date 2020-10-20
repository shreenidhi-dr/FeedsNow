package com.feedsnow.sagar.feedsnow.activity;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.feedsnow.sagar.feedsnow.R;
import com.feedsnow.sagar.feedsnow.adapter.CategoryAdapter;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    Toolbar toolbar;

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu, menu);
            return super.onCreateOptionsMenu(menu);
        }

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            mContext = this;
            ViewPager viewPager = findViewById(R.id.viewPager);
            CategoryAdapter adapter = new CategoryAdapter(mContext, getSupportFragmentManager());
            viewPager.setAdapter(adapter);
            TabLayout tabLayout = findViewById(R.id.tabs);
            tabLayout.setupWithViewPager(viewPager);
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            toolbar.setTitle("FeedsNOW");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                toolbar.setElevation(10.f);

            }


        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_exit) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage(Html.fromHtml("<font color='#FFFFFF'>Are you sure you want to exit?</font>"));
            builder.setCancelable(true);
            builder.setNegativeButton(Html.fromHtml("<font color='#FFFFFF'>Yes</font>"), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    finish();
                }
            });
            builder.setPositiveButton(Html.fromHtml("<font color='#FFFFFF'>NO</font>"), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLACK));


        }
        if(id == R.id.menu_version){
            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage(Html.fromHtml("<font color='#FFFFFF'>Currently,You are using VERSION 1.0</font>"));
            builder.setCancelable(true);
            builder.setNegativeButton(Html.fromHtml("<font color='#FFFFFF'>OK</font>"), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    dialogInterface.cancel();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLACK));

        }
        if(id==R.id.menu_about){
            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            String about1="FeedsNOW";
            String about2="The AIO News Application";
            String about3="Developed by Sagar";
            builder.setMessage(Html.fromHtml("<font color='#FFFFFF'>"+about1+"<br>"+about2+"<br>"+about3+"</font>"));
            builder.setCancelable(true);
            builder.setNegativeButton(Html.fromHtml("<font color='#FFFFFF'>OK</font>"), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    dialogInterface.cancel();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLACK));

        }
        return super.onOptionsItemSelected(item);
    }
    public void onBackPressed(){
            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage(Html.fromHtml("<font color='#FFFFFF'>Are you sure you want to exit?</font>"));
            builder.setCancelable(true);
            builder.setNegativeButton(Html.fromHtml("<font color='#FFFFFF'>Yes</font>"), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    finish();
                }
            });
            builder.setPositiveButton(Html.fromHtml("<font color='#FFFFFF'>No</font>"), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLACK));



        }

}