package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    private String mParam1;
    private String mParam2;
    private int img;

    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance(String param1, String param2, int image) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString("ten", param1);
        args.putString("gia", param2);
        args.putInt("hinhanh", image);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString("ten");
            mParam2 = getArguments().getString("gia");
            img = getArguments().getInt("hinhanh");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        TextView foodname = view.findViewById(R.id.detail_foodname);
        ImageView imgfood = view.findViewById(R.id.detail_imgfood);
        TextView price = view.findViewById(R.id.detail_price);

        foodname.setText(mParam1);
        price.setText(mParam2);
        imgfood.setImageResource(img);

        return view;
    }
}