package com.example.a247.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.a247.DAO.AccountManeger;
import com.example.a247.DAO.ProfileDAO;
import com.example.a247.DetailProfile;
import com.example.a247.LoginActivity;
import com.example.a247.MainActivity;
import com.example.a247.Model.Profile;
import com.example.a247.PaperOrtherActivity;
import com.example.a247.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuFragment extends Fragment {
    TextView tv_profile;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView tv_name, tv_email;
    private LinearLayout btn_Profile, btn_tinxemnhieu, btn_trangchu, btn_tinmoinhat, btn_tinnoibat;

    public MenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_email = view.findViewById(R.id.Account_email);
        tv_name = view.findViewById(R.id.Account_name);
        btn_Profile = view.findViewById(R.id.Profile);
        btn_tinxemnhieu =view.findViewById(R.id.tinxemnhieu);
        btn_trangchu =view.findViewById(R.id.trangchu);
        btn_tinmoinhat =view.findViewById(R.id.tinmoinhat);
        btn_tinnoibat =view.findViewById(R.id.tinnoibat);
        AccountManeger accountManeger = new AccountManeger(MenuFragment.this);

        if(accountManeger.isLoggedIn())
        {
            String email = accountManeger.getUsername();
            tv_email.setText(email);
            ProfileDAO dao1 = new ProfileDAO(MenuFragment.this);
            Profile profile = new Profile();
            profile = dao1.getProfileByID(email);
            tv_name.setText(profile.getFullname());
        }

        btn_Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checkIsLogIN = accountManeger.isLoggedIn();
                if (checkIsLogIN){
                    Intent intent = new Intent(getActivity(), DetailProfile.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
        btn_tinxemnhieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PaperOrtherActivity.class);
                String url = "https://vnexpress.net/rss/tin-xem-nhieu.rss";
                String name ="Tin Xem Nhiều";
                intent.putExtra("URL",url);
                intent.putExtra("NAME",name);
                v.getContext().startActivity(intent);
            }
        });
        btn_tinmoinhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PaperOrtherActivity.class);
                String url = "https://vnexpress.net/rss/tin-moi-nhat.rss";
                String name ="Tin mới nhất";
                intent.putExtra("URL",url);
                intent.putExtra("NAME",name);
                v.getContext().startActivity(intent);
            }
        });
        btn_tinnoibat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PaperOrtherActivity.class);
                String url = "https://vnexpress.net/rss/tin-noi-bat.rss";
                String name ="Tin nổi bật";
                intent.putExtra("URL",url);
                intent.putExtra("NAME",name);
                v.getContext().startActivity(intent);
            }
        });
        btn_trangchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }
}