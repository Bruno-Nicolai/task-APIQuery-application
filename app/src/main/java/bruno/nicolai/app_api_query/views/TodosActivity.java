package bruno.nicolai.app_api_query.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import bruno.nicolai.app_api_query.R;
import bruno.nicolai.app_api_query.databinding.ActivityTodosBinding;
import bruno.nicolai.app_api_query.presenters.TodoPresenter;
import bruno.nicolai.app_api_query.presenters.TodoPresenterInterface;

public class TodosActivity extends AppCompatActivity implements TodoPresenterInterface.View {

    private ActivityTodosBinding binding;
    private TodoPresenterInterface.Presenter presenter;

    LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTodosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new TodoPresenter(this);

        binding.toolbarTodos.setTitle(R.string.todos);
        binding.toolbarTodos.setNavigationOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        binding.todosBtnSearchAll.setOnClickListener(view -> {
            presenter.getAllTodos();
        });

        llm = new LinearLayoutManager(this);
        binding.rvTodos.setLayoutManager(llm);

    }


    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void setTodosAdapter(RecyclerView.Adapter adapter) {
        binding.rvTodos.setAdapter(adapter);
    }
}