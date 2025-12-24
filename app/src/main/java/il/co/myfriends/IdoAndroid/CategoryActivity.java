    package il.co.myfriends.IdoAndroid;

    import android.os.Bundle;
    import android.widget.EditText;
    import android.widget.Toast;

    import androidx.activity.EdgeToEdge;
    import androidx.appcompat.app.AlertDialog;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.core.graphics.Insets;
    import androidx.core.view.ViewCompat;
    import androidx.core.view.WindowInsetsCompat;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import com.google.android.material.floatingactionbutton.FloatingActionButton;

    import il.co.myfriends.model.Category;
    import il.co.myfriends.model.Categories;

    public class CategoryActivity extends AppCompatActivity {
        private RecyclerView rvCategories;
        private Categories Categories;
        private CategoryAdapter adapter;
        private FloatingActionButton fabAddCategory;


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
            setListeners();
        }

        private void initializeData() {
            Categories = new Categories();
            Categories.getAllCategories();
        }

        private void initializeViews() {
            rvCategories = findViewById(R.id.rvCategories);
            fabAddCategory = findViewById(R.id.fabAddCategory);
        }

        private void setRecyclerView() {
            CategoryAdapter.OnItemClickListener listener = new CategoryAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(Category Category) {
                    final EditText input = new EditText(CategoryActivity.this);
                    input.setText(Category.getName());

                    new AlertDialog.Builder(CategoryActivity.this)
                            .setTitle("Edit category")
                            .setView(input)
                            .setPositiveButton("Save", (dialog, which) -> {
                                Category.setName(input.getText().toString());
                                adapter.notifyItemChanged(Categories.indexOf(Category));
                            })
                            .setNegativeButton("Cancel", null)
                            .show();
                }
            };
            CategoryAdapter.OnItemLongClickListener longlistener = new CategoryAdapter.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(Category Category) {
                    adapter.notifyItemRemoved(Categories.indexOf(Category));
                    Categories.remove(Category);
                    return true;
                }
            };

            adapter = new CategoryAdapter(this, Categories, R.layout.category_single_layout,listener, longlistener);
            rvCategories.setAdapter(adapter);
            rvCategories.setLayoutManager(new LinearLayoutManager(this));
        }
        private void setListeners() {
            fabAddCategory.setOnClickListener(v -> {
                final EditText input = new EditText(this);
                input.setHint("Category name");

                new AlertDialog.Builder(this)
                        .setTitle("Add New Category")
                        .setView(input)
                        .setPositiveButton("Add", (dialog, which) -> {
                            String categoryName = input.getText().toString().trim();

                            if (!categoryName.isEmpty()) {
                                Category newCategory = new Category(categoryName);
                                Categories.add(newCategory);

                                adapter.notifyItemInserted(Categories.size() - 1);
                                rvCategories.scrollToPosition(Categories.size() - 1);
                            } else {
                                Toast.makeText(CategoryActivity.this, "Please enter a name", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .show();
            });
        }
    }
