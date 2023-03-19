package bruno.nicolai.app_api_query.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import bruno.nicolai.app_api_query.models.Album;

public class AlbumRepository {

    private Map<Integer, Album> albumsMap;

    private static AlbumRepository instance = null;

    private AlbumRepository() {
        this.albumsMap = new HashMap<>();
    }

    public static AlbumRepository getInstance() {
        if (instance == null) {
            instance = new AlbumRepository();
        }
        return instance;
    }

    public void addAlbum(Album album) {
        if (album != null) {
            this.albumsMap.put(album.getId(), album);
        }
    }

    public boolean contains(Album album) {
        return this.albumsMap.containsValue(album);
    }

    public boolean contains(Integer id) {
        return this.albumsMap.containsKey(id);
    }

    public Collection<Album> getAlbums() {
        return this.albumsMap.values();
    }

}
