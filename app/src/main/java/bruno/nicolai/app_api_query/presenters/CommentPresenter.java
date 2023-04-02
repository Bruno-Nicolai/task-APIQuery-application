package bruno.nicolai.app_api_query.presenters;

import java.util.ArrayList;

import bruno.nicolai.app_api_query.adapters.CommentsAdapter;
import bruno.nicolai.app_api_query.repositories.CommentRepository;
import bruno.nicolai.app_api_query.services.CommentService;

public class CommentPresenter implements CommentPresenterInterface.Presenter {

    CommentPresenterInterface.View view;
    public CommentPresenter(CommentPresenterInterface.View view) {
        this.view = view;
    }

    @Override
    public void getAllComments() {

        CommentService.getAllComments(view.getContext(), () -> {

            CommentsAdapter adapter = new CommentsAdapter(new ArrayList(CommentRepository.getInstance().getComments()));
            view.setCommentsAdapter(adapter);

        });

    }
}
