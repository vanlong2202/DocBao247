package com.example.a247;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a247.Model.Comment;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {
    private Context context;
    private List<Comment> commetPaperList;

    public CommentAdapter(Context context, List<Comment> commetPaperList) {
        this.context = context;
        this.commetPaperList = commetPaperList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_commet,parent,false);
        return new CommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        Comment comment = commetPaperList.get(position);
        holder.tv_username.setText(String.valueOf(comment.getFullname()));
        holder.tv_timeComment.setText(comment.getTime_comment());
        holder.tv_textComment.setText(comment.getText_comment());
        holder.tv_date.setText(comment.getDate_comment());
    }

    @Override
    public int getItemCount() {
        return commetPaperList.size();
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder{
        TextView tv_username, tv_timeComment, tv_textComment, tv_date;
        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_username = itemView.findViewById(R.id.tv_username);
            tv_timeComment = itemView.findViewById(R.id.tv_timeComment);
            tv_textComment = itemView.findViewById(R.id.tv_textCommet);
            tv_date = itemView.findViewById(R.id.tv_dateComment);
        }
    }

}
