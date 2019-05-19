package com.ilhamfidatama.DaftarKelasDicoding;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<KelasDicoding> listKelas;

    public DataAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<KelasDicoding> getListKelas() {
        return listKelas;
    }

    public void setListKelas(ArrayList<KelasDicoding> listKelas) {
        this.listKelas = listKelas;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from( viewGroup.getContext()).inflate( R.layout.list, viewGroup, false );
        return new CategoryViewHolder( itemRow );
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.namaKelas.setText(getListKelas().get( position ).getKelas());
        int logo = Integer.parseInt( getListKelas().get(position).getGambar() );

        Glide.with(context)
                .load(logo)
                .apply(new RequestOptions().override( 150, 150))
                .into(categoryViewHolder.gambar);
    }

    @Override
    public int getItemCount() {
        return getListKelas().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView namaKelas;
        ImageView gambar;
        public CategoryViewHolder(@NonNull View itemView) {
            super( itemView );
            namaKelas = itemView.findViewById( R.id.nameList );
            gambar = itemView.findViewById( R.id.imgList );
        }
    }
}
