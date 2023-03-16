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

import bruno.nicolai.app_api_query.databinding.ActivityPostsBinding;
import bruno.nicolai.app_api_query.models.Post;
import bruno.nicolai.app_api_query.models.Todo;

public class PostsActivity extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener {

    private ActivityPostsBinding binding;
    private List<Post> posts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPostsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbarPosts.setTitle(R.string.posts);
        binding.toolbarPosts.setNavigationOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        binding.postsBtnSearchAll.setOnClickListener(view -> {
            getAllPosts();
        });

    }


    private void getAllPosts() {
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/posts", null,
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
            Post post = null;
            try {

                JSONObject json = response.getJSONObject(i);

                post = new Post(
                        json.getInt("userId"),
                        json.getInt("id"),
                        json.getString("title"),
                        json.getString("body"));
                posts.add(post);

            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(posts);
    }
}