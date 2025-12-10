package il.co.myfriends.IdoAndroid;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Date;

import il.co.myfriends.model.Friend;
import il.co.myfriends.model.Friends;

public class SecondActivity extends AppCompatActivity {
    private RecyclerView rvFriends;
    private Friends friends;
    private FriendAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_second), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializeViews();
        initializeData();
        setRecyclerView();
    }

    private void initializeData() {
        friends = new Friends();
        friends.getAllFriends();
    }

    private void initializeViews() {
        rvFriends = findViewById(R.id.rvFriends);
    }

    private void setRecyclerView() {
        adapter = new FriendAdapter(this, friends, R.layout.friend_single_layout);
        rvFriends.setAdapter(adapter);
        rvFriends.setLayoutManager(new LinearLayoutManager(this));
    }
}
