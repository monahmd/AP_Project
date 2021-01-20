package com.example.myapplication;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlay {
    public static MediaPlayer player;
    public static void soundPlayer(Context ctx, int raw_id){
        player = MediaPlayer.create(ctx, raw_id);
        player.setLooping(false);
        player.setVolume(100, 100);

        player.start();
    }
}
