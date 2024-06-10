package com.example.a247;

import static android.content.Intent.getIntent;
import static android.content.Intent.getIntentOld;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a247.DAO.CategoryFLDAO;
import com.example.a247.Model.CategoryFL;

import java.util.List;

public class CategoryFollowAdapter extends RecyclerView.Adapter<CategoryFollowAdapter.CategoryFollowViewHolder>{
    private Context context;
    private List<CategoryFL> mlist;

    public CategoryFollowAdapter(Context context, List<CategoryFL> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public CategoryFollowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category_follow,parent,false);
        return new CategoryFollowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryFollowViewHolder holder, int position) {
        CategoryFL item = mlist.get(position);
        holder.tv_categoryName.setText(item.getCategoryName());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoryFLDAO categoryFLDAO = new CategoryFLDAO(v.getContext());
                categoryFLDAO.DeteleCategoryFL(item);
                Intent intent = new Intent(context,CategoryFollow.class);
                context.startActivity(intent);
            }
        });
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = item.getLink();
                int Category = item.getCategoryID();
                Intent intent = new Intent(context,CategoryPaperRss.class);
                intent.putExtra("CategoryID",Category);
                intent.putExtra("URL",url);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class CategoryFollowViewHolder extends RecyclerView.ViewHolder{
        TextView tv_categoryName;
        CardView delete, view;
        public CategoryFollowViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_categoryName = itemView.findViewById(R.id.CategoryName);
            delete =itemView.findViewById(R.id.btn_delete);
            view = itemView.findViewById(R.id.ViewDetail);
        }
    }
}
