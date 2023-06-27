package org.bnmit.foodplanner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // Play a sound
        MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.alarmsound);
        mediaPlayer.start();

        // Show a notification or perform any other desired action
    }
}
