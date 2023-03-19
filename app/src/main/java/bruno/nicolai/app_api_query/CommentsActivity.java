package bruno.nicolai.app_api_query;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import bruno.nicolai.app_api_query.databinding.ActivityCommentsBinding;
import bruno.nicolai.app_api_query.models.Comment;
import bruno.nicolai.app_api_query.repositories.CommentRepository;
import bruno.nicolai.app_api_query.services.CommentService;

public class CommentsActivity extends AppCompatActivity {

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

        CommentService.getAllComments(this, () -> System.out.println("API: " + CommentRepository.getInstance().getComments()));

    }

}