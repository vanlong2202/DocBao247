package com.example.a247;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a247.DAO.AccountManeger;
import com.example.a247.DAO.PaperDAO;
import com.example.a247.DAO.PaperSaveDAO;
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
        holder.tv_date.setText(paper.getDate_paper());
        AccountManeger accountManeger = new AccountManeger(context.getContext());
        boolean checkLogin = accountManeger.isLoggedIn();
        PaperSaveDAO paperSaveDAO = new PaperSaveDAO(context.getContext());

        if (checkLogin){
            int ProfileID = accountManeger.getProfileID();
            int PaperID = paper.getPaperID();
            boolean checkSave = paperSaveDAO.CheckPaperSave(PaperID,ProfileID);
            if (checkSave){
                holder.paperSave.setImageResource(R.drawable.bookmark_solid);
            }
        }
        holder.paperSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkLogin){
                    int ProfileID = accountManeger.getProfileID();
                    int PaperID = paper.getPaperID();
                    boolean checkSave = paperSaveDAO.CheckPaperSave(PaperID,ProfileID);
                    if (checkSave){
                        paperSaveDAO.DeletePaperSave(PaperID, ProfileID);
                        holder.paperSave.setImageResource(R.drawable.bookmark_regular);
                    }
                    else {
                        paperSaveDAO.SavePaper(PaperID, ProfileID);
                        holder.paperSave.setImageResource(R.drawable.bookmark_solid);
                    }
                }
                else {
                    Toast.makeText(context.getContext(), "Vui lòng đăng nhập.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class PaperViewHolder extends RecyclerView.ViewHolder{
        ImageView img_paper, paperSave;
        TextView tv_title, tv_text, tv_time, tv_date;
        public PaperViewHolder(@NonNull View itemView) {
            super(itemView);
            img_paper = itemView.findViewById(R.id.img_paper);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_text = itemView.findViewById(R.id.tv_text);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_date = itemView.findViewById(R.id.tv_date);
            paperSave = itemView.findViewById(R.id.paperSaver);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.OnItemClick(getAdapterPosition());
                }
            });
        }
    }

}
