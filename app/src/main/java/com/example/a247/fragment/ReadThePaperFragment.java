package com.example.a247.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a247.ListPaper;
import com.example.a247.R;
import com.example.a247.ReadThePaperAdapter;
import com.example.a247.adapter.ListPaperAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReadThePaperFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReadThePaperFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView rcv_paperupdate, rcv_listpaper1, rcv_listpaper2, rcv_listpaper3, rcv_listpaper4;
    private ArrayList<ListPaper> mlist;
    private ReadThePaperAdapter adapter;

    public ReadThePaperFragment() {
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
    public static ReadThePaperFragment newInstance(String param1, String param2) {
        ReadThePaperFragment fragment = new ReadThePaperFragment();
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
        return inflater.inflate(R.layout.fragment_readthepaper, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcv_paperupdate = view.findViewById(R.id.rcv_paperupdate);
        rcv_listpaper1 = view.findViewById(R.id.rcv_paperlist1);
        rcv_listpaper2 = view.findViewById(R.id.rcv_paperlist2);
        rcv_listpaper3 = view.findViewById(R.id.rcv_paperlist3);
        rcv_listpaper4 = view.findViewById(R.id.rcv_paperlist4);

        initDATA();

        rcv_paperupdate.setLayoutManager(new LinearLayoutManager(getContext()));
        rcv_paperupdate.setHasFixedSize(true);

        rcv_listpaper1.setLayoutManager(new LinearLayoutManager(getContext()));
        rcv_listpaper1.setHasFixedSize(true);

        rcv_listpaper2.setLayoutManager(new LinearLayoutManager(getContext()));
        rcv_listpaper2.setHasFixedSize(true);

        rcv_listpaper3.setLayoutManager(new LinearLayoutManager(getContext()));
        rcv_listpaper3.setHasFixedSize(true);

        rcv_listpaper4.setLayoutManager(new LinearLayoutManager(getContext()));
        rcv_listpaper4.setHasFixedSize(true);

        adapter = new ReadThePaperAdapter(getContext(),mlist);
        rcv_paperupdate.setAdapter(adapter);
        rcv_listpaper1.setAdapter(adapter);
        rcv_listpaper2.setAdapter(adapter);
        rcv_listpaper3.setAdapter(adapter);
        rcv_listpaper4.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void initDATA() {
        mlist = new ArrayList<>();
        mlist.add(new ListPaper(R.drawable.img,"Đổ xô đi mua vàng khi giá lập đỉnh","Lượt khách mua bán vàng miếng, nhẫn trơn tại một số thương hiệu lớn nhộn nhịp trong ngày giá liên tiếp phá đỉnh.","19:20","Thể Thao"));
        mlist.add(new ListPaper(R.drawable.z5425521795153_2fc7a6d78b7df8426eef80b3b51cbb62,"Gần 9.000 căn hộ tái định cư bỏ trống, nợ phí quản lý","Lượt khách mua bán vàng miếng, nhẫn trơn tại một số thương hiệu lớn nhộn nhịp trong ngày giá liên tiếp phá đỉnh.","19:20","Chính Trị"));
        mlist.add(new ListPaper(R.drawable.z5425521804111_f1420e8cb9c71cef2b6ed52b53374874,"Việt Nam hoan nghênh Mỹ sớm công nhận quy chế kinh tế thị trường","Lượt khách mua bán vàng miếng, nhẫn trơn tại một số thương hiệu lớn nhộn nhịp trong ngày giá liên tiếp phá đỉnh.","19:20",""));
        mlist.add(new ListPaper(R.drawable.z5425521811267_dbbaac8b60b9d44d91d695beae1a879d,"Chứng khoán đứt mạch tăng","Lượt khách mua bán vàng miếng, nhẫn trơn tại một số thương hiệu lớn nhộn nhịp trong ngày giá liên tiếp phá đỉnh.","19:20",""));
        mlist.add(new ListPaper(R.drawable.z5425521811268_a79e59be0ff401231cbddcaacbf9b5de,"Đổ xô đi mua vàng khi giá lập đỉnh","Lượt khách mua bán vàng miếng, nhẫn trơn tại một số thương hiệu lớn nhộn nhịp trong ngày giá liên tiếp phá đỉnh.","19:20",""));
        mlist.add(new ListPaper(R.drawable.z5425521811267_dbbaac8b60b9d44d91d695beae1a879d,"Đổ xô đi mua vàng khi giá lập đỉnh","Lượt khách mua bán vàng miếng, nhẫn trơn tại một số thương hiệu lớn nhộn nhịp trong ngày giá liên tiếp phá đỉnh.","19:20",""));
        mlist.add(new ListPaper(R.drawable.img,"Đổ xô đi mua vàng khi giá lập đỉnh","Lượt khách mua bán vàng miếng, nhẫn trơn tại một số thương hiệu lớn nhộn nhịp trong ngày giá liên tiếp phá đỉnh.","19:20",""));
    }
}