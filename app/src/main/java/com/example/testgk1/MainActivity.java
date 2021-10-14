package com.example.testgk1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    RecyclerView rcv;
    CustomAdapter adt;
    List<Song> mSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv = findViewById(R.id.rcv);
        mSongs = new ArrayList<>();
        adt  =new CustomAdapter(mSongs,this);

        mSongs.add(new Song("Nước mắt tuôn rơi trò chơi kết thúc","Issac",R.drawable.headphone,R.raw.gia_nhu_ngay_dau));
        mSongs.add(new Song("Nước mắt tuôn rơi trò chơi kết thúc1","Issac1",R.drawable.hinh_anha,R.raw.gia_nhu_ngay_dau));
        mSongs.add(new Song("Nước mắt tuôn rơi trò chơi kết thúc2","Issac2",R.drawable.hinhanhb,R.raw.gia_nhu_ngay_dau));
        mSongs.add(new Song("Nước mắt tuôn rơi trò chơi kết thúc3","Issac3",R.drawable.hinhanhc,R.raw.gia_nhu_ngay_dau));
        mSongs.add(new Song("Nước mắt tuôn rơi trò chơi kết thúc4","Issac4",R.drawable.headphone,R.raw.gia_nhu_ngay_dau));
        mSongs.add(new Song("Nước mắt tuôn rơi trò chơi kết thúc5","Issac5",R.drawable.hinhanhc,R.raw.gia_nhu_ngay_dau));

        rcv.setHasFixedSize(true);
        rcv.setAdapter(adt);
        rcv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
    }

    @Override
    public void itemClick(Song song) {
        Intent intent = new Intent(MainActivity.this, SongActivity.class);
        intent.putExtra("song",song);
        intent.putExtra("listSong", (Serializable) mSongs);
        intent.putExtra("index",mSongs.indexOf(song));
        startActivity(intent);

    }

}