package bruno.nicolai.app_api_query.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import bruno.nicolai.app_api_query.R;
import bruno.nicolai.app_api_query.databinding.ActivityPostsBinding;
import bruno.nicolai.app_api_query.presenters.PostPresenter;
import bruno.nicolai.app_api_query.presenters.PostPresenterInterface;

public class PostsActivity extends AppCompatActivity implements PostPresenterInterface.View {

    private ActivityPostsBinding binding;
    private PostPresenterInterface.Presenter presenter;

    LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPostsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new PostPresenter(this);

        binding.toolbarPosts.setTitle(R.string.posts);
        binding.toolbarPosts.setNavigationOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        binding.postsBtnSearchAll.setOnClickListener(view -> {
            presenter.getAllPosts();
        });

        llm = new LinearLayoutManager(this);
        binding.rvPosts.setLayoutManager(llm);

    }


    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void setPostsAdapter(RecyclerView.Adapter adapter) {
        binding.rvPosts.setAdapter(adapter);
    }
}