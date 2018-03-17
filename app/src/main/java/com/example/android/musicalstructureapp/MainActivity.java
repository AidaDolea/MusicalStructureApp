package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView love_songs = findViewById(R.id.love_songs);

        love_songs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent love_songs_intent = new Intent(MainActivity.this, LoveSongs.class);
                startActivity(love_songs_intent);
            }
        });

        TextView rock_songs = findViewById(R.id.rock_songs);

        rock_songs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rock_songs_intent = new Intent(MainActivity.this, RockSongs.class);
                startActivity(rock_songs_intent);
            }
        });
    }
}
