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

import java.util.List;

public class PaperCategoryAdapter extends RecyclerView.Adapter<PaperCategoryAdapter.PaperCategoryViewHolder>{
    private List<Paper> mlist;
    private Context context;
    private ItemClickListener itemClickListener;

    public PaperCategoryAdapter(List<Paper> mlist, Context context,ItemClickListener itemClickListener) {
        this.mlist = mlist;
        this.context = context;
        this.itemClickListener = itemClickListener;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PaperCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_paper_category,parent,false);
        return new PaperCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaperCategoryViewHolder holder, int position) {
        Paper paper = mlist.get(position);
        holder.tv_title.setText(paper.getTitle_paper());
        holder.tv_text.setText(paper.getText1_paper());
        holder.tv_time.setText(paper.getTime_paper());
        holder.tv_categoryName.setText(paper.getCategory_name());
        String image = paper.getImg_paper();
        int imageResource = (context.getResources().getIdentifier(image,"drawable",context.getPackageName()));
        holder.img_paper.setImageResource(imageResource);
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class PaperCategoryViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title, tv_text, tv_time, tv_categoryName, tv_date;
        ImageView img_paper;
        public PaperCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_titlepaper);
            tv_text = itemView.findViewById(R.id.tv_textpaper);
            tv_time = itemView.findViewById(R.id.tv_timepaper);
            tv_categoryName = itemView.findViewById(R.id.tv_categoryName);
            tv_date = itemView.findViewById(R.id.tv_datePaper);
            img_paper = itemView.findViewById(R.id.img_paper);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.OnItemClick(getAdapterPosition());
                }
            });
        }
    }
}
