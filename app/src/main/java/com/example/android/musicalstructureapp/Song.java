package com.example.android.musicalstructureapp;

/**
 * Created by Dolea on 17.03.2018.
 */

public class Song {

    private String mArtistName;
    private String mSongName;
    private int mImageResourceId;

    public Song(String artistName, String songName, int imageResourceId) {
        mArtistName = artistName;
        mSongName = songName;
        mImageResourceId = imageResourceId;
    }

    public String getmArtistName() {
        return mArtistName;
    }

    public String getmSongName() {

        return mSongName;
    }

    public int getmResourceImageId() {

        return mImageResourceId;
    }
}