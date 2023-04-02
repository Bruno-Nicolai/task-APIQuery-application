package bruno.nicolai.app_api_query.presenters;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

public interface TodoPresenterInterface {

    interface View {

        public Context getContext();

        public void setTodosAdapter(RecyclerView.Adapter adapter);

    }

    interface Presenter {
        public void getAllTodos();
    }
}
