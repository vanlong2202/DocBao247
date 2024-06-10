package com.example.a247;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a247.DAO.CommentDAO;
import com.example.a247.Model.Comment;

import java.util.List;

public class ListCommentAdapter extends RecyclerView.Adapter<ListCommentAdapter.ListCommentViewHolder>{
    private List<Comment> mlist;
    private Context context;

    public ListCommentAdapter(List<Comment> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }

    @NonNull
    @Override
    public ListCommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment_layout,parent,false);
        return new ListCommentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListCommentViewHolder holder, int position) {
        Comment comment = mlist.get(position);
        holder.tv_textComment.setText(comment.getText_comment());
        holder.tv_time.setText(comment.getTime_comment());
        holder.tv_date.setText(comment.getDate_comment());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int paperID = comment.getPaperID();
                Intent intent = new Intent(v.getContext(), DetailReadPaper.class);
                intent.putExtra("PaperID",paperID);
                context.startActivity(intent);
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int CommentID = comment.getCommentID();
                CommentDAO commentDAO = new CommentDAO(v.getContext());
                commentDAO.DeleteComment(CommentID);
                Intent intent = new Intent(context,CommentUser.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class ListCommentViewHolder extends RecyclerView.ViewHolder{
        TextView tv_textComment, tv_time, tv_date;
        CardView view, delete;
        public ListCommentViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_textComment = itemView.findViewById(R.id.tv_textCommet);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_date = itemView.findViewById(R.id.tv_date);
            view = itemView.findViewById(R.id.View);
            delete = itemView.findViewById(R.id.Delete);
        }
    }
}
