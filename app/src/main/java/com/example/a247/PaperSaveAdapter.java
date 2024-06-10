package com.example.a247;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a247.DAO.AccountManeger;
import com.example.a247.DAO.PaperSaveDAO;
import com.example.a247.Model.PaperRSS;
import com.example.a247.Model.PaperSave;

import java.util.List;

public class PaperSaveAdapter extends RecyclerView.Adapter<PaperSaveAdapter.PaperSaveViewHolder>{
    private Context context;
    private List<PaperSave> mlist;

    public PaperSaveAdapter(Context context, List<PaperSave> mlist) {
        this.context = context;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public PaperSaveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_paper_save,parent,false);
        return new PaperSaveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaperSaveViewHolder holder, int position) {
        PaperSave paperSave = mlist.get(position);
        holder.tv_title.setText(paperSave.getTitle());
        holder.tv_time.setText(paperSave.getTime());
        holder.tv_date.setText(paperSave.getDate());
        holder.btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PaperSaveDAO paperSaveDAO = new PaperSaveDAO(v.getContext());
                AccountManeger accountManeger = new AccountManeger(v.getContext());
                int ProfileID = accountManeger.getProfileID();
                int PaperID = paperSave.getPaperID();
                paperSaveDAO.DeletePaperSave(PaperID,ProfileID);
                Intent intent = new Intent(context,PaperSaveActivity.class);
                context.startActivity(intent);
            }
        });
        holder.item_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),DetailReadPaper.class);
                int paperID = paperSave.getPaperID();
                intent.putExtra("PaperID",paperID);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class PaperSaveViewHolder extends RecyclerView.ViewHolder{
        TextView tv_title, tv_time, tv_date;
        ImageView btn_save;
        CardView item_paper;
        public PaperSaveViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_date = itemView.findViewById(R.id.tv_date);
            btn_save =  itemView.findViewById(R.id.btn_save);
            item_paper = itemView.findViewById(R.id.item_paper);
        }
    }
}
