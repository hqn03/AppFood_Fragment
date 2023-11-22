package home_obj;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.foodapp.Detail;
import com.example.myapplication.R;

import java.util.List;

public class HotFoodAdapter extends RecyclerView.Adapter<HotFoodAdapter.ViewHolder> {

    private List<Food> foodList;
    private Context context;

    public HotFoodAdapter(Context context) {
        this.context = context;

    }

    public void setData(List<Food> list){
        this.foodList = list;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item_hot_product,parent,false);
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
        holder.ln_hotfood_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickGoToDetail();
            }
        });


    }
    private void onClickGoToDetail() {
//        Intent intent = new Intent(context, Detail.class);
//        context.startActivity(intent);
    }
    @Override
    public int getItemCount() {
        if(foodList !=null){
            return foodList.size();
        }
        return 0;
    }


    public class  ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgHinh;
        private LinearLayout ln_hotfood_home;
        private TextView tenSanPham, gia;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            imgHinh = itemView.findViewById(R.id.imageView_hot_product_item);
            tenSanPham = itemView.findViewById(R.id.tv_name);
            gia = itemView.findViewById(R.id.tv_price);
            ln_hotfood_home = itemView.findViewById(R.id.ln_hotfood_home);


        }
    }

}
