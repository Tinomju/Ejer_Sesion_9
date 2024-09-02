package com.utic.mediaplayerandroid;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    // variables y objetos
    MediaPlayer mediaPlayer;
    Button btnPlay,btnResume,btnPause,btnStop;
    RadioButton radio01,radio02,radio03,radio04,radio05,radio06,radio07;
    int posicion=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //botones
        btnPlay = (Button)findViewById(R.id.btnPlay);
        btnPause = (Button)findViewById(R.id.btnPause);
        btnResume = (Button)findViewById(R.id.btnResume);
        btnStop = (Button)findViewById(R.id.btnStop);

        //radio botones

        radio01=(RadioButton)findViewById(R.id.radio01);
        radio02=(RadioButton)findViewById(R.id.radio02);
        radio03=(RadioButton)findViewById(R.id.radio03);
        radio04=(RadioButton)findViewById(R.id.radio04);
        radio05=(RadioButton)findViewById(R.id.radio05);
        radio06=(RadioButton)findViewById(R.id.radio06);
        radio07=(RadioButton)findViewById(R.id.radio07);
    }

    //métodos
    public void destruir() {
        if(mediaPlayer!=null){
            mediaPlayer.release();
        }
    }

    public void reproducir(View view) {
        //liberar el reproductor
        destruir();
        //reproducción
        if(radio01.isChecked()) {
            mediaPlayer=mediaPlayer.create(this,R.raw.pista01);
        }
        if(radio02.isChecked()) {
            mediaPlayer=mediaPlayer.create(this,R.raw.pista02);
        }
        if(radio03.isChecked()) {
            mediaPlayer=mediaPlayer.create(this,R.raw.pista03);
        }
        if(radio04.isChecked()) {
            mediaPlayer=mediaPlayer.create(this,R.raw.pista04);
        }
        if(radio05.isChecked()) {
            mediaPlayer=mediaPlayer.create(this,R.raw.pista05);
        }
        if(radio06.isChecked()) {
            mediaPlayer=new MediaPlayer();
            try {
                mediaPlayer.setDataSource("https://techtransfer.com.py/music/pista06.mp3");
                mediaPlayer.prepare();
            } catch (IOException e) {
            }
        }
        if(radio07.isChecked()) {
            mediaPlayer=new MediaPlayer();
            try {
                mediaPlayer.setDataSource("https://techtransfer.com.py/music/pista07.mp3");
                mediaPlayer.prepare();
            } catch (IOException e) {
            }
        }
        //play
        mediaPlayer.start();
    }

    public void pausar(View view) {
        if(mediaPlayer!=null &&mediaPlayer.isPlaying()) {
            posicion=mediaPlayer.getCurrentPosition();
            mediaPlayer.pause();
        }
    }

    public void continuar(View view) {
        if (mediaPlayer!=null && mediaPlayer.isPlaying()==false) {
            mediaPlayer.seekTo(posicion);
            mediaPlayer.start();
        }
    }

    public void detener(View view) {
        if (mediaPlayer!=null){
            mediaPlayer.stop();
            posicion=0;
        }
    }

}