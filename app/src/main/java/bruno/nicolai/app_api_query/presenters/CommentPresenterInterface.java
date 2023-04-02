package bruno.nicolai.app_api_query.presenters;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

public interface CommentPresenterInterface {

    interface View {

        public Context getContext();

        public void setCommentsAdapter(RecyclerView.Adapter adapter);

    }

    interface Presenter {
        public void getAllComments();
    }
}
