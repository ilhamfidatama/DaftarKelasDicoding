package com.ilhamfidatama.DaftarKelasDicoding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<KelasDicoding> daftar = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        rvCategory = findViewById( R.id.rv );
        rvCategory.setHasFixedSize( true );

        daftar.addAll(DataKelasDicoding.getListKelasDicoding());
        showListKelas();
    }

    public void showListKelas(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        DataAdapter adapter = new DataAdapter(this);
        adapter.setListKelas(daftar);
        rvCategory.setAdapter(adapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener( new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showDetailData(daftar.get(position), position);
            }
        } );
    }

    public void showDetailData(KelasDicoding daftar, int position){
        Intent intent = new Intent( this, DetailKelas.class );
        intent.putExtra( "posisi", position );
        startActivity( intent );
    }
}
