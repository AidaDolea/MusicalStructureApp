package com.example.android.musicalstructureapp;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoveSongsFragment extends Fragment {

    MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener= new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange== AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mMediaPlayer.pause();
                //mMediaPlayer.seekTo(0);
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_GAIN ){
                mMediaPlayer.start();
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_LOSS){
                releaseMediaPlayer();
            }

        }
    };
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    public LoveSongsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.love_songs, container, false);

        /** TODO: Insert all the code from the NumberActivity’s onCreate() method after the setContentView method call */



        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Song> songs= new ArrayList<Song>();

        songs.add(new Song(getString(R.string.whitney_huston), getString(R.string.whitney_song), R.drawable.whitney,R.raw.whitney));
        songs.add(new Song(getString(R.string.percy_sledge), getString(R.string.percy_song),R.drawable.percy,R.raw.percysledge));
        songs.add(new Song(getString(R.string.savage_garden), getString(R.string.savage_garden_song),R.drawable.savage,R.raw.savage));
        songs.add(new Song(getString(R.string.ed_sheeran), getString(R.string.sheeran_song),R.drawable.sheeran, R.raw.edsheeran));
        songs.add(new Song(getString(R.string.ll_cool_j), getString(R.string.ll_cool_j_song),R.drawable.coolj, R.raw.llcoolj));
        songs.add(new Song(getString(R.string.rihanna), getString(R.string.rihanna_song),R.drawable.rihanna, R.raw.rihanna));
        songs.add(new Song(getString(R.string.john_legend), getString(R.string.john_legend_song),R.drawable.john, R.raw.johnlegend));
        songs.add(new Song(getString(R.string.leona_lewis), getString(R.string.leona_song),R.drawable.leona, R.raw.leonalewis));
        songs.add(new Song(getString(R.string.taylor_swift), getString(R.string.taylor_swift_song),R.drawable.taylor, R.raw.taylorswift));
        songs.add(new Song(getString(R.string.lana_del_rey), getString(R.string.lana_song),R.drawable.lana, R.raw.lanadelrey));


        SongAdapter adapter = new SongAdapter(getActivity(), songs, R.color.category_love_songs_color);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();
                Song song = songs.get(position);
                int result= mAudioManager.requestAudioFocus(mAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN );

                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(getActivity(), song.getAudioRsourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });
        return rootView;
    }



    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at th
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mAudioFocusChangeListener);
        }
    }
    @Override
    public void onStop() {
        super.onStop();

        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }

}
