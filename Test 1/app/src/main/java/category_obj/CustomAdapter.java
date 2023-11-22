package category_obj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class CustomAdapter extends  RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    ArrayList<Food> arrFood;
    private ItemClickListener clickListener;

    public CustomAdapter(ArrayList<Food> arrFood,ItemClickListener clickListener) {
        this.arrFood = arrFood;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Food food = arrFood.get(position);
        holder.name.setText(food.getName()+"");
        holder.rate.setText(food.getRate()+"");
        holder.rate_count.setText("("+food.getCount_rate()+" lượt đánh giá)");
        holder.price.setText(food.getPrice()+"đ");
        holder.img.setImageResource(food.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(arrFood.get(position));
            }
        });
    }
    public interface ItemClickListener{
        public void onItemClick(Food food);
    }
    @Override
    public int getItemCount()
    {
        if(arrFood!=null)
        {
            return arrFood.size();
        }
        return 0;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;

        private TextView name,rate,rate_count,price;
        private LinearLayout linearLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.cate_img_item);
            name = itemView.findViewById(R.id.cate_tv_name);
            rate = itemView.findViewById(R.id.cate_tv_rate);
            rate_count = itemView.findViewById(R.id.cate_tv_rate_count);
            price = itemView.findViewById(R.id.cate_tv_price);
            linearLayout = itemView.findViewById(R.id.ln_category);
        }
    }

}
