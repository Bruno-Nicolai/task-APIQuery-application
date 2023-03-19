package bruno.nicolai.app_api_query;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import bruno.nicolai.app_api_query.databinding.ActivityPostsBinding;
import bruno.nicolai.app_api_query.models.Post;
import bruno.nicolai.app_api_query.repositories.PostRepository;
import bruno.nicolai.app_api_query.services.PostService;

public class PostsActivity extends AppCompatActivity {

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

        PostService.getAllPosts(this, () -> System.out.println("API: " + PostRepository.getInstance().getPosts()));

//        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
//                "https://jsonplaceholder.typicode.com/posts", null,
//                this, this);
//        RequestQueue queue = Volley.newRequestQueue(this);
//        queue.add(request);
    }

//    @Override
//    public void onResponse(JSONArray response) {
//        for (int i = 0; i < response.length(); i++) {
//            Post post = null;
//            try {
//
//                JSONObject json = response.getJSONObject(i);
//
//                post = new Post(
//                        json.getInt("userId"),
//                        json.getInt("id"),
//                        json.getString("title"),
//                        json.getString("body"));
//                posts.add(post);
//
//            } catch (JSONException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//        System.out.println(posts);
//    }
}