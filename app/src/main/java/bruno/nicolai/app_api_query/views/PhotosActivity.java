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
import bruno.nicolai.app_api_query.adapters.PhotosAdapter;
import bruno.nicolai.app_api_query.databinding.ActivityPhotosBinding;
import bruno.nicolai.app_api_query.models.Photo;
import bruno.nicolai.app_api_query.presenters.PhotoPresenter;
import bruno.nicolai.app_api_query.presenters.PhotoPresenterInterface;
import bruno.nicolai.app_api_query.repositories.PhotoRepository;
import bruno.nicolai.app_api_query.services.PhotoService;

public class PhotosActivity extends AppCompatActivity implements PhotoPresenterInterface.View {

    private ActivityPhotosBinding binding;
    private PhotoPresenterInterface.Presenter presenter;

    LinearLayoutManager llmh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhotosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new PhotoPresenter(this);

        binding.toolbarPhotos.setTitle(R.string.user);
        binding.toolbarPhotos.setNavigationOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });


        binding.photosBtnSearchAll.setOnClickListener(view -> {
            presenter.getAllPhotos();
        });

//        GridLayoutManager llmg = new GridLayoutManager(this, 2);
//        binding.rvPhotos.setLayoutManager(llmg);
        llmh = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        binding.rvPhotos.setLayoutManager(llmh);

    }


    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void setPhotosAdapter(RecyclerView.Adapter adapter) {
            binding.rvPhotos.setAdapter(adapter);
    }
}
