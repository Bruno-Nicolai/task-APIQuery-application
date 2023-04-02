package bruno.nicolai.app_api_query.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import bruno.nicolai.app_api_query.R;
import bruno.nicolai.app_api_query.databinding.ActivityCommentsBinding;
import bruno.nicolai.app_api_query.presenters.CommentPresenter;
import bruno.nicolai.app_api_query.presenters.CommentPresenterInterface;

public class CommentsActivity extends AppCompatActivity implements CommentPresenterInterface.View {

    private ActivityCommentsBinding binding;

    private CommentPresenterInterface.Presenter presenter;

    LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCommentsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new CommentPresenter(this);

        binding.toolbarComments.setTitle(R.string.comments);
        binding.toolbarComments.setNavigationOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });


        binding.commentsBtnSearchAll.setOnClickListener(view -> {
            presenter.getAllComments();
        });

        llm = new LinearLayoutManager(this);
        binding.rvComments.setLayoutManager(llm);

    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void setCommentsAdapter(RecyclerView.Adapter adapter) {
        binding.rvComments.setAdapter(adapter);
    }
}