package com.example.myapplication.ui.setting;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.AudioPlay;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SettingFragment extends Fragment implements View.OnClickListener {

    private FloatingActionButton musicButton;
    int i = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        musicButton.findViewById(R.id.audio_but);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onClick(View v) {
        i++;
        Handler handler = new Handler();
        Runnable runnable =new Runnable() {
            @Override
            public void run() {
                i = 0;
            }
        };
        if (i == 1){
            AudioPlay.player.stop();
            handler.postDelayed(runnable, 400);
        }
        else if(i == 2){
            AudioPlay.player.start();
        }
        else if (i == 3){
            AudioPlay.player.stop();
            i = 0;
        }

    }
}
