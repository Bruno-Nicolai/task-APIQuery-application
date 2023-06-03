package bruno.nicolai.app_api_query.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import bruno.nicolai.app_api_query.R;
import bruno.nicolai.app_api_query.adapters.UsersAdapter;
import bruno.nicolai.app_api_query.databinding.ActivityUsersBinding;
import bruno.nicolai.app_api_query.models.User;
import bruno.nicolai.app_api_query.presenters.UserPresenter;
import bruno.nicolai.app_api_query.presenters.UserPresenterInterface;

public class UsersActivity extends AppCompatActivity implements UserPresenterInterface.View {

    private ActivityUsersBinding binding;

    private UserPresenterInterface.Presenter presenter;

    private SwipeRefreshLayout swipe;

    private UsersAdapter myAdapter;

    LinearLayoutManager llm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUsersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        presenter = new UserPresenter(this);

        presenter.getAllUsers();
        setSupportActionBar(binding.toolbarUsers);
        binding.toolbarUsers.setTitle(R.string.user);
        binding.toolbarUsers.setNavigationOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });


        llm = new LinearLayoutManager(this);
        binding.rvUsers.setLayoutManager(llm);


        swipe = findViewById(R.id.swipeToRefresh);
        swipe.setOnRefreshListener(() -> {
            Toast.makeText(UsersActivity.this, "The list was sorted", Toast.LENGTH_SHORT).show();
            swipe.setRefreshing(false);
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.users_dropdown_menu, menu);
        Log.e("user", "onCreateOptions");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.e("user", "onOptionsSelected");
        switch (item.getItemId()) {
            case R.id.action_sort_default:
                return true;
            case R.id.action_sort_ascending:
                myAdapter.sortByAscendingName();
                return true;
            case R.id.action_sort_descending:
                myAdapter.sortByDescendingName();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void setUsersAdapter(RecyclerView.Adapter adapter) {
        myAdapter = (UsersAdapter)adapter;
        if (binding.rvUsers.getAdapter() == null){
            binding.rvUsers.setAdapter(myAdapter);
        } else {
            binding.rvUsers.swapAdapter(adapter, true);
        }

    }
}