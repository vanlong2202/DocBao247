package com.example.a247;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a247.Model.Paper;
import com.example.a247.fragment.ReadThePaperFragment;

import java.util.List;

public class ReadThePaperAdapter extends RecyclerView.Adapter<ReadThePaperAdapter.ReadThePaperViewHolder>{
    ReadThePaperFragment context;

    private List<Paper> paperList;
    private ItemClickListener itemClickListener;

    public ReadThePaperAdapter(ReadThePaperFragment context, List<Paper> paperList,ItemClickListener itemClickListener) {
        this.context = context;
        this.paperList = paperList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ReadThePaperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_paper,parent,false);
        return new ReadThePaperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReadThePaperViewHolder holder, int position) {
        Paper list = paperList.get(position);
        holder.tv_title.setText(list.getTitle_paper());
        holder.tv_text.setText(list.getText1_paper());
        holder.tv_time.setText(list.getTime_paper());
        holder.tv_categary.setText(list.getCategory_name());
        String image = list.getImg_paper();
        int imageResource = (context.getResources().getIdentifier(image,"drawable",context.getActivity().getPackageName()));
        holder.img_paper.setImageResource(imageResource);
    }

    @Override
    public int getItemCount() {
        return 3;
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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.OnItemClick(getAdapterPosition());
                }
            });
        }
    }
}
