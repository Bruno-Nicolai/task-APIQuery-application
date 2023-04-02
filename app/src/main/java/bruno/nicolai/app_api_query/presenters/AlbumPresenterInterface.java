package bruno.nicolai.app_api_query.presenters;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

public interface AlbumPresenterInterface {

    interface View {

        public Context getContext();

        public void setAlbumsAdapter(RecyclerView.Adapter adapter);

    }

    interface Presenter {
        public void getAllAlbums();
    }
}
