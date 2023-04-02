package bruno.nicolai.app_api_query.presenters;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import bruno.nicolai.app_api_query.adapters.UsersAdapter;
import bruno.nicolai.app_api_query.repositories.UserRepository;

public interface UserPresenterInterface {

    interface View {

        public Context getContext();

        public void setUsersAdapter(RecyclerView.Adapter adapter);

    }

    interface Presenter {
        public void getAllUsers();
    }
}
