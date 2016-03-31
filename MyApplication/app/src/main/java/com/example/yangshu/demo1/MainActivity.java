package com.example.yangshu.demo1;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static String TAG = "Activity demo";

    private Button button;

    private TextView textView;
    private MediaPlayer mediaPlayer;
    private int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Log.i(TAG, "MainActivity onCreate");
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(this);

        mediaPlayer=MediaPlayer.create(this,R.raw.sing);
        mediaPlayer.start();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"MainActivity onStart");
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "MainActivity onPause");
        if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
            position=mediaPlayer.getCurrentPosition();
        }
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "MainActivity onRestart");
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "MainActivity onResume");
        super.onResume();
        if(position!=0){
            mediaPlayer.seekTo(position);
            mediaPlayer.start();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "MainActivity onStop");
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "MainActivity onDestroy");
        super.onDestroy();

        if(mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer=null;

        }
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
