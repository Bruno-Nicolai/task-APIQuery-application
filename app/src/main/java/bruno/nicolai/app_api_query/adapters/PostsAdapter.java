package bruno.nicolai.app_api_query.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import bruno.nicolai.app_api_query.R;
import bruno.nicolai.app_api_query.models.Post;
import bruno.nicolai.app_api_query.models.Todo;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private List<Post> postsList;

    public PostsAdapter(List<Post> postsList) {
        this.postsList = postsList;
    }

    @NonNull
    @Override
    public PostsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_post, parent, false);

        return new PostsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsAdapter.ViewHolder holder, int position) {
        Post post = postsList.get(position);
        ((TextView) holder.view.findViewById(R.id.tv_title_post)).setText(post.getTitle());
        ((TextView) holder.view.findViewById(R.id.tv_body_post)).setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.view = itemView;
        }
    }
}