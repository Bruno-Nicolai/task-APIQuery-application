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

import bruno.nicolai.app_api_query.databinding.ActivityCommentsBinding;
import bruno.nicolai.app_api_query.models.Comment;

public class CommentsActivity extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener {

    private ActivityCommentsBinding binding;
    private List<Comment> comments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCommentsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbarComments.setTitle(R.string.comments);
        binding.toolbarComments.setNavigationOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        binding.commentsBtnSearchAll.setOnClickListener(view -> {
            getAllComments();
        });

    }

    private void getAllComments() {
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/comments", null,
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
            Comment comment = null;
            try {

                JSONObject json = response.getJSONObject(i);

                comment = new Comment(
                        json.getInt("id"),
                        json.getInt("postId"),
                        json.getString("name"),
                        json.getString("email"),
                        json.getString("body"));
                comments.add(comment);

            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(comments);
    }
}