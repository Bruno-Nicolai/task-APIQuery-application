package bruno.nicolai.app_api_query.presenters;

import java.util.ArrayList;

import bruno.nicolai.app_api_query.adapters.PostsAdapter;
import bruno.nicolai.app_api_query.repositories.PostRepository;
import bruno.nicolai.app_api_query.services.PostService;

public class PostPresenter implements PostPresenterInterface.Presenter {

    PostPresenterInterface.View view;

    public PostPresenter(PostPresenterInterface.View view) {
        this.view = view;
    }

    @Override
    public void getAllPosts() {

        PostService.getAllPosts(view.getContext(), () -> {

            PostsAdapter adapter = new PostsAdapter(new ArrayList(PostRepository.getInstance().getPosts()));
            view.setPostsAdapter(adapter);

        });

    }

}
