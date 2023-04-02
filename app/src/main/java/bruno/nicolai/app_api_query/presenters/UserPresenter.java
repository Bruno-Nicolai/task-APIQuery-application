package bruno.nicolai.app_api_query.presenters;

import java.util.ArrayList;

import bruno.nicolai.app_api_query.adapters.UsersAdapter;
import bruno.nicolai.app_api_query.repositories.UserRepository;
import bruno.nicolai.app_api_query.services.UserService;

public class UserPresenter implements PresenterInterface.Presenter {

    PresenterInterface.View view;
    public UserPresenter(PresenterInterface.View view) {
        this.view = view;
    }

    @Override
    public void getAllUsers() {

        UserService.getAllUsers(view.getContext(), () -> {

            UsersAdapter adapter = new UsersAdapter(new ArrayList(UserRepository.getInstance().getUsers()));
            view.setUsersAdapter(adapter);

        });

    }

}
