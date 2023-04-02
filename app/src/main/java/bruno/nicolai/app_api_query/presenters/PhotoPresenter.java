package bruno.nicolai.app_api_query.presenters;

import java.util.ArrayList;

import bruno.nicolai.app_api_query.adapters.CommentsAdapter;
import bruno.nicolai.app_api_query.adapters.PhotosAdapter;
import bruno.nicolai.app_api_query.repositories.CommentRepository;
import bruno.nicolai.app_api_query.repositories.PhotoRepository;
import bruno.nicolai.app_api_query.services.CommentService;
import bruno.nicolai.app_api_query.services.PhotoService;

public class PhotoPresenter implements PhotoPresenterInterface.Presenter {

    PhotoPresenterInterface.View view;
    public PhotoPresenter(PhotoPresenterInterface.View view) {
        this.view = view;
    }

    @Override
    public void getAllPhotos() {

        PhotoService.getAllPhotos(view.getContext(), () -> {

            PhotosAdapter adapter = new PhotosAdapter(new ArrayList(PhotoRepository.getInstance().getPhotos()));
            view.setPhotosAdapter(adapter);

        });

    }
}
