package com.example.vinayjohn.talviewdemoproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vinayjohn.talviewdemoproject.R;
import com.example.vinayjohn.talviewdemoproject.response.PostsModel;

import java.util.List;

/**
 * Created by vinayjohn on 25/07/18.
 */

public class PostsListCustomAdapter extends RecyclerView.Adapter<PostsListCustomAdapter.CustomViewHolder> {

    public interface OnPostsListCustomAdapterItemClickListener {
        void onPostsListCustomAdapterItemClick(String postsId);
    }

    private List<PostsModel> dataList;
    private Context context;
    private OnPostsListCustomAdapterItemClickListener onPostsListCustomAdapterItemClickListener;

    public PostsListCustomAdapter(Context context, List<PostsModel> postsList, OnPostsListCustomAdapterItemClickListener onPostsListCustomAdapterItemClickListener) {
        this.context = context;
        this.dataList = postsList;
        this.onPostsListCustomAdapterItemClickListener = onPostsListCustomAdapterItemClickListener;

    }

    @NonNull
    @Override
    public PostsListCustomAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.posts_custom_row, parent, false);
        return new PostsListCustomAdapter.CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsListCustomAdapter.CustomViewHolder holder, int position) {
        holder.txtTitle.setText(dataList.get(position).getTitle());
        holder.txtBody.setText(dataList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView txtTitle;
        TextView txtBody;

        public CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            txtTitle = mView.findViewById(R.id.posts_title);
            txtBody = mView.findViewById(R.id.posts_body);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onPostsListCustomAdapterItemClickListener.onPostsListCustomAdapterItemClick(dataList.get(getAdapterPosition()).getId());
                }
            });
        }
    }
}
