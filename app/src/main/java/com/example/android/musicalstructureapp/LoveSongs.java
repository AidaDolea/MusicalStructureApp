package com.example.android.musicalstructureapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Dolea on 17.03.2018.
 */

public class LoveSongs extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.love_songs);

        ArrayList<Song> songs= new ArrayList<Song>();

        songs.add(new Song(getString(R.string.whitney_huston), getString(R.string.whitney_song), R.drawable.whitney));
        songs.add(new Song(getString(R.string.percy_sledge), getString(R.string.percy_song),R.drawable.percy));
        songs.add(new Song(getString(R.string.savage_garden), getString(R.string.savage_garden_song),R.drawable.savage));
        songs.add(new Song(getString(R.string.ed_sheeran), getString(R.string.sheeran_song),R.drawable.sheeran));
        songs.add(new Song(getString(R.string.ll_cool_j), getString(R.string.ll_cool_j_song),R.drawable.coolj));
        songs.add(new Song(getString(R.string.rihanna), getString(R.string.rihanna_song),R.drawable.rihanna));
        songs.add(new Song(getString(R.string.john_legend), getString(R.string.john_legend_song),R.drawable.john));
        songs.add(new Song(getString(R.string.leona_lewis), getString(R.string.leona_song),R.drawable.leona));
        songs.add(new Song(getString(R.string.taylor_swift), getString(R.string.taylor_swift_song),R.drawable.taylor));
        songs.add(new Song(getString(R.string.lana_del_rey), getString(R.string.lana_song),R.drawable.lana));


        SongAdapter adapter = new SongAdapter(this, songs, R.color.category_love_songs_color);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

    }
}