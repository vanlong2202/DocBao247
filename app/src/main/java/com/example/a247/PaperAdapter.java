package com.example.a247;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a247.Model.Paper;
import com.example.a247.fragment.HomeFragment;

import java.util.List;

public class PaperAdapter extends RecyclerView.Adapter<PaperAdapter.PaperViewHolder>{
    private List<Paper> mlist;
    HomeFragment context;
    private ItemClickListener itemClickListener;

    public PaperAdapter(List<Paper> mlist, HomeFragment context, ItemClickListener itemClickListener) {
        this.mlist = mlist;
        this.context = context;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public PaperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.paper_list_home,parent,false);
        return new PaperViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaperViewHolder holder, int position) {
        Paper paper = mlist.get(position);
        String image = paper.getImg_paper();
        int imageResource = (context.getResources().getIdentifier(image,"drawable",context.getActivity().getPackageName()));
        holder.img_paper.setImageResource(imageResource);
        holder.tv_title.setText(paper.getTitle_paper());
        holder.tv_text.setText(paper.getText1_paper());
        holder.tv_time.setText(paper.getTime_paper());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class PaperViewHolder extends RecyclerView.ViewHolder{
        ImageView img_paper;
        TextView tv_title, tv_text, tv_time;
        public PaperViewHolder(@NonNull View itemView) {
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
