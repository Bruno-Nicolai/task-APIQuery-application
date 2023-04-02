package bruno.nicolai.app_api_query.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import bruno.nicolai.app_api_query.R;
import bruno.nicolai.app_api_query.databinding.ActivityAlbumsBinding;
import bruno.nicolai.app_api_query.models.Album;
import bruno.nicolai.app_api_query.presenters.AlbumPresenter;
import bruno.nicolai.app_api_query.presenters.AlbumPresenterInterface;
import bruno.nicolai.app_api_query.presenters.PhotoPresenterInterface;
import bruno.nicolai.app_api_query.repositories.AlbumRepository;
import bruno.nicolai.app_api_query.services.AlbumService;

public class AlbumsActivity extends AppCompatActivity implements AlbumPresenterInterface.View {

    private ActivityAlbumsBinding binding;
    private AlbumPresenterInterface.Presenter presenter;

    private LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAlbumsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new AlbumPresenter(this);

        binding.toolbarAlbums.setTitle(R.string.albums);
        binding.toolbarAlbums.setNavigationOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });


        binding.albumsBtnSearchAll.setOnClickListener(view -> {
            presenter.getAllAlbums();
        });

        llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.rvAlbums.setLayoutManager(llm);

    }


    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void setAlbumsAdapter(RecyclerView.Adapter adapter) {
        binding.rvAlbums.setAdapter(adapter);
    }
}