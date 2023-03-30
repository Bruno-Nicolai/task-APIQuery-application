package bruno.nicolai.app_api_query.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import bruno.nicolai.app_api_query.R;
import bruno.nicolai.app_api_query.models.Comment;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> {

    private List<Comment> commentsList;

    public CommentsAdapter(List<Comment> commentsList) {
        this.commentsList = commentsList;
    }

    @NonNull
    @Override
    public CommentsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_comment, parent, false);

        return new CommentsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsAdapter.ViewHolder holder, int position) {
        Comment comment = commentsList.get(position);
        ((TextView) holder.view.findViewById(R.id.tv_name_comment)).setText(comment.getName());
        ((TextView) holder.view.findViewById(R.id.tv_email_comment)).setText(comment.getEmail());
        ((TextView) holder.view.findViewById(R.id.tv_body_comment)).setText(comment.getBody());
    }

    @Override
    public int getItemCount() {
        return commentsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.view = itemView;
        }
    }
}