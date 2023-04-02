package bruno.nicolai.app_api_query;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import bruno.nicolai.app_api_query.adapters.PhotosAdapter;
import bruno.nicolai.app_api_query.adapters.TodosAdapter;
import bruno.nicolai.app_api_query.databinding.ActivityPhotosBinding;
import bruno.nicolai.app_api_query.models.Photo;
import bruno.nicolai.app_api_query.repositories.PhotoRepository;
import bruno.nicolai.app_api_query.repositories.TodoRepository;
import bruno.nicolai.app_api_query.services.PhotoService;

public class PhotosActivity extends AppCompatActivity {

    private ActivityPhotosBinding binding;
    private List<Photo> photos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhotosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbarPhotos.setTitle(R.string.user);
        binding.toolbarPhotos.setNavigationOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });


        binding.photosBtnSearchAll.setOnClickListener(view -> {
            getAllPhotos();
        });

    }


    private void getAllPhotos() {

        PhotoService.getAllPhotos(this, () -> {
            PhotosAdapter adapter = new PhotosAdapter(new ArrayList(PhotoRepository.getInstance().getPhotos()));
            binding.rvPhotos.setAdapter(adapter);

//            GridLayoutManager llmg = new GridLayoutManager(this, 2);
//            binding.rvPhotos.setLayoutManager(llmg);
            LinearLayoutManager llmh = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            binding.rvPhotos.setLayoutManager(llmh);

        });

    }
}