package home_obj;

import android.app.Activity;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.foodapp.Detail;
import com.example.myapplication.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    private List<Food> foodList;
    private ItemClickListener clickListener;

    public void setData(List<Food> list){
        this.foodList = list;
        this.clickListener = clickListener;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item_product,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Food food = foodList.get(position);
        if(food == null)
            return;
        holder.imgHinh.setImageResource(food.getHinhAnh());
        holder.tenSanPham.setText(food.getTenMonAn());
        holder.gia.setText((food.getGia())+"");
        holder.danhGia.setText(food.getDanhGia()+"");
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(foodList.get(position));
            }
        });
    }
    public interface ItemClickListener{
        public void onItemClick(Food food);

    }
    @Override
    public int getItemCount() {
        if(foodList !=null){
            return foodList.size();
        }
        return 0;
    }


    public class  ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView imgHinh;
        private LinearLayout linearLayout;
        private TextView tenSanPham, gia, danhGia;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            imgHinh = itemView.findViewById(R.id.imageView_product_item);
            tenSanPham = itemView.findViewById(R.id.tv_name);
            gia = itemView.findViewById(R.id.tv_price);
            danhGia = itemView.findViewById(R.id.tv_estimate);
            linearLayout = itemView.findViewById(R.id.home_ln_produce);


        }
    }

}
