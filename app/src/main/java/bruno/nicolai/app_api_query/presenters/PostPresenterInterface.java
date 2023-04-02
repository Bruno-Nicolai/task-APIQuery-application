package bruno.nicolai.app_api_query.presenters;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

public interface PostPresenterInterface {

    interface View {

        public Context getContext();

        public void setPostsAdapter(RecyclerView.Adapter adapter);

    }

    interface Presenter {
        public void getAllPosts();
    }
}
