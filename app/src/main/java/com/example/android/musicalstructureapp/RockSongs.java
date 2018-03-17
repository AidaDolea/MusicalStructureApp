package com.example.android.musicalstructureapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Dolea on 17.03.2018.
 */

public class RockSongs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rock_songs);

        ArrayList<Song> songs = new ArrayList<Song>();

        songs.add(new Song(getString(R.string.aerosmith), getString(R.string.aerosmith_song), R.drawable.aerosmith));
        songs.add(new Song(getString(R.string.eagles), getString(R.string.eagles_song), R.drawable.eagles));
        songs.add(new Song(getString(R.string.the_beatles), getString(R.string.the_beatles_song), R.drawable.beatles));
        songs.add(new Song(getString(R.string.bon_jovi), getString(R.string.bon_jovi_song), R.drawable.bonjovi));
        songs.add(new Song(getString(R.string.imagine_dragons), getString(R.string.imagine_dragons_song), R.drawable.imaginedragons));
        songs.add(new Song(getString(R.string.metallica), getString(R.string.metallica_song), R.drawable.metallica));
        songs.add(new Song(getString(R.string.the_doors), getString(R.string.the_doors_song), R.drawable.thedoors));
        songs.add(new Song(getString(R.string.guns_n_roses), getString(R.string.guns_n_roses_song), R.drawable.guns));
        songs.add(new Song(getString(R.string.pearl_jam), getString(R.string.pearl_jam_song), R.drawable.pearljam));
        songs.add(new Song(getString(R.string.pink_floyd), getString(R.string.pink_floyd_song), R.drawable.pinkfloyd));


        SongAdapter adapter = new SongAdapter(this, songs, R.color.category_rock_songs_color);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

    }
}

