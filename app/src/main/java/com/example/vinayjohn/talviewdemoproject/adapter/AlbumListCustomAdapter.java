package com.example.vinayjohn.talviewdemoproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vinayjohn.talviewdemoproject.R;
import com.example.vinayjohn.talviewdemoproject.response.AlbumsModel;

import java.util.List;

/**
 * Created by vinayjohn on 25/07/18.
 */

public class AlbumListCustomAdapter extends RecyclerView.Adapter<AlbumListCustomAdapter.CustomViewHolder> {

    public interface OnAlbumListCustomAdapterItemClickListener {
        void onAlbumListCustomAdapterItemClick(String albumId);
    }

    private List<AlbumsModel> dataList;
    private Context context;
    private OnAlbumListCustomAdapterItemClickListener onAlbumListCustomAdapterItemClickListener;

    public AlbumListCustomAdapter(Context context, List<AlbumsModel> dataList,
                                  OnAlbumListCustomAdapterItemClickListener onAlbumListCustomAdapterItemClickListener) {
        this.context = context;
        this.dataList = dataList;
        this.onAlbumListCustomAdapterItemClickListener = onAlbumListCustomAdapterItemClickListener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.albums_custom_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.txtTitle.setText(dataList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView txtTitle;


        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            txtTitle = mView.findViewById(R.id.album_title);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onAlbumListCustomAdapterItemClickListener.onAlbumListCustomAdapterItemClick(dataList.get(getAdapterPosition()).getId());
                }
            });
        }
    }
}
