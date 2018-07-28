package com.example.vinayjohn.talviewdemoproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vinayjohn.talviewdemoproject.R;
import com.example.vinayjohn.talviewdemoproject.response.CommentsModel;

import java.util.List;

/**
 * Created by vinayjohn on 25/07/18.
 */

public class CommentsListCustomAdapter extends RecyclerView.Adapter<CommentsListCustomAdapter.CustomViewHolder> {

    private List<CommentsModel> dataList;
    private Context context;

    public CommentsListCustomAdapter(Context context, List<CommentsModel> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public CommentsListCustomAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.comments_custom_row, parent, false);
        return new CommentsListCustomAdapter.CustomViewHolder(view);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView commentsName;
        TextView commentsBody;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            commentsName = mView.findViewById(R.id.comment_name);
            commentsBody = mView.findViewById(R.id.comment_body);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsListCustomAdapter.CustomViewHolder holder, int position) {
        holder.commentsBody.setText(dataList.get(position).getBody());
        holder.commentsName.setText(dataList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
