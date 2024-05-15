package com.example.a247;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReadThePaperAdapter extends RecyclerView.Adapter<ReadThePaperAdapter.ReadThePaperViewHolder>{
    private Context context;

    private List<ListPaper> paperList;

    public ReadThePaperAdapter(Context context, List<ListPaper> paperList) {
        this.context = context;
        this.paperList = paperList;
    }

    @NonNull
    @Override
    public ReadThePaperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_paper,parent,false);
        return new ReadThePaperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReadThePaperViewHolder holder, int position) {
        ListPaper list = paperList.get(position);
        holder.img_paper.setImageResource(list.getImg_paper());
        holder.tv_title.setText(list.getTv_title());
        holder.tv_text.setText(list.getTv_text());
        holder.tv_time.setText(list.getTv_time());
        holder.tv_categary.setText(list.getTv_categorypaper());
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class ReadThePaperViewHolder extends RecyclerView.ViewHolder{
        ImageView img_paper;
        TextView tv_title, tv_text, tv_time, tv_categary;

        public ReadThePaperViewHolder(@NonNull View itemView) {
            super(itemView);
            img_paper = itemView.findViewById(R.id.img_paperR);
            tv_title = itemView.findViewById(R.id.tv_titleR);
            tv_text = itemView.findViewById(R.id.tv_textR);
            tv_time= itemView.findViewById(R.id.tv_timeR);
            tv_categary = itemView.findViewById(R.id.tv_categoryPaperR);
        }
    }
}
