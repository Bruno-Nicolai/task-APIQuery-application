package bruno.nicolai.app_api_query.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import bruno.nicolai.app_api_query.R;
import bruno.nicolai.app_api_query.models.Album;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.ViewHolder> {

    private List<Album> albumsList;

    public AlbumsAdapter(List<Album> albumsList) {
        this.albumsList = albumsList;
    }

    @NonNull
    @Override
    public AlbumsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_album, parent, false);

        return new AlbumsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album = albumsList.get(position);
        ((TextView) holder.view.findViewById(R.id.tv_title_album)).setText(album.getTitle());
    }

    @Override
    public int getItemCount() {
        return albumsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.view = itemView;
        }
    }
}