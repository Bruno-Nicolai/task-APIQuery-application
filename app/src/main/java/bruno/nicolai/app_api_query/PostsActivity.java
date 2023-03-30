package bruno.nicolai.app_api_query;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import bruno.nicolai.app_api_query.adapters.PostsAdapter;
import bruno.nicolai.app_api_query.adapters.TodosAdapter;
import bruno.nicolai.app_api_query.databinding.ActivityPostsBinding;
import bruno.nicolai.app_api_query.models.Post;
import bruno.nicolai.app_api_query.repositories.PostRepository;
import bruno.nicolai.app_api_query.repositories.TodoRepository;
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

        PostService.getAllPosts(this, () -> {
            PostsAdapter adapter = new PostsAdapter(new ArrayList(PostRepository.getInstance().getPosts()));
            binding.rvPosts.setAdapter(adapter);

            LinearLayoutManager llm = new LinearLayoutManager(this);
            binding.rvPosts.setLayoutManager(llm);

        });

    }
}