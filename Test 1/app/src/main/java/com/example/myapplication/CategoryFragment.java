package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import category_obj.CustomAdapter;
import category_obj.Food;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoryFragment extends Fragment implements CustomAdapter.ItemClickListener{
    private ArrayList<Food> arrayList = new ArrayList<>();

    public CategoryFragment() {
        // Required empty public constructor
    }

    public static CategoryFragment newInstance(String param1, String param2) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        buildListData();
        initRecycleView(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    private void replaceFrament(Fragment fragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }

    private void initRecycleView(View view){
        RecyclerView recyclerView = view.findViewById(R.id.cate_rcv_listfood);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);
        CustomAdapter adapter = new CustomAdapter(arrayList,this);
        recyclerView.setAdapter(adapter);
    }

    private void buildListData(){
        Food food1 = new Food("Bánh mì chả cô Ba",4.9,120,15000,R.drawable.food_banhmi);
        Food food2 = new Food("Cơm gà quay Quốc Tiến",4.9,120,15000,R.drawable.food_chicken_rice);
        Food food3 = new Food("Phở Minh Tiến",4.9,120,15000,R.drawable.food_phobo);
        Food food4 = new Food("Bánh cuốn chú Hoàng",4.9,120,15000,R.drawable.food_banh_cuon);
        Food food5 = new Food("Bánh ép Hoàng Khánh",4.9,120,15000,R.drawable.food_coconut_cake);

        arrayList.add(food1);
        arrayList.add(food2);
        arrayList.add(food3);
        arrayList.add(food4);
        arrayList.add(food5);
        arrayList.add(food1);
        arrayList.add(food2);
        arrayList.add(food3);
        arrayList.add(food4);
        arrayList.add(food5);
        arrayList.add(food1);
        arrayList.add(food2);
        arrayList.add(food3);
        arrayList.add(food4);
        arrayList.add(food5);
    }

    @Override
    public void onItemClick(Food food) {
        Fragment fragment = DetailFragment.newInstance(food.getName(),food.getPrice()+"", food.getImage());

        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout,fragment,"cate_fragment");
        transaction.addToBackStack(null);
        transaction.commit();
    }
}