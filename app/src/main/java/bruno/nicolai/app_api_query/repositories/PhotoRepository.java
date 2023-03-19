package bruno.nicolai.app_api_query.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import bruno.nicolai.app_api_query.models.Photo;

public class PhotoRepository {

    private Map<Integer, Photo> photosMap;

    private static PhotoRepository instance = null;

    private PhotoRepository() {
        this.photosMap = new HashMap<>();
    }

    public static PhotoRepository getInstance() {
        if (instance == null) {
            instance = new PhotoRepository();
        }
        return instance;
    }

    public void addPhoto(Photo photo) {
        if (photo != null) {
            this.photosMap.put(photo.getId(), photo);
        }
    }

    public boolean contains(Photo photo) {
        return this.photosMap.containsValue(photo);
    }

    public boolean contains(Integer id) {
        return this.photosMap.containsKey(id);
    }

    public Collection<Photo> getPhotos() {
        return this.photosMap.values();
    }

}
