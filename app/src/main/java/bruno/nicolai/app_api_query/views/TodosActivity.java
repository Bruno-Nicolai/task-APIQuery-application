package bruno.nicolai.app_api_query.views;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import bruno.nicolai.app_api_query.R;
import bruno.nicolai.app_api_query.adapters.TodosAdapter;
import bruno.nicolai.app_api_query.databinding.ActivityTodosBinding;
import bruno.nicolai.app_api_query.models.Todo;
import bruno.nicolai.app_api_query.repositories.TodoRepository;
import bruno.nicolai.app_api_query.services.TodoService;

public class TodosActivity extends AppCompatActivity {

    private ActivityTodosBinding binding;
    private List<Todo> todos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTodosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbarTodos.setTitle(R.string.todos);
        binding.toolbarTodos.setNavigationOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        binding.todosBtnSearchAll.setOnClickListener(view -> {
            getAllTodos();
        });

    }

    private void getAllTodos() {

        TodoService.getAllTodos(this, () -> {
            TodosAdapter adapter = new TodosAdapter(new ArrayList(TodoRepository.getInstance().getTodos()));
            binding.rvTodos.setAdapter(adapter);

            LinearLayoutManager llm = new LinearLayoutManager(this);
            binding.rvTodos.setLayoutManager(llm);

        });

    }
}