package com.ilhamfidatama.DaftarKelasDicoding;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailKelas extends AppCompatActivity {
    ImageView iv;
    TextView judul, level, tipe;
    Button btnLink;
    private int posisi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_detail_kelas );

        iv = findViewById( R.id.imgKelas );
        judul = findViewById( R.id.judulKelas );
        level = findViewById( R.id.levelKelas );
        tipe = findViewById( R.id.tipeKelas );
        btnLink = findViewById( R.id.btnLinkKelas );

        getData();
        setData();
    }

    public void getData(){
        Intent intent = getIntent();
        posisi = intent.getIntExtra( "posisi", 0 );
    }

    public void setData(){
        int image = Integer.parseInt( DataKelasDicoding.data[posisi][4] );
        iv.setImageResource( image );
        judul.setText( DataKelasDicoding.data[posisi][0] );
        level.setText( DataKelasDicoding.data[posisi][1] );
        tipe.setText( DataKelasDicoding.data[posisi][2] );

        btnLink.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToClass(DataKelasDicoding.data[posisi][3]);
            }
        } );
    }

    public void goToClass(String link){
        Intent kelas = new Intent( Intent.ACTION_VIEW );
        kelas.setData(Uri.parse(link));
        startActivity( kelas );
    }
}
