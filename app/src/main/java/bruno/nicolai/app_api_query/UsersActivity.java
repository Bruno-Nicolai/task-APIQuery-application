package bruno.nicolai.app_api_query;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import bruno.nicolai.app_api_query.adapters.UsersAdapter;
import bruno.nicolai.app_api_query.databinding.ActivityUsersBinding;
import bruno.nicolai.app_api_query.models.User;
import bruno.nicolai.app_api_query.repositories.UserRepository;
import bruno.nicolai.app_api_query.services.UserService;

public class UsersActivity extends AppCompatActivity /*implements Response.Listener<JSONArray>, Response.ErrorListener*/ {

    private ActivityUsersBinding binding;
    private List<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUsersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbarUsers.setTitle(R.string.user);
        binding.toolbarUsers.setNavigationOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        binding.usersBtnSearchAll.setOnClickListener(view -> {
            getAllUsers();
        });

    }

    private void getAllUsers() {

        UserService.getAllUsers(this, () -> {
//            System.out.println("API: " + UserRepository.getInstance().getUsers());
            UsersAdapter adapter = new UsersAdapter(new ArrayList(UserRepository.getInstance().getUsers()));
            binding.rvUsers.setAdapter(adapter);

            LinearLayoutManager llm = new LinearLayoutManager(this);
            binding.rvUsers.setLayoutManager(llm);

        });

    }
}