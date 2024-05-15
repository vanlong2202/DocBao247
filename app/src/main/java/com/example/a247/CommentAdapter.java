package com.example.a247;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Comment;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {
    private Context context;
    private List<CommetPaper> commetPaperList;

    public CommentAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<CommetPaper> commetPaperList) {
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
        CommetPaper comment = commetPaperList.get(position);
        holder.tv_username.setText(comment.getTv_username());
        holder.tv_timeComment.setText(comment.getTv_timeComment());
        holder.tv_textComment.setText(comment.getTv_textComment());
    }

    @Override
    public int getItemCount() {
        return commetPaperList.size();
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder{
        TextView tv_username, tv_timeComment, tv_textComment;
        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_username = itemView.findViewById(R.id.tv_username);
            tv_timeComment = itemView.findViewById(R.id.tv_timeComment);
            tv_textComment = itemView.findViewById(R.id.tv_textCommet);
        }
    }

}
