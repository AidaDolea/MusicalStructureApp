package com.example.android.musicalstructureapp;

/**
 * Created by Dolea on 17.03.2018.
 */

public class Song {

    private String mArtistName;
    private String mSongName;
    private int mImageResourceId;
    private int audioResourceId;

    public Song(String artistName, String songName, int imageResourceId, int audioResourceId) {
        mArtistName = artistName;
        mSongName = songName;
        mImageResourceId = imageResourceId;
        this.audioResourceId= audioResourceId;
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

    public int getAudioRsourceId(){

        return audioResourceId;
    }
}
