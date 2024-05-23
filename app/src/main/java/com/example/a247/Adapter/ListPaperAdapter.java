package com.example.a247.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a247.ItemClickListener;
import com.example.a247.ListPaper;
import com.example.a247.R;

import java.util.List;

public class ListPaperAdapter extends RecyclerView.Adapter<ListPaperAdapter.ListPaperHolder>{
    private List<ListPaper> paperList;
    private ItemClickListener itemClickListener;

    public ListPaperAdapter(List<ListPaper> paperList, ItemClickListener itemClickListener) {
        this.paperList = paperList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ListPaperHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.paper_list_home,parent,false);
        return new ListPaperHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListPaperHolder holder, int position) {
        ListPaper list = paperList.get(position);
        holder.img_paper.setImageResource(list.getImg_paper());
        holder.tv_title.setText(list.getTv_title());
        holder.tv_text.setText(list.getTv_text());
        holder.tv_time.setText(list.getTv_time());
    }

    @Override
    public int getItemCount() {
        return paperList.size();
    }

    public class ListPaperHolder extends RecyclerView.ViewHolder{
        private ImageView img_paper;
        private TextView tv_title, tv_text, tv_time, tv_categorypaper;
        public ListPaperHolder(@NonNull View itemView) {
            super(itemView);
            img_paper = itemView.findViewById(R.id.img_paper);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_text = itemView.findViewById(R.id.tv_text);
            tv_time = itemView.findViewById(R.id.tv_time);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.OnItemClick(getAdapterPosition());
                }
            });
        }
    }
}
