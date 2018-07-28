package com.example.vinayjohn.talviewdemoproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.vinayjohn.talviewdemoproject.R;
import com.example.vinayjohn.talviewdemoproject.response.PhotosModel;


import java.util.List;

/**
 * Created by vinayjohn on 25/07/18.
 */

public class PhotoListCustomAdapter extends RecyclerView.Adapter<PhotoListCustomAdapter.CustomViewHolder> {

    public interface OnPhotoListCustomAdapterItemClickListener {
        void onPhotoListCustomAdapterItemClick(String photoUrl);
    }

    private List<PhotosModel> dataList;
    private Context context;
    private OnPhotoListCustomAdapterItemClickListener onPhotoListCustomAdapterItemClickListener;

    public PhotoListCustomAdapter(Context context, List<PhotosModel> dataList,
                                  OnPhotoListCustomAdapterItemClickListener onPhotoListCustomAdapterItemClickListener) {
        this.context = context;
        this.dataList = dataList;
        this.onPhotoListCustomAdapterItemClickListener = onPhotoListCustomAdapterItemClickListener;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView txtTitle;
        private ImageView coverImage;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            txtTitle = mView.findViewById(R.id.title);
            coverImage = mView.findViewById(R.id.coverImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onPhotoListCustomAdapterItemClickListener.onPhotoListCustomAdapterItemClick(dataList.get(getAdapterPosition()).getUrl());
                }
            });
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.photos_custom_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.txtTitle.setText(dataList.get(position).getTitle());

        RequestOptions requestOptions = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.NONE) // because file name is always same
                .skipMemoryCache(true);
        Glide.with(context)
                .load(dataList.get(position).getThumbnailUrl())
                .apply(requestOptions)
                .into(holder.coverImage);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
