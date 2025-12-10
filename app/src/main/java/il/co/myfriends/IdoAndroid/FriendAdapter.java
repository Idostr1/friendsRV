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
    public interface OnItemClickListener {
        public void onItemClick(Friend friend);
    }
    public interface OnItemLongClickListener {
        public boolean onItemLongClick(Friend friend);
    }
    private OnItemClickListener listener;
    private OnItemLongClickListener longlistener;

    public FriendAdapter(Context context, Friends friends, int single_layout,
                         OnItemClickListener listener,
                         OnItemLongClickListener longlistener) {
        this.context = context;
        this.friends = friends;
        this.single_layout = single_layout;
        this.listener = listener;
        this.longlistener = longlistener;
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
            holder.bind(friend,listener,longlistener);
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

        public void bind(Friend friend,
                         OnItemClickListener listener,
                         OnItemLongClickListener longlistener) {
            tvFirstName.setText(friend.getName());
            tvLastName.setText(friend.getFamily());
            ivFriend.setImageResource(R.drawable.sunglassemoji);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(friend);
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    return longlistener.onItemLongClick(friend);
                }
            });
        }
    }
}
