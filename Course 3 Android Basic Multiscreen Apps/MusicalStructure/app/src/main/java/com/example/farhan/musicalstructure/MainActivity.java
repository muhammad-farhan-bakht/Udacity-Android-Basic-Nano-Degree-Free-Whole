package com.example.farhan.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Getting Id's of Buttons to perform some task on them.
        Button btnSongList = (Button) findViewById(R.id.btnSongList);
        Button btnNowPlaying = (Button) findViewById(R.id.btnNowPlaying);
        Button btnRecentPlay = (Button) findViewById(R.id.btnRecentPlay);

        //Song List button when Clicked this action will be performed.
        btnSongList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Activity_SongList.class);
                startActivity(intent);
            }
        });

        //Now Playing button when Clicked this action will be performed.
        btnNowPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Activity_NowPlaying.class);
                startActivity(intent);
            }
        });

        //Recent SongList button when Clicked this action will be performed.
        btnRecentPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Activity_RecentPlaylist.class);
                startActivity(intent);
            }
        });
    }
}
