package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import home_obj.Category;
import home_obj.CategoryAdapter;
import home_obj.Food;
import home_obj.FoodAdapter;
import home_obj.HotFoodAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View mView;
    private RecyclerView rcvCategory, rcvHotProduct;
    private CategoryAdapter categoryAdapter;
    private Button tvAll,tvGiaRe,tvPhoBien,tvMoiNhat;

    private CircleImageView civ_user;
    private HotFoodAdapter foodAdapter;
    private FoodAdapter.ItemClickListener clickListener;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
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
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        mView = inflater.inflate(R.layout.fragment_home, container, false);

        //Đoạn này code của vũ
        rcvCategory = mView.findViewById(R.id.rcv_category);
        rcvHotProduct = mView.findViewById(R.id.rcv_hot_product);
        civ_user = mView.findViewById(R.id.civ_user);
        tvAll = mView.findViewById(R.id.btn_all_home);
        tvGiaRe = mView.findViewById(R.id.btn_giare);
        tvPhoBien = mView.findViewById(R.id.btn_phobien);
        tvMoiNhat = mView.findViewById(R.id.btn_moinhat);
        LinearLayoutManager linearLayoutManager_Category = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        tvAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayoutManager_Category.scrollToPositionWithOffset(0,0);
            }
        });
        tvMoiNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayoutManager_Category.scrollToPositionWithOffset(2,0);
            }
        });
        tvGiaRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayoutManager_Category.scrollToPositionWithOffset(0,0);
            }
        });
        tvPhoBien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayoutManager_Category.scrollToPositionWithOffset(1,0);
            }
        });

        categoryAdapter = new CategoryAdapter(getContext());
        foodAdapter = new HotFoodAdapter (getContext());

        rcvCategory.setLayoutManager(linearLayoutManager_Category);

        tvAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rcvCategory.setLayoutManager(linearLayoutManager_Category);
            }
        });

        LinearLayoutManager linearLayoutManager_HotFood = new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        rcvHotProduct.setLayoutManager(linearLayoutManager_HotFood);
        foodAdapter.setData(getListHotProduct());
        rcvHotProduct.setAdapter(foodAdapter);

        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);

        //cái này chưa có giao diện
        civ_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(Home_screen.this, Profile.class);
                //startActivity(intent);
            }
        });
        return mView;
    }
    private List<Food> getListHotProduct() {

        List<Food> listFood = new ArrayList<>();
        listFood.add(new Food("Bánh mỳ cô Ba",20000,R.drawable.food_banhmi, 5 ));
        listFood.add(new Food("Cơm gà quay Quốc Tiến",20000,R.drawable.food_chicken_rice, 5 ));
        listFood.add(new Food("Phở Minh Tiến",20000,R.drawable.food_phobo, 5 ));
        listFood.add(new Food("Bánh cuốn chú Hoàng",20000,R.drawable.food_banh_cuon, 5 ));
        listFood.add(new Food("Bánh ép Hoàng Khánh",20000,R.drawable.food_coconut_cake, 5 ));

        return listFood;
    }
    private List<Category> getListCategory() {
        List<Category> listCategory = new ArrayList<>();

        List<Food> listFood = new ArrayList<>();
        listFood.add(new Food("Bánh mỳ cô Ba",20000,R.drawable.food_banhmi, 5 ));
        listFood.add(new Food("Cơm gà quay Quốc Tiến",20000,R.drawable.food_chicken_rice, 5 ));
        listFood.add(new Food("Phở Minh Tiến",20000,R.drawable.food_phobo, 5 ));
        listFood.add(new Food("Bánh cuốn chú Hoàng",20000,R.drawable.food_banh_cuon, 5 ));
        listFood.add(new Food("Bánh ép Hoàng Khánh",20000,R.drawable.food_coconut_cake, 5 ));
        listCategory.add(new Category("Giá rẻ",listFood));
        listCategory.add(new Category("Phổ biến nhất",listFood));
        listCategory.add(new Category("Mới nhất",listFood));
        return listCategory;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    private void replaceFrament(Fragment fragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}