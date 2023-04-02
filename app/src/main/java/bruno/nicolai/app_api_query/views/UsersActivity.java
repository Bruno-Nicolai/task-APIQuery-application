package bruno.nicolai.app_api_query.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import bruno.nicolai.app_api_query.R;
import bruno.nicolai.app_api_query.databinding.ActivityUsersBinding;
import bruno.nicolai.app_api_query.presenters.UserPresenterInterface;
import bruno.nicolai.app_api_query.presenters.UserPresenter;

public class UsersActivity extends AppCompatActivity implements UserPresenterInterface.View {

    private ActivityUsersBinding binding;

    private UserPresenterInterface.Presenter presenter;

    LinearLayoutManager llm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUsersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new UserPresenter(this);

        binding.toolbarUsers.setTitle(R.string.user);
        binding.toolbarUsers.setNavigationOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        binding.usersBtnSearchAll.setOnClickListener(view -> {
            presenter.getAllUsers();
        });

        llm = new LinearLayoutManager(this);
        binding.rvUsers.setLayoutManager(llm);

    }


    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void setUsersAdapter(RecyclerView.Adapter adapter) {
            binding.rvUsers.setAdapter(adapter);
    }
}