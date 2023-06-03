package bruno.nicolai.app_api_query.presenters;

import java.util.Collections;
import java.util.List;

import bruno.nicolai.app_api_query.adapters.UsersAdapter;
import bruno.nicolai.app_api_query.models.User;
import bruno.nicolai.app_api_query.repositories.UserRepository;
import bruno.nicolai.app_api_query.services.UserService;

public class UserPresenter implements UserPresenterInterface.Presenter {

    private UserPresenterInterface.View view;

    public UserPresenter(UserPresenterInterface.View view) {
        this.view = view;
    }

    @Override
    public void getAllUsers() {
        UserService.getAllUsers(view.getContext(), () -> {
            List<User> users = UserRepository.getInstance().getUsers();
//            List<User> sortedUsers = sortUsers(users, User.getSortOrder());
            UsersAdapter adapter = new UsersAdapter(users);
            view.setUsersAdapter(adapter);
        });
    }



}
