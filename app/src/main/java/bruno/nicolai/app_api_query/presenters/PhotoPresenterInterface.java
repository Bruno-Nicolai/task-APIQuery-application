package bruno.nicolai.app_api_query.presenters;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

public interface PhotoPresenterInterface {

    interface View {

        public Context getContext();

        public void setPhotosAdapter(RecyclerView.Adapter adapter);

    }

    interface Presenter {
        public void getAllPhotos();
    }
}
