package bruno.nicolai.app_api_query;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import bruno.nicolai.app_api_query.databinding.ActivityTodosBinding;
import bruno.nicolai.app_api_query.models.Todo;

public class TodosActivity extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener {

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
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/todos", null,
                this, this);
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, "Ocorreu uma falha na requisição " + error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONArray response) {
        for (int i = 0; i < response.length(); i++) {
            Todo todo = null;
            try {

                JSONObject json = response.getJSONObject(i);

                todo = new Todo(
                        json.getInt("userId"),
                        json.getInt("id"),
                        json.getString("title"),
                        json.getBoolean("completed"));
                todos.add(todo);

            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(todos);
    }
}