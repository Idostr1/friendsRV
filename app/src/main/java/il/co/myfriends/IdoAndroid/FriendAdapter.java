package il.co.myfriends.IdoAndroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import il.co.myfriends.model.Friend;
import il.co.myfriends.model.Friends;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.FriendViewHolder> {

    private Context context;
    private Friends friends;
    private int single_layout;

    public FriendAdapter(Context context, Friends friends, int single_layout) {
        this.context = context;
        this.friends = friends;
        this.single_layout = single_layout;
    }

    @NonNull
    @Override
    public FriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(single_layout, parent, false);
        return new FriendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendViewHolder holder, int position) {
        Friend friend = friends.get(position);
        if (friend != null) {
            holder.bind(friend);
        }
    }

    @Override
    public int getItemCount() {
        return (friends != null) ? friends.size() : 0;
    }

    public static class FriendViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivFriend;
        private TextView tvFirstName;
        private TextView tvLastName;

        public FriendViewHolder(@NonNull View itemView) {
            super(itemView);

            ivFriend = itemView.findViewById(R.id.ivFriend);
            tvFirstName = itemView.findViewById(R.id.tvFirstName);
            tvLastName = itemView.findViewById(R.id.tvLastName);
        }

        public void bind(Friend friend) {
            tvFirstName.setText(friend.getName());
            tvLastName.setText(friend.getFamily());
            ivFriend.setImageResource(R.drawable.sunglassemoji);
        }
    }
}
