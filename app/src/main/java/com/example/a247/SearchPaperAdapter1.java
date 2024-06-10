package com.example.a247;

import static android.app.PendingIntent.getActivity;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a247.fragment.SearchFragment;

import java.util.ArrayList;
import java.util.List;

public class SearchPaperAdapter1 extends RecyclerView.Adapter<SearchPaperAdapter1.PaperRssViewHolder>{
    private Context context;
    private SearchFragment context1;
    private List<PaperRss> mlist;
    private List<PaperRss> mlistOld;
    private ItemClickListener itemClickListener;

    public SearchPaperAdapter1(Context context, List<PaperRss> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    public SearchPaperAdapter1(SearchFragment context1, List<PaperRss> mlist) {
        this.context1 = context1;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public PaperRssViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_paper_style3,parent,false);
        return new PaperRssViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaperRssViewHolder holder, int position) {
        PaperRss item = mlist.get(position);
        holder.tv_title.setText(item.getTitle());
        holder.tv_text.setText(item.getDescription());
        holder.tv_time.setText(item.getTime());
        holder.tv_date.setText(item.getDate());
        Glide.with(holder.itemView.getContext()).load(item.getImg_link()).into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String link = item.getLink();
                Intent intent = new Intent(context1.getActivity(),DetailPaperRss.class);
                intent.putExtra("Link",link);
                context1.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }


    public class PaperRssViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title, tv_text, tv_time, tv_date;
        ImageView img;
        LinearLayout item;
        public PaperRssViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_titlepaper);
            tv_text = itemView.findViewById(R.id.tv_textpaper);
            tv_time = itemView.findViewById(R.id.tv_timepaper);
            tv_date = itemView.findViewById(R.id.tv_datepaper);
            img = itemView.findViewById(R.id.img_paper);
            item = itemView.findViewById(R.id.paper);
        }
    }
}
