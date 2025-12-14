package il.co.myfriends.IdoAndroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import il.co.myfriends.model.Categories;
import il.co.myfriends.model.Category;


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private Context context;
    private Categories Categories;
    private int single_layout;
    public interface OnItemClickListener {
        public void onItemClick(Category Category);
    }
    public interface OnItemLongClickListener {
        public boolean onItemLongClick(Category Category);
    }
    private OnItemClickListener listener;
    private OnItemLongClickListener longlistener;

    public CategoryAdapter(Context context, Categories Categories, int single_layout,
                         OnItemClickListener listener,
                         OnItemLongClickListener longlistener) {
        this.context = context;
        this.Categories = Categories;
        this.single_layout = single_layout;
        this.listener = listener;
        this.longlistener = longlistener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(single_layout, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category Category = Categories.get(position);
        if (Category != null) {
            holder.bind(Category,listener,longlistener);
        }
    }

    @Override
    public int getItemCount() {
        return (Categories != null) ? Categories.size() : 0;
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivCategory;
        private TextView tvCategoryName;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            ivCategory = itemView.findViewById(R.id.ivCategory);
            tvCategoryName = itemView.findViewById(R.id.tvName);
        }

        public void bind(Category Category,
                         OnItemClickListener listener,
                         OnItemLongClickListener longlistener) {
            tvCategoryName.setText(Category.getName());;;
            ivCategory.setImageResource(R.drawable.sunglassemoji);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(Category);
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return longlistener.onItemLongClick(Category);
                }
            });
        }
    }
}
