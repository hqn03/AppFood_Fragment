package home_obj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class CategoryAdapter  extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{
    private Context context;
    private List<Category> mListCategory;

    public CategoryAdapter(Context context) {
        this.context = context;

    }
    public void setData(List<Category> list){
        this.mListCategory = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item_category,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = mListCategory.get(position);
        if(category==null){
            return;
        }

        holder.tvNameCategory.setText(category.getNameCategory());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false);
        holder.rcvFoods.setLayoutManager(linearLayoutManager);

//        FoodAdapter adapter = new FoodAdapter(context);
//        adapter.setData(category.getFoods());
//        holder.rcvFoods.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        if(mListCategory !=null)
            return this.mListCategory.size();
        return 0;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNameCategory;
        private RecyclerView rcvFoods;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameCategory = itemView.findViewById(R.id.tv_name_category);
            rcvFoods = itemView.findViewById(R.id.rcv_food);

        }
    }
}
