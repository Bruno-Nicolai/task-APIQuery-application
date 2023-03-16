package bruno.nicolai.app_api_query;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import bruno.nicolai.app_api_query.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btn1.setOnClickListener(view -> {
            goToPostsScreen();
        });
        binding.btn2.setOnClickListener(view -> {
            goToCommentsScreen();
        });
        binding.btn3.setOnClickListener(view -> {
            goToUsersScreen();
        });
        binding.btn4.setOnClickListener(view -> {
            goToTodosScreen();
        });

    }

    private void goToPostsScreen() {
        Intent i = new Intent(getApplicationContext(), PostsActivity.class);
        startActivity(i);
    }

    private void goToCommentsScreen() {
        Intent i = new Intent(getApplicationContext(), CommentsActivity.class);
        startActivity(i);
    }

    private void goToUsersScreen() {
        Intent i = new Intent(getApplicationContext(), UsersActivity.class);
        startActivity(i);
    }

    private void goToTodosScreen() {
        Intent i = new Intent(getApplicationContext(), TodosActivity.class);
        startActivity(i);
    }

}