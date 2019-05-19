package com.ilhamfidatama.DaftarKelasDicoding;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ItemClickSupport {
    private final RecyclerView rv;
    private OnItemClickListener itemClickListener;

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (itemClickListener != null){
                RecyclerView.ViewHolder viewHolder = rv.getChildViewHolder(v);
                itemClickListener.onItemClicked(rv, viewHolder.getAdapterPosition(), v);
            }
        }
    };

    private RecyclerView.OnChildAttachStateChangeListener attachListener =new RecyclerView.OnChildAttachStateChangeListener() {
        @Override
        public void onChildViewAttachedToWindow(@NonNull View view) {
            if (itemClickListener!=null){
                view.setOnClickListener( clickListener );
            }
        }

        @Override
        public void onChildViewDetachedFromWindow(@NonNull View view) {

        }
    };

    public static ItemClickSupport addTo(RecyclerView recyclerView){
        ItemClickSupport support = (ItemClickSupport) recyclerView.getTag(R.id.item_click_support);
        if (support == null){
            support = new ItemClickSupport( recyclerView );
        }
        return support;
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        itemClickListener = listener;
    }

    public ItemClickSupport(RecyclerView recyclerView) {
        rv = recyclerView;
        rv.setTag( R.id.item_click_support, null );
        rv.addOnChildAttachStateChangeListener( attachListener );
    }

    public interface OnItemClickListener{
        void onItemClicked(RecyclerView recyclerView, int position, View v);
    }
}
