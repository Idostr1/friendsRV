    package il.co.myfriends.IdoAndroid;

    import android.os.Bundle;
    import android.widget.Toast;

    import androidx.activity.EdgeToEdge;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.core.graphics.Insets;
    import androidx.core.view.ViewCompat;
    import androidx.core.view.WindowInsetsCompat;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import il.co.myfriends.model.Category;
    import il.co.myfriends.model.Categories;

    public class CategoryActivity extends AppCompatActivity {
        private RecyclerView rvCategories;
        private Categories Categories;
        private CategoryAdapter adapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_category);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_category), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });

            initializeViews();
            initializeData();
            setRecyclerView();
        }

        private void initializeData() {
            Categories = new Categories();
            Categories.getAllCategories();
        }

        private void initializeViews() {
            rvCategories = findViewById(R.id.rvCategories);
        }

        private void setRecyclerView() {
            CategoryAdapter.OnItemClickListener listener = new CategoryAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(Category Category) {
                    Toast.makeText(CategoryActivity.this, Category.getName(), Toast.LENGTH_SHORT).show();
                }
            };
            CategoryAdapter.OnItemLongClickListener longlistener = new CategoryAdapter.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(Category Category) {
                    Toast.makeText(CategoryActivity.this, Category.getName(), Toast.LENGTH_SHORT).show();
                    return true;
                }
            };

            adapter = new CategoryAdapter(this, Categories, R.layout.category_single_layout,listener, longlistener);
            rvCategories.setAdapter(adapter);
            rvCategories.setLayoutManager(new LinearLayoutManager(this));
        }
    }
