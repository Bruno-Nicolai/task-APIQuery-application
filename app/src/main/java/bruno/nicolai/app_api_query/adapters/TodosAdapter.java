package bruno.nicolai.app_api_query.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import bruno.nicolai.app_api_query.R;
import bruno.nicolai.app_api_query.models.Todo;
import bruno.nicolai.app_api_query.models.User;

public class TodosAdapter extends RecyclerView.Adapter<TodosAdapter.ViewHolder> {

    private List<Todo> todosList;

    public TodosAdapter(List<Todo> todosList) {
        this.todosList = todosList;
    }

    @NonNull
    @Override
    public TodosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_todo, parent, false);

        return new TodosAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodosAdapter.ViewHolder holder, int position) {
        Todo todo = todosList.get(position);
        ((TextView) holder.view.findViewById(R.id.tv_title_todo)).setText(todo.getTitle());
    }

    @Override
    public int getItemCount() {
        return todosList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.view = itemView;
        }
    }
}