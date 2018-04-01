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
public class RockSongsFragment extends Fragment {

    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mMediaPlayer.pause();
                //mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
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

    public RockSongsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list, container, false);
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Song> songs = new ArrayList<Song>();

        songs.add(new Song(getString(R.string.aerosmith), getString(R.string.aerosmith_song), R.drawable.aerosmith, R.raw.aerosmith));
        songs.add(new Song(getString(R.string.eagles), getString(R.string.eagles_song), R.drawable.eagles, R.raw.eagles));
        songs.add(new Song(getString(R.string.the_beatles), getString(R.string.the_beatles_song), R.drawable.beatles, R.raw.eagles));
        songs.add(new Song(getString(R.string.bon_jovi), getString(R.string.bon_jovi_song), R.drawable.bonjovi, R.raw.bonjovi));
        songs.add(new Song(getString(R.string.imagine_dragons), getString(R.string.imagine_dragons_song), R.drawable.imaginedragons, R.raw.imaginedragons));
        songs.add(new Song(getString(R.string.metallica), getString(R.string.metallica_song), R.drawable.metallica, R.raw.metallica));
        songs.add(new Song(getString(R.string.the_doors), getString(R.string.the_doors_song), R.drawable.thedoors, R.raw.thedoors));
        songs.add(new Song(getString(R.string.guns_n_roses), getString(R.string.guns_n_roses_song), R.drawable.guns, R.raw.gunsnroses));
        songs.add(new Song(getString(R.string.pearl_jam), getString(R.string.pearl_jam_song), R.drawable.pearljam, R.raw.pearljam));
        songs.add(new Song(getString(R.string.pink_floyd), getString(R.string.pink_floyd_song), R.drawable.pinkfloyd, R.raw.pinkfloyd));


        SongAdapter adapter = new SongAdapter(getActivity(), songs, R.color.category_rock_songs_color);

        ListView listView = (ListView)rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                releaseMediaPlayer();
                Song song = songs.get(position);
                int result = mAudioManager.requestAudioFocus(mAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    //mAudioManager.registerMediaButtonEventReceiver();

                    mMediaPlayer = MediaPlayer.create(getContext(), song.getAudioRsourceId());
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
            // Set the media player back to null
            mMediaPlayer = null;
            mAudioManager.abandonAudioFocus(mAudioFocusChangeListener);
        }
    }


    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}

