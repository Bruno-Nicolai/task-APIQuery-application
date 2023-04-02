package bruno.nicolai.app_api_query.presenters;

import java.util.ArrayList;

import bruno.nicolai.app_api_query.adapters.AlbumsAdapter;
import bruno.nicolai.app_api_query.adapters.CommentsAdapter;
import bruno.nicolai.app_api_query.repositories.AlbumRepository;
import bruno.nicolai.app_api_query.repositories.CommentRepository;
import bruno.nicolai.app_api_query.services.AlbumService;
import bruno.nicolai.app_api_query.services.CommentService;

public class AlbumPresenter implements AlbumPresenterInterface.Presenter {

    AlbumPresenterInterface.View view;
    public AlbumPresenter(AlbumPresenterInterface.View view) {
        this.view = view;
    }

    @Override
    public void getAllAlbums() {

        AlbumService.getAllAlbums(view.getContext(), () -> {

            AlbumsAdapter adapter = new AlbumsAdapter(new ArrayList(AlbumRepository.getInstance().getAlbums()));
            view.setAlbumsAdapter(adapter);

        });

    }
}
