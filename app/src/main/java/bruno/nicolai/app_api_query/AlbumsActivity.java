package bruno.nicolai.app_api_query;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import bruno.nicolai.app_api_query.databinding.ActivityAlbumsBinding;
import bruno.nicolai.app_api_query.models.Album;
import bruno.nicolai.app_api_query.repositories.AlbumRepository;
import bruno.nicolai.app_api_query.services.AlbumService;

public class AlbumsActivity extends AppCompatActivity {

    private ActivityAlbumsBinding binding;
    private List<Album> album = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAlbumsBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_albums);

        binding.toolbarAlbums.setTitle(R.string.user);
        binding.toolbarAlbums.setNavigationOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });


        binding.albumsBtnSearchAll.setOnClickListener(view -> {
            getAllAlbums();
        });

    }


    private void getAllAlbums() {

        AlbumService.getAllAlbums(this, () -> System.out.println("API: " + AlbumRepository.getInstance().getAlbums()));

    }
}